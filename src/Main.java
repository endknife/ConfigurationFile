import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ConfigurationFile config = new ConfigurationFile("config.yml");

        System.out.println(config.toString());

        config.saveFile();
    }
}