package bob.DP;

import java.util.Arrays;

/* 
https://blog.csdn.net/chanmufeng/article/details/82955730?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control
给定n个重量为wi，价值为vi的物品和容量为C的背包，求这个物品中一个最有价值的子集，使得在满足背包容量的前提下，包内的总价值最大。
*/

public class bag {
    // 记忆搜索方法，记录记算过程
    private static int[][] memo;

    public static void main(String[] args) {
        int[] w = { 3, 2,2,1 };
        int[] v = { 20, 12,15,10 };
        int capacity = 5;
        System.out.println(solveKS(w, v, w.length - 1, capacity));

        memo = new int[w.length][capacity + 1];
        System.out.println(KnapSack01(w, v, w.length - 1, capacity));
        for (int i = 0; i < memo.length; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }

        KnapSack02(w, v, capacity);
        // System.out.println("KnapSack02test");
        // KnapSack02test(w, v, capacity);
        KnapSack03(w, v, capacity);
    }

    /*
     * 方法1：递归 设放置第n-1个物品，总价值为F(n-1,C) 放置第n个物品，总价值为vn + F(n-1,C-wn) F(i,C) = max(vn +
     * F(n-1,C-wn),F(n-1,C))
     * 
     * 递归方法可以很简单的解决以上问题，但是有个严重的问题就是，直接采用自顶向下的递归算法会导致要不止一次的解决公共子问题，因此效率是相当低下的。
     */

    /**
     * 解决背包问题的递归函数
     *
     * @param w 物品的重量数组
     * @param v 物品的价值数组
     * @param n 当前待选择的物品索引
     * @param C 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKS(int[] w, int[] v, int n, int C) {
        // 基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (n < 0 || C <= 0) {
            return 0;
        }
        // 放第n-1个物品所得价值
        int res = solveKS(w, v, n - 1, C);
        if (w[n] <= C) {
            res = Math.max(res, v[n] + solveKS(w, v, n - 1, C - w[n]));
        }
        return res;
    }

    /*
     * 我们可以将已经求得的子问题的结果保存下来，这样对子问题只会求解一次，这便是记忆化搜索。
     */
    /**
     * 记忆搜索方法，使用二维数据存储计算过的值
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return 最大价值
     */
    public static int KnapSack01(int[] w, int[] v, int index, int capacity) {
        // 基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0)
            return 0;

        // 如果此子问题已经求解过，则直接返回上次求解的结果
        if (memo[index][capacity] != 0) {
            return memo[index][capacity];
        }

        // 不放第index个物品所得价值
        int res = KnapSack01(w, v, index - 1, capacity);
        // 放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + KnapSack01(w, v, index - 1, capacity - w[index]));
        }
        // 添加子问题的解，便于下次直接使用
        memo[index][capacity] = res;
        return res;
    }

    /*
     * 动态规则解决：
     * 
     * @param w 物品的重量数组
     * 
     * @param v 物品的价值数组
     * 
     * @param C 当前背包有效容量
     * 
     * @return 最大价值
     */
    public static int KnapSack02(int[] w, int[] v, int C) {
        int size = w.length;
        if (size <= 0) {
            return 0;
        }
        int[][] dp = new int[size][C + 1];
        // 初始化第一行，放置第0个物品
        for (int j = 0; j <= C; j++) {
            dp[0][j] = w[0] <= j ? v[0] : 0;
            System.out.print(dp[0][j] + " ");
        }
        System.out.println();

        // 填充除每一行以外其他行
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[size - 1][C];
    }


    public static int KnapSack02test(int[] w, int[] v, int C){
        int size = w.length;
        int[] dp = new int[C];
        for(int i = 0;i<=C;i++){
            dp[i] = w[0]<=i?w[0]:0;
            System.out.println("");
        }
        for(int i = 0;i<size;i++){
            for(int j = C;j>=w[i];j--){
                if(w[i]<=j){
                    dp[j] = Math.max(dp[j],v[i]+dp[j-w[i]]);
                }
            }
        }


        return dp[C];
    }

    




    /*
     * 动态规则解决： 只使用一维数组
     * 
     * @param w 物品的重量数组
     * 
     * @param v 物品的价值数组
     * 
     * @param C 当前背包有效容量
     * 
     * @return 最大价值
     */
    public static int  KnapSack03(int[] w,int[] v,int C) {
        int size = w.length;
        if(size == 0){
            return 0;
        }
        System.out.println();
        int[] dp = new int[C+1];
        // 初始化数组，仅考虑放置第0个物品的情况
        for(int i=0;i<=C;i++){
            dp[i] = w[0] <= i ? v[0]:0;
            System.out.print(dp[i]+" ");
        }
        System.out.println();

        for(int i =1 ; i<size;i++){
            for(int j = C;j >=w[i];j--){
                dp[j]= Math.max(dp[j], v[i]+dp[j-w[i]]);
            }
            // 打印一行
            for(int j = 0;j<=C;j++){
                System.out.print(dp[j]+" ");
            }
            System.out.println();
        }
        return dp[C];
    }
    
}
