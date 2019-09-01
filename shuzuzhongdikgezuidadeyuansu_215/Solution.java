package shuzuzhongdikgezuidadeyuansu_215;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (true) {
            int partition = partition(nums, low, high);
            if (partition == k - 1) {
                return nums[partition];
            } else if (partition < k - 1) {
                low = partition + 1;
            } else {
                high = partition - 1;
            }
        }
    }

    private int partition(int[] nums, int low, int high) {
        int p = nums[low];
        int l = low + 1, r = high;
        while (true) {
            while (l <= high && nums[l] >= p) {
                l++;
            }
            while (r > low && nums[r] <= p) {
                r--;
            }
            if (l > r) {
                break;
            }
            swap(nums, l, r);
            l++;
            r--;
        }
        swap(nums, r, low);
        return r;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
