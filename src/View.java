import java.util.Scanner;

public class View {
    public static int menu(){
        System.out.println("=".repeat(40));
        System.out.println("1. Add new course");
        System.out.println("2. List all courses");
        System.out.println("3. Get course by ID");
        System.out.println("0. EXIT");
        System.out.println("=".repeat(40));
        System.out.print("[+] Insert option: ");
        return new Scanner(System.in).nextInt();
    }
}
