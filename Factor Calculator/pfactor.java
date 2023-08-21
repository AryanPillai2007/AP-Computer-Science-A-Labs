import java.util.Scanner;
public class pfactor {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        number = sc.nextInt();
        while (number != 0) {
            printPrimes(number);
            System.out.println("Enter a number: ");
            number = sc.nextInt();
        }
    }
    public static void printPrimes(int number) {
            for (int i = 2; i < number; i++) {
                while (number % i == 0) {
                    System.out.print(i + " ");
                    number = number / i;
                }
            }
        if (number > 2) {
            System.out.println(number);
        }
    }
}


