package SimulateLongRunningApp;

import java.io.IOException;

/**
 * @author Kevin Phillips
 * @since 6/4/19
 */


public class Example {

    public static void main(String[] args) throws IOException {
        System.out.println("Hit enter to print a report, x to exit exit.");
        byte[] input = new byte[1];
        while (System.in.read(input) > 0) {
            if (input[0] == 'x') {
                break;
            }
            System.out.println(new Messenger().getMessage());
        }
    }

}