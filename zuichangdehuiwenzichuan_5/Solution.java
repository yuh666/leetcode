package zuichangdehuiwenzichuan_5;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String longestPalindrome(String s) {
        if ("".equals(s) || s.length()==1) {
            return s;
        }
        //一个字符也算回文
        int maxLength = 0;
        String longestStr = "";
        for (int i = 0; i < s.length(); i++) {
            int slow = expandFromCenter(i, i, s);
            int high = expandFromCenter(i, i + 1, s);
            int max = Math.max(slow, high);
            if ( maxLength < max) {
                int start = i - (max - 1) / 2;
                int end = i + (max / 2);
                longestStr = s.substring(start, end + 1);
                maxLength = max;
            }
        }
        return longestStr;
    }

    private int expandFromCenter(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String aa = new Solution().longestPalindrome("cabax");
        System.out.println(aa);
    }
}