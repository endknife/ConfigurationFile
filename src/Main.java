import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ConfigurationFile config = new ConfigurationFile("config.yml");

        System.out.println(config.getArray("array", 0));

        String[] arr = config.getArray("array");

        System.out.println(arr[0]);
    }
}