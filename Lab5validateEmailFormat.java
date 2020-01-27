/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5validateemailformat;

import java.util.Scanner;

/**
 *
 * @author Steven Solis
 */
public class Lab5validateEmailFormat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an email account: ");
        String input = scanner.nextLine();
        scanner.close();

        validateEmailFormat(input.trim());
    }

    public static void validateEmailFormat(String email) {

        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");

        if (atIndex == -1) {
            System.out.println("@ character is missing");
            return;
        }
        if (dotIndex == -1) {
            System.out.println(". character is missing");
            return;
        }
        if (atIndex > dotIndex) {
            System.out.println("@ should appear before .");
            return;
        }
        String username = email.substring(0, atIndex);
        for (char ch : username.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                System.out.println("The username should include only letters and/or digits");
                return;
            }
        }

        System.out.println("Correct email address");
    }
}
