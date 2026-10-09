
import java.util.*;

public class MostPopularCanteenOrder {
    static void mostPopular(String[] orders) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        String best = orders[0];
        int max = count.get(best);

        for (String item : orders) {
            if (count.get(item) > max) {
                best = item;
                max = count.get(item);
            }
        }

        System.out.println("(\"" + best + "\", " + max + ")");
    }

    public static void main(String[] args) {
        String[] a = {
            "dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"
        };

        String[] b = {"tea", "coffee", "coffee", "tea"};

        mostPopular(a);
        mostPopular(b);
    }
}
