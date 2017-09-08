package sfd;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by dela on 9/8/17.
 */
public class test {
    public static void main(String[] args){
        String test = null;
        Scanner scanner = new Scanner(System.in);

        while(true){
            test = scanner.next();

            if (!Pattern.matches("0\\d1\\d{5}$", test)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}
