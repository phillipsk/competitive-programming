import java.util.Collection;
import java.util.Hashtable;

public class SalesByMatch {


    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for (Integer i : ar) {
            table.compute(i, (key, value) -> (value == null ? 1 : value + 1));
        }

        Collection<Integer> ans = table.values();
        Integer a = ans.stream()
                .map(i -> i / 2)
                .reduce(0, Integer::sum);

//        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        sockMerchant(n, ar);
    }
}
