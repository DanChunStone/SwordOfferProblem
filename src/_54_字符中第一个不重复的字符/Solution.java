package _54_字符中第一个不重复的字符;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution {
    private StringBuilder sb = new StringBuilder();
    private int[] frequency = new int[256];

    // 插入一个字符进入字符流
    public void Insert(char ch) {
        sb.append(ch);
        frequency[ch]++;
    }

    //返回第一个不重复的字符
    public char FirstAppearingOnce() {
        int length = sb.length();
        for (int i = 0;i < length;i++){
            if (frequency[sb.charAt(i)]==1)
                return sb.charAt(i);
        }

        return '#';
    }
}
