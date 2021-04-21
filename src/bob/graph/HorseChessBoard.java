package bob.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Point;

public class HorseChessBoard {

    private static int X; // 列数
    private static int Y; // 行数
    private static boolean isVisited[];
    private static boolean finished; // 如果全部遍历完，true

    public static void main(String[] args) {

        X = 8;
        Y = 8;
        int row = 4;
        int column = 4;
        isVisited = new boolean[X * Y];
        finished = false;
        int[][] chessBoard = new int[X][Y];
        travel(chessBoard, row, column, 1);
        for(int i = 0;i<Y;i++){
            System.out.println(Arrays.toString(chessBoard[i]));
        }

    }

    /**
     * 
     * @param chessArr
     * @param row 行数
     * @param column 列数
     * @param step
     */
    public static void travel(int[][] chessArr, int row, int column, int step) {
        isVisited[X * row + column] = true; // 标记访问
        chessArr[row][column] = step;
        ArrayList<Point> ps = nextPoints(new Point(column    ,row));
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if(!isVisited[p.y*X + p.x]){
            travel(chessArr, p.y, p.x, step + 1);
            }
        }
        // 棋盘仍未走完，回溯，恢复致上一个状态
        if (!finished && step < X * Y) {
            chessArr[row][column] = 0;
            isVisited[X * row + column] = false; // 标记访问
        }else{
            finished = true;
        }
    }

    /* 判断下一步能走的点 */
    public static ArrayList<Point> nextPoints(Point curPoint) {
        ArrayList<Point> pList = new ArrayList<>();
        Point p = new Point();
        // 0
        if ((p.x = curPoint.x+ 2 )< X &&( p.y = curPoint.y- 1 )>= 0) {
           pList.add(new Point(p));
        }
        // 1
        if ((p.x = curPoint.x+ 2) < X && (p.y = curPoint.y+ 1 )< Y) {
           pList.add(new Point(p));
        }
        // 2
        if ((p.x = curPoint.x+ 1 )< X && (p.y = curPoint.y+ 2) < Y) {
           pList.add(new Point(p));
        }
        // 3
        if ((p.x = curPoint.x- 1) >= 0 && (p.y = curPoint.y+ 2 )<= Y) {
           pList.add(new Point(p));
        }
        // 4
        if ((p.x =curPoint.x- 2) >= 0 && (p.y =curPoint.y+ 1 )<= Y) {
           pList.add(new Point(p));
        }
        // 5
        if ((p.x =curPoint.x- 2) >= 0 && (p.y = curPoint.y- 1 )>= 0) {
           pList.add(new Point(p));
        }
        // 6
        if ((p.x =curPoint.x- 1) >= 0 && (p.y =curPoint.y- 2) >= 0) {
           pList.add(new Point(p));
        }
        // 7
        if ((p.x =curPoint.x+ 1) < X && (p.y =curPoint.y- 2) >= 0) {
           pList.add(new Point(p));
        }
        return pList;
    }

}
