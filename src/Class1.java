import java.lang.reflect.Field;
import java.util.HashMap;

public class Class1 {
    public static void inspectHashMap(HashMap<?, ?> map) throws Exception {
        // Get the table field (array of buckets) using reflection
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map);

        if (table == null) {
            System.out.println("The HashMap's internal table is not initialized yet.");
            return;
        }

        // Iterate over the buckets
        for (int i = 0; i < table.length; i++) {
            Object bucket = table[i];
            if (bucket != null) {
                System.out.println("Bucket " + i + ":");
                // Get the next field (linked list or tree) using reflection
                Field nextField = bucket.getClass().getDeclaredField("next");
                nextField.setAccessible(true);
                while (bucket != null) {
                    // Get the key and value fields using reflection
                    Field keyField = bucket.getClass().getDeclaredField("key");
                    keyField.setAccessible(true);
                    Field valueField = bucket.getClass().getDeclaredField("value");
                    valueField.setAccessible(true);

                    Object key = keyField.get(bucket);
                    Object value = valueField.get(bucket);
                    System.out.println("  Key: " + key + ", Value: " + value);

                    // Move to the next entry in the linked list or tree
                    bucket = nextField.get(bucket);
                }
            } else {
                System.out.println("Bucket " + i + ": empty");
            }
        }
    }
}