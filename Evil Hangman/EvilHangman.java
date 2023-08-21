import java.util.*;
import java.io.*;

public class EvilHangman {
    private boolean debug;
    private Scanner in;
    private ArrayList<String> wordList;
    private int wordLength;
    private int remainingGuesses;
    private String solution;
    private String guessedLetters;

    public EvilHangman(String filename, boolean debug) {
        this.debug = debug;
        in = new Scanner(System.in);
        inputWords(filename);
        System.out.print("Number of guesses? ");
        remainingGuesses = in.nextInt();
        solution = "-".repeat(wordLength);
        guessedLetters = "";
    }

    public void inputWords(String filename) {
        wordList = new ArrayList<>();
        try {
            Scanner fileIn = new Scanner(new File(filename));
            while (wordList.isEmpty()) {
                System.out.print("Word length? ");
                wordLength = in.nextInt();
                while (fileIn.hasNextLine()) {
                    String word = fileIn.nextLine().toUpperCase();
                    if (word.length() == wordLength) {
                        wordList.add(word);
                    }
                }
                if (wordList.isEmpty()) {
                    System.out.println("There are no words with " + wordLength + " letters.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public String getPattern(String word, String letter) {
        StringBuilder pattern = new StringBuilder();
        for (char c : word.toCharArray()) {
            pattern.append(c == letter.charAt(0) ? c : '-');
        }
        return pattern.toString();
    }

    public ArrayList<Partition> getPartitionList(String letter) {
        ArrayList<Partition> partitions = new ArrayList<>();
        for (String word : wordList) {
            String pattern = getPattern(word, letter);
            boolean found = false;
            for (Partition partition : partitions) {
                if (partition.getPattern().equals(pattern)) {
                    partition.addWord(word);
                    found = true;
                    break;
                }
            }
            if (!found) {
                partitions.add(new Partition(word, pattern));
            }
        }
        return partitions;
    }

    public void removeSmallerPartitions(ArrayList<Partition> partitions) {
        int max = 0;
        for (Partition partition : partitions) {
            if (partition.size() > max) {
                max = partition.size();
            }
        }
        partitions.removeIf(partition -> partition.size() < max);
    }

    public ArrayList<String> getWordsFromOptimalPartition(ArrayList<Partition> partitions) {
        int maxDashes = 0;
        Partition optimalPartition = null;
        for (Partition partition : partitions) {
            int dashes = partition.getPattern().replaceAll("[^\\-]", "").length();
            if (dashes > maxDashes) {
                maxDashes = dashes;
                optimalPartition = partition;
            }
        }
        return optimalPartition.getWords();
    }

    public void substitute(String word, String letter) {
        StringBuilder newSolution = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            newSolution.append(solution.charAt(i) == '-' && word.charAt(i) == letter.charAt(0) ? letter : solution.charAt(i));
        }
        solution = newSolution.toString();
    }

    public void playGame() {
        while (solution.contains("-") && remainingGuesses > 0) {
            System.out.println("\n" + this);
            String letter = inputLetter();
            guessedLetters += letter;
            ArrayList<Partition> partitions = getPartitionList(letter);
            removeSmallerPartitions(partitions);
            wordList = getWordsFromOptimalPartition(partitions);
        }
    }
}