package bob.recursion;

public class EightQueue {

    int MAX = 8;
    int[] array = new int[MAX];

    static int count = 0;
    static int judgecount = 0;

    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue();
        eightQueue.check(0);
        System.out.printf("", count);
        System.out.printf("", judgecount);
    }

    public void check(int n){
        if(n==MAX){
            print();
            return;
        }
        for(int i = 0; i < MAX; i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }


    }


    public boolean judge(int n){
        judgecount++;
        for(int i=0; i<n; i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[i]-array[n])){
                return false;
            }
        }
        return true;
    }


    public void print(){
        count++;
        for(int i =0 ;i < array.length;i++){
            System.out.print(array[i]+ "");
        }
        System.out.println();
    }


}
