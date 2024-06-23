public class MajorityElementI {

    // https://leetcode.com/problems/majority-element/description
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElementV1(nums));
    }

    // Moore Voting Algorithm
    // Time - O(n), Space - O(1)
    private static int majorityElementV1(int[] nums) {
        int count = 1, majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0)
                majority = nums[i];
            if (majority == nums[i]) count++;
            else count--;
        }
        return majority;
    }
}
