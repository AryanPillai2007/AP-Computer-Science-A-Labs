import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("players.txt"));
        int liberty1 = scanner.nextInt();
        Team liberty = new Team(liberty1);
        for (int i = 0; i < liberty1; i++)

            liberty.players[i] = new battingAverage(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        liberty.printTeamStats();
    }
}