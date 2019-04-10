import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Kevin Phillips
 * @since 4/10/19
 */


public class RightPoint {


    public static void main(String args[]) {
//        int n = 100;
//        Print starting at 0 or 1 ??
        IntStream.rangeClosed(1,100)
//                .flatMap(.filter(n->(n%3==0)))
                .filter(n->(n %3 == 0))
//                .flatMap(n -> "right")
//                .map(n -> (n / 3))
                .forEach(System.out::println);
//                .filter(i-> i%3 == 0);

//        IntStream.rangeClosed(1, 100).map(i -> i % 3);

//        LongStream stream = IntStream.range(1, 5).mapToLong(i -> i);


/*        IntStream.range(1, 5)
                .filter(i -> i % 2 == 0)*/

//        int[] a = IntStream.range(1, 100).toArray();
//        int[] a = IntStream.rangeClosed(1, 100).toArray();


        // loop for 100 times
/*        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                System.out.print("FizzBuzz" + " ");
                // number divisible by 5, print 'Buzz'
                // in place of the number
            else if (i % 5 == 0)
                System.out.print("Point" + " ");

                // number divisible by 3, print 'Fizz'
                // in place of the number
            else if (i % 3 == 0)
                System.out.print("Right" + " ");

                // number divisible by 15(divisible by
                // both 3 & 5), print 'FizzBuzz' in
                // place of the number

            else // print the numbers
                System.out.print(i + " ");
        }*/
    }
}

