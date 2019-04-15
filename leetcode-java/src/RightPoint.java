import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Kevin Phillips
 * @since 4/10/19
 */


public class RightPoint {


    public static void main(String args[]) {
//        int n = 100;
//        Print starting at 0 or 1 ??

/*        IntStream intStream = IntStream.rangeClosed(1,100);
        Stream<IntStream> streamStream = IntStream.rangeClosed(1,100);

//        Stream<BigInteger> stream = intStream.mapToObj(BigInteger::valueOf);
        stream.forEach(b -> System.out.println(b.multiply(BigInteger.TEN)));*/

// ******
// Use objects or use recursion
// ******
//        intStream.forEach(n -> n.);

              IntStream intStream = IntStream.rangeClosed(1,100);
        Object[] array = intStream
                .boxed().toArray();
        List list;
        IntStream.rangeClosed(1,100)
//                .flatMap(.filter(n->(n%3==0)))
//                .filter(n->(n %3 == 0))
//                .filter(n->(n %5 == 0))
//                .flatMap(n -> "right")
//                .map(n -> (n / 3))
//                .filter(x -> x % 3 == 0).boxed().collect(Collectors.toList())
//                .map(i -> i*3)
                .map(n -> n % 3)
//                .mapToObj()
//                .forEach(n -> n %3 ==0)
                .forEach(System.out::println);
//                .filter(i-> i%3 == 0);

//        IntStream sum = IntStream.range(1, 100)


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

/*    IntStream ints = Arrays.stream(new int[] {1,2,3,4,5});
    List<Integer> intsList;
            ints.map(x-> x*x)
//                    .collect()
//            .collect(intsList::add);
            .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);*/
    }
}

