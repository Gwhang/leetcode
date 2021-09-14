package com.gwh.leetcode.test01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 */
public class Test01 {

    public static void main(String[] args) {

        int [] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums,target)));

    }


    /**
     * 哈希映射法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // 初始化map
        Map<Integer, Integer> map = new HashMap<>();
        // 循环数组
        for (int i = 0 ;i<nums.length;i++){
           // 每个值都判断map中是否存在 target-nums[i] 的 key 值
            if(map.containsKey(target-nums[i])){
                // 如果存在则找到了两个值
                return new int[] {map.get(target-nums[i]),i};
            }
            // 如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
