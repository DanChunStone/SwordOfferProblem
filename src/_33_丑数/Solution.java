package _33_丑数;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7)
            return index; // 1-6都为丑数且与下标相同

        int[] q = new int[index]; // 记录所有丑数
        q[0] = 1; // 第一个丑数为1

        int i2 = 0,i3 = 0,i5 = 0; // 记录乘数[2 3 5]分别乘到了哪一个质数

        /**
         * 思路：
         * 从最小丑数1开始，通过三个指针 i2,i3,i5分别从1开始记录2、3、5分别乘过的丑数的下标
         * 每一次计算2、3、5乘以对应指针记录的位置的丑数，结果中最小的值为当前丑数值(即未入队列的最小丑数)
         * 结果对应的质数的指针往后移动一，代表该质数已经乘过当前丑数，下一次该乘以更大的一个丑数。
         * 因为每一次三个指针记录的乘积包含了（丑数可能为最小）的三种情况，所以其中的最小值一定是下一个最小的丑数
         * 如：[1],i2=0;i3=0;i5=0;   则，三个可能为最小的丑数为：2，3，5，故取最小值2，而i2+1
         * 则下一次时，[1 2],i2=1,i3=0,i5=0;  则，三个可能最小的丑数为：3，4，5，故取最小值3，i3+1
         * 注：
         * 之所以三个判断并列而不是使用else，是因为可能出现重复的丑数：2*3 == 3*2
         * 而通过这个判断，实现了三个准丑数出现相同时，将对应的记录指针往后移（避免重复）
         */
        for (int i = 1;i < index;i++){
            // 第i个丑数为：[2 3 5]乘以各自尚未乘过的最小丑数 的结果中的最小值
            q[i] = Math.min(q[i2]*2,Math.min(q[i3]*3,q[i5]*5));

            // 当前丑数为[2 3 5]中是哪个乘丑数的结果，对应的乘积记录往后移1
            if (q[i] == q[i2]*2)
                i2++;
            if (q[i] == q[i3]*3)
                i3++;
            if (q[i] == q[i5]*5)
                i5++;
        }

        return q[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(10));
    }
}
