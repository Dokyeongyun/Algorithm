package leetcode._1_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Constraints:
 * [1] 2 <= nums.length <= 104
 * [2] -109 <= nums[i] <= 109
 * [3] -109 <= target <= 109
 * [4] Only one valid answer exists.
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    /*
    [Solution 1: Brute force]
    Time Complexity: O(n^2)
    Space Complexity: O(1)
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
    [Solution 2: Hashmap]
    Time Complexity: O(n)
    Space Complexity: O(n)
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int required = target - nums[i];
            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
