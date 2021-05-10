package bob.algo_week2;

public class StackArray {
    public static  int[] stack;
    public static int top;

    public static void main(String[] args) {

    }
    public static void init(){
        stack = new int[100];
        top = 0;
    }

    public static int pop(){
        return stack[top--];
    }
    public static void push(int x){
        stack[++top] = x;
    }
    public static boolean isEmpty(){
        return top>0;
    }
    public static int getTop(){
        return stack[top];
    }
    

}
