
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigurationFile {

    private static final String REMOVE = "    ";
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    private File file;
    private HashMap<String, String> data;

    /**
     * <b>ConfigurationFile()</b> is a class that creates you a configuration file.
     * After that you create the object in your main fail you can use the various methods
     * to <b>manage</b> a config file.
     * <br></br>
     * <br></br>
     * Created by ogaz
     * <br></br>
     *
     * @param path
     */
    ConfigurationFile(String path) {
        try{
            this.file = new File(path);

            if(file.createNewFile()){
                System.out.println(BLUE + "File created: " + file.getName() + " in the following path: " + file.getAbsolutePath() + RESET);
            }else{
                System.out.println(GREEN + "Preparing file variables of " + file.getName() + RESET);
            }

            this.data = new HashMap<>();
            if(!isEmpty()){
                readFile();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @return if the fiele is empty
     */
    public boolean isEmpty(){
        return file.length() == 0;
    }

    /**
     * Saves the variables that are saved in your system memory in the selected file. Use it after that you end the program!
     */
    public void saveFile(){
        writeFile();
    }

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
     * private function that is made to read the file line by line and saved the information in a hashMap that is named data.
     */
    private void readFile(){
        try {
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);

            //TODO devo migliorare la decodifica delle variabili dal file (oggetti), problemi con l'aggiornamento del path, se passo da un ogetto interno a esteron il mio algorittmo non capisce
            /*
            lo StringBuilder PATH contiene la path aggiornata della variabile
            esempio:

            --FILE--
            Macchine:
                Porsche:
                    Modelli:
                        911:
                            cavalli: "190"
                            creata: "15/08/98"
                            cilindrata: "3000"
                            kW: "80"
                            ingenniere: "Fabio Gustavo"

             --OUTPUT DELLE VATIE VARIABILI--
             Macchine.Porsche.Modelli.911.cavalli: "190"
             Macchine.Porsche.Modelli.911.creata: "15/08/98"
             Macchine.Porsche.Modelli.911.cilindrata: "3000"
             Macchine.Porsche.Modelli.911.kW: "80"
             Macchine.Porsche.Modelli.911.ingenniere: "Fabio-Gustavo"
             */
            StringBuilder path = new StringBuilder();

            int couneter = 0;
            int builder = 0;

            while(scanner.hasNextLine()){
                couneter++;
                System.out.println(RED + "couneter: " + couneter + RESET);
                String line = scanner.nextLine();

                /*
                1) Verifica se la lunghezza è diversa da zero
                2) Verifica se è un commento o meno
                3) Se la linea estratta dal file contiene un tab viene usata la funzione replace che rimpiazza il tab con nulla (REMOVE)
                 */
                if(line.length() != 0){

                    if(line.charAt(0) != '#'){
                        if(line.contains(REMOVE)){
                            line = line.replace(REMOVE, "");
                        }else{

                        }

                        //Split delle stringhe in un array delimitato dallo spazzio " ".
                        String[] split = line.split(" ");

                        System.out.println(split.length);

                        //Se l'array è lungo soltanto uno, significa che è un'oggetto, sennò un'attributo.
                        //se oggetto aggiunge al path il nome dell'ogetto mettendoci un punto alla fine.
                        //se invece trova un'attributo lo aggiunge per poi toglierlo (non mi so spiegare)
                        if(split.length == 1){
                            //System.out.println("ogetto");
                            path.append(split[0].replace(":", "") + ".");
                            builder = path.length();
                        }else{
                            //System.out.println("attributo");
                            path.append(split[0].replace(":", ""));

                            data.put(path.toString(), split[1].replace("\"", ""));
                            System.out.println(path);

                            path.delete(builder, path.length());
                        }
                    }else{
                        System.out.println(YELLOW + "A comment at line: " + couneter + " has been found!" + RESET);
                    }
                }
           }

            fr.close();
            scanner.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * private function that writes the information in the hashMap named data in the file.
     */
    private void writeFile(){
        try{
            FileWriter fw = new FileWriter(file);

            for ( String key : data.keySet() ) {
                fw.write(key + ": \"" + data.get(key) + "\"\n");
            }
            fw.flush();
            fw.close();
        }catch (IOException e){

        }
    }

    /**
     * Adds the data in a hashMap
     * @param path
     * @param value
     */
    public void add(String path, String value){
        data.put(path, value);
    }

    public void deleteString(String path){
        data.remove(path);
    }

    public void modifyString(String path, String value){
        data.put(path, value);
    }

    //TODO there is a problem, if i save the data in the data hashMap i can't understand if it is a string or a integer
    public void add(String path, int value){
        data.put(path, String.valueOf(value));
    }

    public String getString(String path){
        return data.get(path);
    }

    public int getInteger(String path){
        return Integer.parseInt(data.get(path));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for ( String key : data.keySet() ) {
            str.append(key + ": " + data.get(key) + "\n");
        }

        return str.toString();
    }
}

