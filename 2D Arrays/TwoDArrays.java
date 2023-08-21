public class TwoDArrays {
    private int[][] nums;

    public TwoDArrays(int[][] myNumbers) {
        this.nums = myNumbers;
    }

    public int sum() {
        int sum = 0;
        for (int[] s : nums) {
            for (int po : s) {
                sum += po;
            }

        }
        return sum;
    }

    public boolean isSquare() {
        return nums.length == nums[0].length;
    }

    public boolean inSequence() {
        if (isSquare() == true) {
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int x = 0; x < nums[i].length; x++) {
                    if (nums[i][x] == c + 1) {
                        c++;

                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public int[] closestToZero() {

        int indexRows = 0;
        int indexColumns = 0;
        int closetValue = 0;
        int temp = nums[0][0];


        for (int i = 0; i < nums.length; ++i) {

            for (int j = 0; j < nums[i].length; ++j) {
                closetValue = Math.abs(nums[i][j]);
                if (temp > closetValue) {
                    temp = closetValue;
                    indexRows = i;
                    indexColumns = j;
                }

            }
        }

        return new int[]{indexRows, indexColumns};
    }

    public void  addMatrix(int[][] other) {


        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums[i].length; ++j) {
                nums[i][j] += other[i][j];

            }
        }


    }

    public void print() {
        for (int[] num : nums){
            for (int j = 0;j < nums[0].length;j++){
                System.out.println(num[j]);
            }
        }


    }


    public int columnSum(int col) {

        int columnSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums[i].length; ++j) {
                if (j == col) {
                    columnSum = columnSum + nums[i][j];
                }
            }
        }
        return columnSum;

    }

    public boolean isColumnMagic() {

        int sum = 0;
        int previousColumnSum = 0;
        boolean magicColumn = true;

        for (int i = 0; i < nums.length; ++i) {


            sum = columnSum(i);
            if (i != 0) {
                if (sum != previousColumnSum) {
                    magicColumn = false;
                    break;
                }
            }
            previousColumnSum = sum;

        }


        return magicColumn;
    }
    public boolean sameDiagonalSums(){
        int one = 0;
        int two = 0;
        int count = nums.length-1;
        for (int i = 0;i<nums.length;i++){
            one += nums[i][i];
            two += nums [count][i];
        }

        return one == two;
    }
}