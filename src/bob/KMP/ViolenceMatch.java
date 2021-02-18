package bob.KMP;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好"; 
        String str2 = "尚硅谷你尚硅你";
        int index = violenceMatchDemo2(str1, str2);
        System.out.println(index);
    }

    /**
     * 暴力匹配
     * 
     * @param str1 目标字符串
     * @param str2 匹配字符串
     * @return
     */
    public static int violenceMatchDemo1(String str1, String str2) {
        char[] x = str1.toCharArray();
        char[] y = str2.toCharArray();
        int s1len = str1.length();
        int s2len = str2.length();

        for (int i = 0; i < s1len; i++) {
            if (x[i] == y[0]) {
                for (int j = 1; j < s2len; j++) {
                    if (x[i+j] != y[j]) {
                        break;
                    }
                    if(j == s2len-1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static int violenceMatchDemo2(String str1, String str2){
        char[] x = str1.toCharArray();
        char[] y = str2.toCharArray();
        int s1len = str1.length();
        int s2len = str2.length();
        int i = 0;
        int j =0;
        while(i<s1len && j<s2len){
            if(x[i]==y[j]){
                i++;
                j++;
            }else{
                i = i-(j-1);
                j = 0;
            }
            if(j == s2len){
                break;
            }
        }
        return i-j;
    }


}
