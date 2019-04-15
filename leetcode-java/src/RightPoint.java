import java.util.stream.IntStream;

/**
 * @author Kevin Phillips
 * @since 4/10/19
 */

public class RightPoint {

    /*
    Write a program in your language of choice that prints the numbers from 1 to 100.
    But for multiples of three print “right” instead of the number and for the multiples of five print “point”.
    For numbers which are multiples of both three and five print “rightpoint”.
    **/

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> i % 3 == 0 && i % 5 == 0 ? "rightpoint"
                        : i % 3 == 0 ? "right"
                        : i % 5 == 0 ? "point" : i)
                .forEach(System.out::println);
    }
}

