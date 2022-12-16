package IO;

import java.io.PrintWriter;
import java.util.Scanner;

public class Outfile10 {
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("file10.txt");
        Scanner scan = new Scanner(System.in);


        String username;
        String password;
        do {
            System.out.print("Enter a username: ");
            username = scan.next();

            System.out.print("Enter a password: ");
            password = scan.next();

            if (password.equals("happy")) {
                write.println(username);
            }
        } while (!password.equals("quit"));


        write.close();
    }
}
