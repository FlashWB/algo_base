package bob.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 451};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * ����д��
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;  // base�������
        int j = r;  // base�Ҳ�����
        int base = arr[l + r >> 1];
        while (i < j) {
            while (i < j && arr[i] < base) {
                i++;
            }
            while (i < j && arr[j] > base) {
                j--;
            }
            // ����жϱ�����
            if (i < j) {
                swap(arr, i, j);
            }
            System.out.println("i = " + i + " ,j = " + j);
        }
        // ִ�е��⣬i,j�����غϣ�i=j
        // baseֵ���ȫС��base���Ҳ�ȫ����base
        // С��base�����ٿ���
        quickSort(arr, l, i - 1);
        // ����base�����ٿ���
        quickSort(arr, j + 1, r);
    }

    /**
     * ������ֵ�ָ�
     * ����˼·�ǣ�ʹ����ˣ��Ҷ˺�����λ���ϵ�����Ԫ�ص���ֵ��Ϊ��ŦԪ����ʵ�Ƕ���ֵ�Ĺ���
     */
    private static int median3(int[] a, int i, int j) {
        //�����������������
        int m = (i + j) >> 1;
        if (a[m] < a[i]) {
            swap(a, i, m);
        }
        if (a[j] < a[i]) {
            swap(a, i, j);
        }
        if (a[j] < a[m]) {
            swap(a, j, m);
        }
        //����Ŧֵ����j - 1;
        swap(a, m, j - 1);
        return a[j - 1];
    }

    /**
     * ʹ��������ֵ�ָ������
     */
    public static void quickSort2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // �����Ŵ��ֺ�����ȡ��Ԫ����Ԫ����r-1
        int base = median3(arr, l, r);
        int i = l;
        int j = r - 1;
        while (i < j) {
            while (i < j && arr[i] < base) {
                i++;
            }
            while (i < j && arr[j] > base) {
                j--;
            }
            // ����жϱ�����
            if (i < j) {
                swap(arr, i, j);
            }
            System.out.println("i = " + i + " ,j = " + j);
        }

        // ����i����Ԫλ��
        swap(arr,i,r-1);

        quickSort(arr, l, i - 1);
        // ����base�����ٿ���
        quickSort(arr, j + 1, r);
    }


}
