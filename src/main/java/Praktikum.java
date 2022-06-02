import java.util.Scanner;
public class Praktikum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        Account account = new Account(name);

        boolean checkAccount = account.checkNameToEmboss();

        System.out.println(checkAccount);
    }
}