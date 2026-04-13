/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part1;

/**
 *
 * @author Katleho Kulube
 */
import java.util.Scanner;
import java.util.regex.Pattern;

class Login {

    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;
    
        public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(regex, password);
    }

    public boolean checkCellPhoneNumber(String phone) {
        // Reference: https://regexlib.com (International phone format inspiration)
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, phone);
    }

    public String registerUser(String username, String password, String phone,
                               String firstName, String lastName) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;

        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully captured.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
public class Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        
                // 🔹 Registration Section
        System.out.println("===== REGISTRATION =====");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Phone Number (+27...): ");
        String phone = scanner.nextLine();

        String registrationResult = login.registerUser(username, password, phone, firstName, lastName);
        System.out.println("\n" + registrationResult);

        // 🔹 Login Section
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        boolean isLoggedIn = login.loginUser(loginUsername, loginPassword);

        System.out.println(login.returnLoginStatus(isLoggedIn));

        scanner.close();
        
    }
    
}
