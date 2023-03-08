import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ConfigurationFile config = new ConfigurationFile("config.yml");

        System.out.println(config.toString());

        System.out.println(config.getString("ciao"));

        config.saveFile();
    }
}