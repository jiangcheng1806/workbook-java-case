package com.jiangcz.theory.algorithm.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 类名称：PatchUpCurrency<br>
 * 类描述：<br>
 * 创建时间：2018年08月18日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class PatchUpCurrency {


    /**
     * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
     *
     * 输入
     * 输入包括一个整数n(1 ≤ n ≤ 10000)
     *
     * 输出
     * 输出一个整数,表示不同的组合方案数
     *
     *
     * 看到这道题目，我的第一反映这是一道dp问题，因为类似的题目太多了，比如青蛙跳台阶，和这个题目是一样的问法。一次可以跳几阶，和一次用几种硬币，然后都有一个目标值，总共为N元（N阶）。所以最先想到的方法是递归求解，
     *
     * f(N) = f(N-1)+f(N-5)+…+f(N-100)
     *
     * 然后按照一般的dp问题解决方法，写出递归公式后，找递归出口。这个时候我就遇到了问题。1,5,10,20,50,100这几个数字，需要多次判断N的值与各个币值的大小关系，而且与跳台阶本质上有一个不同的就是，跳台阶是一个顺序的过程，而拼凑钱币是没有先后顺序一说的，也就是，我只考察各个币种的个数，而不关心拿出的顺序。所以直接使用递归，会有大量的重复数据。
     *
     * 这个时候更换思路，不要从后往前遍历所有的解，而是，从前往后推出所有的合法解。最粗暴的思路就是枚举，6层循环判断所有合理解。然后考虑在这6层循环中，有没有什么限制条件：
     *
     * 币种1，对于任意N，都只有一种方法 1 * N
     *
     * 币种100（最大面值），其方法数，包含了许多子问题：100，可以使用的方法有 N/100种，那么剩下的问题就是，N -k*100 为最终目标时，使用｛1,5,10,20,50｝这些币种所构成的方法数。
     *
     * 根据上面的限制二，我们有看到熟悉的DP味道。这样，不断的把问题简化为子问题，最终不就回到了只剩下币种为1时的问题规模。现在我们就要考虑怎么用代码来模拟这个过程的问题。类似DP问题，我们需要一个递归笔记本，记录过程中所有的方法解，然后根据现有解，去推出未知解。
     *
     *
     *
     *
     */
    public static long solution(int n){
        int coins[] = {1,5,10,20,50,100};
        int h = coins.length;
        long dp[][] = new long[h][n+1];//存放所有解的笔记本，二维数组存放
        //dp[x][y]:x 为当前可用币种数目，y 为所需要凑的目标值即子问题的目标值
        Arrays.fill(dp[0],1);//当币种为1时，对于任意N都为1种解法
        for (int i = 0; i < h; i++) {//逐次增加币种
            for (int j = 0; j <= n; j++) {//逐次增加目标值
                int m = j / coins[i];//当前问题,可用的最大币种的数量
                for (int k = 0; k <= m; k++) {
                    //用K个最大币种时，问题缩小为：用1~次最大币种，目标值为j-K*coins[i]的解法有
                    dp[i][j] += dp[i-1][j - k * coins[i]];
                }
            }
        }
        //所有子问题解决，得到最终的解
        return dp[h-1][n];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
