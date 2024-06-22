public class RemoveElement {

    // https://leetcode.com/problems/remove-element
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElementV1(nums, val));
    }

    // Time - O(n), Space - O(1)
    private static int removeElementV1(int[] nums, int val) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[x++] = nums[i];
            }
        }
        return x;
    }
}
