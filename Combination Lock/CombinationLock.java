import java.util.Scanner;

public class CombinationLock extends Lock{
    String combination;

    public CombinationLock(){
        super();
        combination = "";
    }

    public CombinationLock(String combo){
        super();
        combination = combo;
    }

    void open(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the combination: ");
        String combo = input.next();
        if(combo.equals(combination)){
            super.open();
        }
    }

    public String toString(){
        return super.toString() + "\n" + "Combination = " + combination + "\n";
    }

    public void setCombination(String c){
        combination = c;
    }

    public String getCombination() {
        return combination;
    }
}
