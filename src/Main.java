import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu();
    }

    //Menu Methodu
    public static void Menu() {
        System.out.println("-----------Menu--------------");
        System.out.println("1: REGISTER");
        System.out.println("2: SIGN IN");
        System.out.println("3: SIGN OUT");


        System.out.print("Secim Et: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();


        switch (number) {
            case 1:
                SignUp();
                break;
            case 2:
                SignIn();
                break;
            case 3:
                SignOut();
                break;
            default:
                System.out.println("------------------------------");
                System.out.println("Düzgün secim edin!\n");
                Clear();
                Menu();
                break;

        }
    }

    //Clear Method
    public static void Clear() {
        for (int i = 0; i < 3; i++) {
            System.out.println("*********************************");
        }
    }


    //Sign Up Method
    public static void SignUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------SIGN UP--------------");
        System.out.print("Full Name: ");
        String fn = sc.nextLine();
        System.out.print("Enter your email: ");
        String e = sc.nextLine();
        System.out.print("Enter your new password: ");
        String p = sc.nextLine();

        User user = new User(fn, e, p);

        if (user.selectData(e) != 2) {
            if (user.signUp()) {
                System.out.println("Qeydiyyat ugurla bitdi");
            } else {
                System.out.println("Sistemde xeta yarandi");
            }
            Menu();
        } else {
            System.out.println("Istifadeci movcuddur");
            SignUp();
            .
        }
    }

    // Sign In Method
    public static void SignIn() { // və bura bax
        Scanner sc = new Scanner(System.in);
        System.out.println("----------SIGN IN----------");
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        FileDB user = new FileDB("db_users.txt");
        user.sign("", "");


        if (user.sign(email, password)) {
            System.out.println("Sisteme xos geldiniz");
        } else {
            System.out.println("Email ve ya Parol yanlisdir"); // niyə hər iki halda bu nəticəni qaytarır?
            Menu();
        }
    }

    //Sign Out Method
    public static void SignOut() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Sign OUT---------------");
        System.out.println("Çıxış etməyinizə əminsinizmi?");
        String choice = sc.nextLine();
        if (choice.equals("Beli")) {
            System.out.println("****************************");
            System.out.println("Ugurla çıxış edildi!");
        } else {
            System.out.println("Hələ də sistemdəsən!\n");
            Clear();
            Menu();
        }

    }
}