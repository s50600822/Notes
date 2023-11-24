import java.util.Arrays;
import java.io.*;


class Solution {
    /**
     * 2n
     */
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }

        int suffixProduct = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            prefixProduct[i] = prefixProduct[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }

        return prefixProduct;
    }

    /**
     * n^2
     */
    public int[] productExceptSelfNaive(int[] nums) {

        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i =0; i< nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i!=j){
                    res[j] = res[j] * nums[i];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //https://leetcode.com/problems/product-of-array-except-self/
        Solution self = new Solution();// pretend to be python :v
        assert Arrays.equals(
            self.productExceptSelf(new int[]{1,2,3,4}),
            new int[]{24,12,8,6}
        );

        assert Arrays.equals(
            self.productExceptSelf(new int[]{-1,1,0,-3,3}),
            new int[]{0,0,9,0,0}
        );

        assert Arrays.equals(
            self.productExceptSelf(new int[]{2,3,4,5}),
            new int[]{60,40, 30,24}
        );

        int[] huge = readArrayFromFile("i.txt");


        writeArrayToFile(self.productExceptSelf(huge), "huge_out.txt");
    }

    private static int[] readArrayFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] elements = line.split(",");
            int[] array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return new int[0]; // Handle the error according to your needs
        }
    }

    private static void writeArrayToFile(int[] array, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < array.length; i++) {
                writer.write(String.valueOf(array[i]));

                // Add a comma after each element except the last one
                if (i < array.length - 1) {
                    writer.write(",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}