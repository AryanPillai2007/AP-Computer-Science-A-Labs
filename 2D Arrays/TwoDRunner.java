import java.util.Arrays;
public class TwoDRunner {
    public static void main (String[] args){

        System.out.println(new TwoDArrays(new int[][]{{1, 2}, {10, 11}}).sum());
        System.out.println(new TwoDArrays(new int[][] {{2, 3, 1}, {5,4,6}}).isSquare());
        System.out.println(new TwoDArrays(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).inSequence());
        System.out.println(Arrays.toString(new TwoDArrays(new int[][] {{3, 1, 5, 7}, {4, 12, -3, 8}, {6,7}}).closestToZero()));
        TwoDArrays a = new TwoDArrays(new int[][]{{1, 2, 3}, {3, 2, 1}});
        a.addMatrix(new int[][]{{2,3, 1}, {3,1,2}});
        a.print();
        int sum = new TwoDArrays(new int[][] {{1, 2, 3}, {4, 5, 6}, {6}}).columnSum(2);
        System.out.println(sum);
        boolean isMagic = new TwoDArrays(new int[][]{{1, 2, 3}, {1}, {2, 2, 1}}).isColumnMagic();
        System.out.println(isMagic);
        System.out.println(new TwoDArrays(new int[][] {{1, 2, 3}, {3, 2, 1}, {7, 2, 2}}).sameDiagonalSums());
        System.out.println(new TwoDArrays(new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}).sameDiagonalSums());
    }
}