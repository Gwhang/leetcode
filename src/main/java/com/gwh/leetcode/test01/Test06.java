package com.gwh.leetcode.test01;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 */
public class Test06 {

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING",4));

    }

    /**
     * 转换
     * 整体的思路是遍历字符串，遍历过程中将每行都看成新的字符串构成字符串数组，最后再将该数组拼接起来即可
     * 如果 numRows=1 则说明当前字符串即为结果，直接返回
     * 否则整个字符串需要经历，向下向右，向下向右，这样的反复循环过程，设定 down 变量表示是否向下，loc 变量表示当前字符串数组的下标
     * 如果 down 为 true，则 loc+=1，字符串数组下标向后移动，将当前字符加入当前字符串中
     * 如果 down 为 false，则表示向右，则 loc−=1，字符串数组下标向前移动，将当前字符加入当前字符串中
     * 时间复杂度：O(n)，n为字符串s的长度
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        // 如果行数为1 则直接返回字符串
        if(numRows == 1){
            return s;
        }
        // 获取数组长度 如果字符串长度小于要求行数 则返回字符串长度
        int len = Math.min(s.length(), numRows);
        // 定义数组
        String []rows = new String[len];
       // 数组设置初始值 “”
        for(int i = 0; i< len; i++){
            rows[i] = "";
        }
        // 定义初始值
        int loc = 0;
        boolean down = false;
        // 循环遍历字符串
        for(int i=0;i<s.length();i++) {
            // 向字符数组中拼接字符串
            rows[loc] += s.substring(i,i+1);
            // 通过loc 判断是否转向 是向下还是换列 down true 向下  false 换列
            if(loc == 0 || loc == numRows - 1) {
                down = !down;
            }
            // 转向核心
            loc += down ? 1 : -1;
        }

        String ans = "";
        for(String row : rows) {
            ans += row;
        }
        return ans;
    }

}
