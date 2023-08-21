import java.util.ArrayList;
import java.util.List;
public class Partition {
    private String wordPattern;
    private List<String> wordList;
    public Partition(String pattern) {
        this.wordPattern = pattern;
        this.wordList = new ArrayList<>();
    }

    public Partition(String pattern, String word) {
        this.wordPattern = pattern;
        this.wordList = new ArrayList<>();
        this.wordList.add(word);
    }

    public boolean addIfMatches(String word) {
        if (wordPattern.equals(getPattern(word))) {
            wordList.add(word);
            return true;
        }
        return false;
    }

    public List<String> getWords() {
        return wordList;
    }

    public int getPatternDashCount() {
        return (int) wordPattern.chars().filter(c -> c == '-').count();
    }

    private String getPattern(String word) {
        if (word.length() != wordPattern.length()) {
            return "";
        }
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < wordPattern.length(); i++) {
            if (wordPattern.charAt(i) == '-') {
                pattern.append("-");
            } else if (wordPattern.charAt(i) == word.charAt(i)) {
                pattern.append(word.charAt(i));
            } else {
                return "";
            }
        }
        return pattern.toString();
    }
}

