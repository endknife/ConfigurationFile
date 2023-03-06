import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ConfigurationFile config = new ConfigurationFile("config.yml");

        String[] nomi = {"ale", "ste", "gio", "fra"};

        config.add("nomi", nomi);

        config.saveFile();

        System.out.println("2.0 " + config.getArray("nomi", 2));

        String[] valori = config.getArray("nomi");

        for(String str : valori){
            System.out.println(str);
        }

        System.out.println();

        System.out.println(config.toString());


    }
}