package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.Scanner;

/*
输入一个n行m列的整数矩阵，再输入q个询问，每个询问包含四个整数x1, y1, x2, y2，表示一个子矩阵的左上角坐标和右下角坐标。

对于每个询问输出子矩阵中所有数的和。

输入格式
第一行包含三个整数n，m，q。

接下来n行，每行包含m个整数，表示整数矩阵。

接下来q行，每行包含四个整数x1, y1, x2, y2，表示一组询问。

输出格式
共q行，每行输出一个询问的结果。

数据范围
1≤n,m≤1000,
1≤q≤200000,
1≤x1≤x2≤n,
1≤y1≤y2≤m,
−1000≤矩阵内元素的值≤1000
输入样例：
3 4 3
1 7 2 4
3 6 2 8
2 1 2 3
1 1 2 2
2 1 3 4
1 3 3 4
输出样例：
17
27
21 */
public class SubmatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n =scanner.nextInt();
        int m =scanner.nextInt();
        int q =scanner.nextInt();
        int[][] s= new int[n+1][m+1];
        for(int i = 1; i<=n;i++){
            for(int j =1 ; j<=m;j++){
                s[i][j] = scanner.nextInt();
            }
        }
        // 矩阵中每个点 a(i,j) 是a(0,0)-a(i,j)子矩阵各元素的和
        for(int i = 1; i<=n;i++){
            for(int j = 1; j<=m;j++){
                s[i][j] = s[i][j]+s[i-1][j] +s[i][j-1] -s[i-1][j-1];
            }
        } 
        while(q-->0){
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            System.out.println(sumMatrix(s, x1, y1, x2, y2));
        }



    }

    public static int sumMatrix(int[][]s,int x1,int y1,int x2, int y2){

        return s[x2][y2]+s[x1 -1][y1-1]-s[x1-1][y2]-s[x2][y1-1];
    }

}
