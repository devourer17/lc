package arrays;

public class JumpGameI {

    // https://leetcode.com/problems/jump-game/description
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJumpV1(nums));
        System.out.println(canJumpV2(nums));
        System.out.println();
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJumpV1(nums2));
        System.out.println(canJumpV2(nums2));
    }


    // Greedy
    // Time - O(n), Space - O(1)
    private static boolean canJumpV1(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxJump < i) return false;
            maxJump = Math.max(nums[i] + i, maxJump);
        }
        return true;
    }

    // DP
    private static boolean canJumpV2(int[] nums) {
        int length = nums.length;
        boolean[] jump = new boolean[length];
        jump[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i] && i + j < length; j++) {
                if (jump[i + j] == true) {
                    jump[i] = true;
                    break;
                }
            }
        }
        return jump[0];
    }
}
