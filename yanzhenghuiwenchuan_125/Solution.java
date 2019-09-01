package yanzhenghuiwenchuan_125;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            while (head < s.length() && !valid(s.charAt(head))) {
                head++;
            }
            while (tail >= 0 && !valid(s.charAt(tail))) {
                tail--;
            }
            if (head >= tail) {
                break;
            }
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            tail--;
            head++;
        }
        return true;
    }

    public boolean valid(char a) {
        return (a >= '0' && a <= '9') || (a >= 'a' && a <= 'z');
    }


}
