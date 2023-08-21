import java.util.Scanner;

class TextCemetery {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.next();
        Cemetery ts = new Cemetery(fileName);
        ts.readData();
        ts.averageAge();

        sc.close();

    }
}