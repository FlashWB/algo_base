package bob.DP;

/* 
给定n个重量为wi，价值为vi的物品和容量为C的背包，求这个物品中一个最有价值的子集，使得在满足背包容量的前提下，包内的总价值最大。

​	
 的物品和容量为C CC的背包，求这个物品中一个最有价值的子集，使得在满足背包的容量的前提下，包内的总价值最大
*/

public class bag {
    public static void main(String[] args) {
        int[] w = { 2, 1, 3, 2 };
        int[] v = { 12, 10, 20, 15 };
        System.out.println(solveKS(w, v, w.length - 1, 5));
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
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param n    当前待选择的物品索引
     * @param C 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKS(int[] w, int[] v, int n, int C) {
        //基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if(n < 0 ||C<=0 ){
            return 0;
        }
        //放第n-1个物品所得价值
        int res = solveKS(w, v, n-1, C);
        if(w[n]< C){
            res = Math.max(res, v[n]+solveKS(w, v, n-1, C - w[n]));
        }
        return res;
    }



    /* 
    动态规则解决：
    
    */


}