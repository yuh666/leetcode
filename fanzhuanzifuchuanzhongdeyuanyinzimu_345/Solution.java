package fanzhuanzifuchuanzhongdeyuanyinzimu_345;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            while (head < s.length() && !valid(chars[head])) {
                head++;
            }
            while (tail >= 0 && !valid(chars[tail])) {
                tail--;
            }
            if (tail <= head) {
                break;
            }
            swap(chars, head, tail);
            head++;
            tail--;
        }
        return new String(chars);
    }


    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean valid(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}