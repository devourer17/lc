import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
    public static void main(String[] args) {
        //int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums = {1, 1, 1, 2, 2, 3};
        removeDuplicatesFromArrayV1(nums);
        System.out.println();
        removeDuplicatesFromArrayV2(nums, 2);
    }

    //Time - O(n), Space - O(1)
    private static int removeDuplicatesFromArrayV1(int[] nums) {
        int x = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[x - 1]) {
                nums[++x] = nums[i];
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        return x + 1;
    }

    // Generic Solution
    //Time - O(n), Space - O(1)
    private static int removeDuplicatesFromArrayV2(int[] nums, int k) {

        if (nums.length == 0) return 0;
        int m = 1;
        int count = 1; //Allowed Duplicacy(k) - 2 in this case

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                if (count < k) {
                    nums[m++] = nums[i];
                }
                count++;
            } else {
                count = 1;
                nums[m++] = nums[i];
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        return m;
    }
}
