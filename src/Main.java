import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        ConfigurationFile config = new ConfigurationFile("config.yml");

        System.out.println(config.getString("name"));
        System.out.println(config.getString("surname"));
        System.out.println(config.getString("age"));

        config.modifyString("age", "20");

        config.deleteString("name");

        config.add("job", "none");

        System.out.println(config.getArray("array", 3));

        String[] arr = config.getArray("array");

        System.out.println(arr[0]);

        System.out.println(config.toString());
    }
}