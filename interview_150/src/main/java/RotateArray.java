import java.util.Arrays;

public class RotateArray {

    // https://leetcode.com/problems/rotate-array
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArrayV2(nums, k);
    }

    // Time - O(n^2), Space - O(1)
    private static void rotateArrayV1(int[] nums, int k) {
        k %= nums.length;
        while (k > 0) {
            int prev = nums[0], i, curr;
            for (i = 1; i < nums.length; i++) {
                curr = nums[i];
                nums[i] = prev;
                prev = curr;
            }
            nums[0] = prev;
            k--;
        }
        Arrays.stream(nums).forEach(System.out::print);
    }

    //       k     n
    // 1 2 3 4 5 6 7
    // 7 6 5 4 3 2 1 - Full Reverse
    // 5 6 7 4 3 2 1 - Reverse 0 -> K-1
    // 5 6 7 1 2 3 4 - Reverse K -> N

    // Time - O(n), Space - O(1)
    private static void rotateArrayV2(int[] nums, int k) {
        k %= nums.length;
        // https://leetcode.com/problems/rotate-array/solutions/54250/easy-to-read-java-solution

        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

        Arrays.stream(nums).forEach(System.out::print);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        int temp;
        while (start <= end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
