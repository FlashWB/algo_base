package bob.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // ��ȡ��������ֵ
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = Integer.toString(max).length();

        // ����10��Ͱ 0��1��2��3��4��5��6��7��8��9��ÿ��Ͱ��һ��һά���飬����ά����
        // Ϊ��ֹ���������Ͱ��СΪarr.length��ʹ�ÿռ任ʱ��
        int[][] bucket = new int[10][arr.length];

        // ��¼ÿ��Ͱ��ʵ�ʴ�Ŷ�������
        int[] bucketElementCounts = new int[10];

        // ��������
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(���ÿ��Ԫ�صĶ�Ӧλ����������)�� ��һ���Ǹ�λ���ڶ�����ʮλ���������ǰ�λ..
            for(int j = 0; j < arr.length; j++) {
                //ȡ��ÿ��Ԫ�صĶ�Ӧλ��ֵ
                int digitOfElement = arr[j] / n % 10;
                //���뵽��Ӧ��Ͱ��
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //�������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
            int index = 0;
            //����ÿһͰ������Ͱ�������ݣ����뵽ԭ����
            for(int k = 0; k < bucketElementCounts.length; k++) {
                //���Ͱ�У������ݣ����ǲŷ��뵽ԭ����
                if(bucketElementCounts[k] != 0) {
                    //ѭ����Ͱ����k��Ͱ(����k��һά����), ����
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        //ȡ��Ԫ�ط��뵽arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //��i+1�ִ������Ҫ��ÿ�� bucketElementCountss[k] = 0 ��������
                bucketElementCounts[k] = 0;

            }
            
        }


    }
}
