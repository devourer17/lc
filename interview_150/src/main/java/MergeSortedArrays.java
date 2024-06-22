import java.util.Arrays;

public class MergeSortedArrays {


    // https://leetcode.com/problems/merge-sorted-array
    public static void main(String[] args) {
        mergedSortedArraysV1();
        System.out.println();
        mergedSortedArraysV2();
    }

    // Time - O(m+n), Space - O(m+n)
    public static void mergedSortedArraysV1() {
        //Given
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        //Introduced Variables
        int i = 0, j = 0, k = 0;
        int[] nums3 = new int[m + n];

        for (; j < m && k < n; ) {
            if (nums1[j] <= nums2[k])
                nums3[i++] = nums1[j++];
            else
                nums3[i++] = nums2[k++];
        }
        while (j < m)
            nums3[i++] = nums1[j++];

        while (k < n) {
            nums3[i++] = nums2[k++];
        }

        nums1 = nums3;
        Arrays.stream(nums1).forEach(System.out::print);
    }

    // Time - O(m+n), Space - O(1)
    public static void mergedSortedArraysV2() {
        //Given
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        //Introduced Variables
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        Arrays.stream(nums1).forEach(System.out::print);
    }
}
