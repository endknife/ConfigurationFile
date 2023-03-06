import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ConfigurationFile config = new ConfigurationFile("config.yml");


        System.out.println(config);
        String[] frutta = {"fragole", "banane", "mango"};

        config.add("frutti", frutta);

        System.out.println(config.toString());

        config.saveFile();

        System.out.println(config.getArray("frutti", 0));

    }
}