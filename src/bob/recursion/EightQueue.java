package bob.recursion;

public class EightQueue {

    // ����һ�������ʺ�
    int MAX = 8;
    int[] array = new int[MAX];

    // ͳ�ƽⷨ
    static int count = 0;
    // ͳ�Ƶݹ����
    static int judgecount = 0;

    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue();
        eightQueue.check(0);
        System.out.printf("һ����%d�ⷨ", count);
        System.out.printf("һ���жϳ�ͻ�Ĵ���%d��", judgecount);
    }

    // ���õ�n���ʺ󣬵�n���ʺ��ڵ�n��
    public void check(int n){
        // ���ڣ��ʺ�ȫ������
        if(n==MAX){
            print();
            return;
        }
        // ���η���ʺ��n���ʺ󣬱����������Ƿ���Ϲ���
        for(int i = 0; i < MAX; i++){
            array[n] = i;
            if(judge(n)){
                // �����n�����Ϲ��򣬷�����һ���ʺ�ֱ������У�����
                check(n+1);
            }
        }


    }


    // �жϵ�n���ʺ��Ƿ���Ϸ��ù���
    // ��n���ʺ�����ڵ�n�У�ÿ���ʺ��������ͬ�����Բ���Ҫ�ж��Ƿ���ͬһ�У�ֻ���ж���ͬһ��
    // ����index���У�value����
    public boolean judge(int n){
        judgecount++;
        // �������õ�ǰn-1��
        for(int i=0; i<n; i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[i]-array[n])){
                return false;
            }
        }
        return true;
    }


    public void print(){
        // ÿ�ɹ���ӡһ�Σ���һ����
        count++;
        for(int i =0 ;i < array.length;i++){
            System.out.print(array[i]+ "");
        }
        System.out.println();
    }


}
