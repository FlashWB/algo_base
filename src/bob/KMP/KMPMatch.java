package bob.KMP;

import java.util.Arrays;

public class KMPMatch {

    /*
     * KMP算法核心，比较当前位置，前缀和后缀子序列，取最大公式元素长度，得到部分匹配数组PMT 将PMT数组右移一位，第一位补-1，获得next数组 ，
     * 移动下一位长度是 j-next[j] (j是模式串的位置)
     */

    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好"; 
        String str2 = "尚硅谷你尚硅你";
        int[] next = getNext(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(KMP(str1, str2));
    }

    public int partialMatchTable(){
        return 0 ;
    }

    /*
     * 求next数组，
     * P[k] == P[j]的时候，P[0 ~ k-1] + P[k] == p[j-k ~ j-1] + P[j]，
     * 即 next[j+1] == k + 1 == next[j] + 1
     */
    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[ps.length()];
        next[0] = -1;
        int j = 0; // 模式串当前位置
        int k = -1; // 从头模式串匹配到了几位
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        return next;
    }



    /**
     * KMP算法
     * @param str1 主串
     * @param str2 模式串
     * @return
     */
    public static int KMP(String str1, String str2) {
        int i =0;
        int j = 0;
        int[] next = getNext(str2);
        while(i<str1.length() && j<str2.length()){
            if(j == -1 || str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        
        }   
         if(j == str2.length()){
                return i-j;
            }
        return -1;


    }


}
