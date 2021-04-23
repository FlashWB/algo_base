package bob.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Point;

public class HorseChessBoard {

    private static int X; // 列数
    private static int Y; // 行数
    private static boolean isVisited[];
    private static boolean finished; // 如果全部遍历完，true

    public static void main(String[] args) {

        X = 7;
        Y = 7;
        int row = 4;
        int column = 4;
        isVisited = new boolean[X * Y];
        finished = false;
        int[][] chessBoard = new int[X][Y];
        long start = System.currentTimeMillis();
        testHorseTravel(chessBoard, row, column, 1);
        long end = System.currentTimeMillis();
        for (int i = 0; i < Y; i++) {
            System.out.println(Arrays.toString(chessBoard[i]));
        }
        System.out.println(end - start + "ms");

    }

    /**
     * 
     * @param chessArr
     * @param x        行数
     * @param y        列数
     * @param step
     */
    public static void travel(int[][] chessArr, int x, int y, int step) {
        isVisited[x + y * X] = true; // 标记访问
        chessArr[x][y] = step;
        List<Point> ps = nextPoints(new Point(x, y)).stream().sorted(Comparator.comparing(e -> nextPoints(e).size()))
                .collect(Collectors.toList());
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (!isVisited[p.y * X + p.x]) {
                travel(chessArr, p.x, p.y, step + 1);
            }
        }
        // 棋盘仍未走完，回溯，恢复致上一个状态
        if (!finished && step < X * Y) { //  如果finished，则回溯所有stack
            chessArr[x][y] = 0;
            isVisited[x + y * X] = false;
        } else {
            finished = true;
        }
    }

    public static void testHorseTravel(int[][] chessBoard, int x, int y, int step) {
        isVisited[y * X + x] = true;
        chessBoard[x][y] = step;
        List<Point> ps = nextPoints(new Point(x, y)).stream().sorted(Comparator.comparing(e -> nextPoints(e).size()))
                .collect(Collectors.toList());
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if(!isVisited[p.y*X+p.x]){
            testHorseTravel(chessBoard, p.x, p.y, step + 1);
            }
        }
        if(finished){
            return;
        }
        if (step < X * Y) { // 回溯
            isVisited[y * X + x] = false;
            chessBoard[x][y]= 0;
        } else {
            finished = true;
        }

    }

    /* 判断下一步能走的点 */
    public static ArrayList<Point> nextPoints(Point curPoint) {
        ArrayList<Point> pList = new ArrayList<>();
        Point p = new Point();
        // 0
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            pList.add(new Point(p));
        }
        // 1
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            pList.add(new Point(p));
        }
        // 2
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            pList.add(new Point(p));
        }
        // 3
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            pList.add(new Point(p));
        }
        // 4
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            pList.add(new Point(p));
        }
        // 5
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            pList.add(new Point(p));
        }
        // 6
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            pList.add(new Point(p));
        }
        // 7
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
            pList.add(new Point(p));
        }
        return pList;
    }

}
