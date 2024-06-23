import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayI {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicatesFromSortedArrayV1(nums);
    }

    // Time - O(n), Space - O(1)
    private static void removeDuplicatesFromSortedArrayV1(int[] nums) {
        int x = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1])
                nums[x++] = nums[i];
        }
        Arrays.stream(nums).forEach(System.out::print);
    }
}
