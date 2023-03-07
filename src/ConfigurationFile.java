import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class ConfigurationFile {

    private static final String REMOVE = "    ";
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

    private File file;
    private HashMap<String, String> data;

    /**
     * <b>ConfigurationFile()</b> is a class that creates a configuration file for you.
     * After you create the object in your main file you can use the methods of the class
     * in order to <b>manage</b> a config file.
     * <br></br>
     *
     * <b>Currently supported data types:</b>
     * <ul>
     *     <li>Variables</li>
     *     <li>Arrays</li>
     * </ul>
     * TODO Finish implementing Objects
     * <br></br>
     * TODO Implement Lists
     *
     * @author ogaz_zago
     *
     * @param path Path of the configuration file
     */
    ConfigurationFile(String path) {
        try{
            this.file = new File(path);

            if(file.createNewFile()) System.out.println(BLUE + "Created file " + file.getName() + " with following path: " + file.getAbsolutePath() + RESET);
            else System.out.println(GREEN + "Preparing variables from file " + file.getName() + RESET);

            this.data = new HashMap<>();
            if(!isEmpty()) readFile();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /** Checks if a file is empty or not
     *
     * @return true or false depending on the file contents being empty or not
     */
    public boolean isEmpty(){ return file.length() == 0; }

    /**
     * Saves the variables from the memory of your system to the selected file. Use it after editing!
     */
    public void saveFile(){ writeFile(); }

    //TODO gestire se ci sono ogetti
    /*
     *esempio:
     *
     * Persona:
     *   nome: "Marco"
     *   eta: 30
     *   sesso: M
     *
     * per ora riesco a gestire tante variabili ma nessun costrutto...
     */
    /**
     * Private function used to read the file line by line and save the information in a hashMap named "data".
     */
    private void readFile(){
        try {
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);

            //TODO devo migliorare la decodifica delle variabili dal file (oggetti), problemi con l'aggiornamento del path, se passo da un ogetto interno a esteron il mio algorittmo non capisce
            StringBuilder path = new StringBuilder();

            int couneter = 0;
            int builder = 0;

            while(scanner.hasNextLine()){
                couneter++;
                //System.out.println(RED + "couneter: " + couneter + RESET);
                String line = scanner.nextLine();

                /*
                1) Verifica se la lunghezza è diversa da zero
                2) Verifica se è un commento o meno
                3) Se la linea estratta dal file contiene un tab viene usata la funzione replace che rimpiazza il tab con nulla (REMOVE)
                 */

                Character value = valueType(line);

                switch (value){
                    case 'O': break;
                    case 'L': break;
                    case 'A': break;
                    case 'V': break;
                    default: break;
                }

                /*
                if(line.length() != 0){

                    if(line.charAt(0) != '#'){
                        if(line.contains(REMOVE)) line = line.replace(REMOVE, "");

                        //Split delle stringhe in un array delimitato dallo spazzio " ".
                        String[] split = line.split(" ");

                        //System.out.println(split.length);

                        //Se l'array è lungo soltanto uno, significa che è un'oggetto, sennò un'attributo.
                        //se oggetto aggiunge al path il nome dell'ogetto mettendoci un punto alla fine.
                        //se invece trova un'attributo lo aggiunge per poi toglierlo (non mi so spiegare)
                        if(split.length == 1){
                            //System.out.println("ogetto");
                            path.append(split[0].replace(":", "")).append(".");
                            builder = path.length();
                        }else{
                            //System.out.println("attributo");
                            if(split[1].charAt(0) == '['){
                                StringBuilder arr = new StringBuilder();
                                for (int i = 1; i < split.length; i++) arr.append(split[i]);
                                data.put(split[0].replace(":", ""), arr.toString());
                            }else{
                                path.append(split[0].replace(":", ""));

                                data.put(path.toString(), split[1].replace("\"", ""));
                                ///System.out.println(path);

                                path.delete(builder, path.length());
                            }
                        }
                    }else{
                        System.out.println(YELLOW + "Found a comment at line " + couneter + RESET);
                    }
                }
                 */
           }

            fr.close();
            scanner.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Character valueType(String str){
        if(str.length() == 0) return null;
        if(str.startsWith("#")) return null;

        String[] args = str.split(" ");
        if(args.length == 1 && Character.isUpperCase(args[0].charAt(0))){
            System.out.println("object");
            return 'O';
        }

        if(args.length == 1 && Character.isLowerCase(args[0].charAt(0))){
            System.out.println("list");
            return 'L';
        }

        if(args.length >= 2 && args[1].startsWith("[") && args[args.length-1].endsWith("]")){
            System.out.println("array");
            return 'A';
        }

        if(args.length == 2){
            System.out.println("variable");
            return 'V';
        }
        return null;
    }

    /**
     * Private function that writes the information from the hashMap named "data" into the file.
     */
    private void writeFile(){
        try{
            FileWriter fw = new FileWriter(file);

            for ( String key : data.keySet() ) {
                String str = key + " " + data.get(key);
                Character value = valueType(str);

                switch (value){
                    case 'O': break;
                    case 'L': break;
                    case 'A': fw.write(key + ": " + data.get(key) + "\n"); break;
                    case 'V': fw.write(key + ": \"" + data.get(key) + "\"\n"); break;
                }
            }
            fw.flush();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteString(String path) { data.remove(path); }

    public void deleteAll(){
        if(isEmpty()) System.out.println(YELLOW + "File is already empty");
        else try {
                FileWriter fr = new FileWriter(file);

                fr.flush();
                fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }
    }

    public void modifyString(String path, String value) { data.put(path, value); }

    //TODO there is a problem, if i save the data in the data hashMap i can't understand if it is a string or a integer
    public void add(String path, int value) { data.put(path, String.valueOf(value)); }

    /**
     * Adds data to a hashMap
     *
     * @param path you can see this as the key most of the times
     * @param value String containing the value
     */
    public void add(String path, String value) { data.put(path, value); }

    public void add(String path, String[] array){
        StringBuilder strB = new StringBuilder();
        //str.append();
        if(array == null){
            System.out.println(RED + "The given array is null!" + RESET);
            return;
        }
        strB.append("[");
        for(String str : array) strB.append("\"").append(str).append("\", ");
        int last = strB.length();
        strB.delete(last-2, last);
        strB.append("]");

        data.put(path, strB.toString());
    }
    public String getString(String path){ return data.get(path); }

    //TODO finish the getArray function
    public String[] getArray(String path) {
        String[] arr = data.get(path).split(",");
        arr[0] = arr[0].replace("[", "");
        arr[arr.length-1] = arr[arr.length-1].replace("]", "");

        for(int i = 0; i< arr.length; i++) arr[i] = arr[i].replaceAll("\"", "").replace(" ", "");

        return arr;
    }

    public String getArray(String path, int n) {
        if(n < 0){
            System.out.println(RED + "Positive integer number requested in order to get the content of an array" + RESET);
            return "null";
        }
        String[] arr = data.get(path).split(",");
        if(n > arr.length-1){
            System.out.println(RED + "The number is too big" + RESET);
            return "null";
        }

        if(n == 0) return arr[0].replace("[", "").replace(" ", "").replaceAll("\"", "");
        if(n == arr.length-1) return arr[arr.length-1].replace("]", "").replace(" ", "").replace("\"", "");
        return arr[n].replace(",", "").replace(" ", "").replace("\"", "");
    }

    //Non lo farò mai
    public int getInteger(String path){
        return Integer.parseInt(data.get(path));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for ( String key : data.keySet() ) str.append(key).append(": ").append(data.get(key)).append("\n");
        return str.toString();
    }
}

