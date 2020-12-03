package bob.sort;

public class InsertSort {
    //int[] arr = {101, 34, 119, 1, -1, 89};
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort2(arr);
        print(arr);
    }


    public static void insertSort(int[] arr) {
        // ������Ҫ�����ֵ
        int insertValue = 0;
        // ��Ҫ���������
        int insertIndex = 0;
        // �ӵ�һλ��ʼ����
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i;
            // ˵��:�ҳ�����λ�ã��Ӳ���ֵ��������ǰ����
            // 1. insertIndex-1 >= 0 ��֤�ڸ�insertVal �Ҳ���λ�ã���Խ��
            // 2. insertVal < arr[insertIndex-1] �������������û���ҵ�����λ��
            // 3. ����Ҫ�� arr[insertIndex] ����
            while (insertIndex - 1 >= 0 && insertValue < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            //���������ж��Ƿ���Ҫ��ֵ
            if (insertIndex != i) {
                arr[insertIndex] = insertValue;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        int insertValue;
        int i;
        int j;
        for (i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            for (j = i-1; j >= 0 && arr[j] > insertValue; j--) {
                // ��������Ԫ������,�ڳ�����λ��
                    arr[j+1] = arr[j ];
            }
            arr[j+1] = insertValue;
        }
    }


    public static void print(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
