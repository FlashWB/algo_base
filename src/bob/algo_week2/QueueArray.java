package bob.algo_week2;

public class QueueArray {

    public static int[] queue;
    // 队头
    public static int hh;
    // 队尾
    public static int tt;

    public static void main(String[] args) {
        
    }

    public QueueArray(){
        int N = 10000;
        queue = new int[N];
        hh = 0;
        tt = 0;
    }

    public static boolean isEmpty(){
        return hh >= tt;
    }

    public static void push(int x){
        queue[++tt] = x;
    }
    public static int pop (){
        return queue[hh++];
    }

    public static int head(){
        return queue[hh];
    }
    

    



}
