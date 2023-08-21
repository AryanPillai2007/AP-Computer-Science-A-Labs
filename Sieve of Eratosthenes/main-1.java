import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        int n;
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Enter an Number: ");
        n = scanner.nextInt();

        while (n != 0) {
            printFactors(n);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Enter a number: ");
            n = scanner.nextInt();
        }
    }
    public static void printFactors(int n) {
        int count = 0;
        int count1=0;
        int i;
        for (i = 2; i < n; i++) {
            if (n % i == 0) {
                count1++;

            }
        }

        System.out.print("There are " + count1 + " factors for the number " +n+ ": ");
        for (i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                count++;

            }
        }

    }


}