import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {


        // Create a HashMap with a specific capacity
        HashMap<KeyClass, String> map = new HashMap<>(16, 0.75f); // 16 buckets

        // Create a custom key with a specific hash code
        KeyClass key = new KeyClass(9); // This will go to bucket = value, according to the HashCode function in KeyClass.

        // Put the key-value pair in the map
        map.put(key, "Value");

        // Retrieve the value to verify
        System.out.println("Value: " + map.get(key));

        Class1.inspectHashMap(map);


    }
}