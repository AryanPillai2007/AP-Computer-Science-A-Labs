import java.util.Arrays;
public class SoundProbs {
    public static void main(String[] args) throws Exception
    {
        triangle(7);
        System.out.println(lastIndexOf(new int[] {8,2,4,6,8} , 8));
        System.out.println(lastIndexOf(new int[] {2,4,6,12} , 8)); 
        System.out.println(range(new int[] {8, 3, 5, 7, 2, 4}));
        System.out.println(range(new int[] {15, 22, 8, 19, 31}));
        System.out.println(minDifference(new int[] {4, 8, 6, 1, 5, 9, 4}));
        System.out.println(priceIsRight(new int[] {900, 885, 990, 1}, 800));
        System.out.println(priceIsRight(new int[] {1500, 1600, 2000, 2500}, 1900));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
    }
    public SoundProbs() {

    }
    public static void triangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static int lastIndexOf(int[] nums, int value) {
        int ind= 0;
        int num1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                ind = i;
                num1++;
            }
        }
        if (num1 == 0) {
            return -1;
        } else {
            return ind;
        }
    }
    public static int range(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        return max - min;
    }
    public static int minDifference(int[] nums) {
        int diff = 100000000;
        for (int i = 0; i < nums.length - 1; i++) {
            if (diff > Math.abs(nums[i] - nums[i + 1])) {
                diff = Math.abs(nums[i] - nums[i + 1]);
            }
        }
        return diff;
    }
    public static int priceIsRight(int[] bids, int price) {
        int min = -1;
        for (int i = 0; i < bids.length; i++) {
            if (bids[i] < price) {
                if (min < 0 && bids[i] < price) {
                    min = bids[i];
                } else if (bids[i] > min) {
                    min = bids[i];
                }
            }
        }
        return min;
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int x = 0; x < nums.length; x++) {
            int a = 1;
            for (int y = 0; y < nums.length; y++) {
                a *= nums[y];
            }
            a/= nums[x];
            result[x] = a;
        }
        return result;
    }
}
