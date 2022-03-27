package com.gwh.leetcode.test01;

/**
 * @author gwh
 * @date 2022-03-27
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class Test09 {


    public static void main(String[] args) {
        int x = 1;
        System.out.println(isPalindrome(x));
    }

    /**
     * 回文数判断
     * 如果是负数则一定不是回文数，直接返回 false
     * 如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等
     * 如果是回文数则相等返回 true，如果不是则不相等 false
     * 比如 123 的倒序 321，不相等；121 的倒序 121，相等
     *
     * @return
     */
    public static boolean isPalindrome(int x){
        // 负数直接返回false
        if(x<0){
            return false;
        }
        // 变量
        int cur = 0;
        // 赋值
        int num = x;
        // 反转数据
        while (num != 0){
            cur = cur * 10 + num % 10;
            num = num / 10;
        }
        return cur == x;
    }

}
