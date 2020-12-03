package bob.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {

        int[] arr = {4, 5, 8, 2, 3, 9, 7, 1};
        int[] arr2 = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr2[i] = (int) (Math.random() * 8000000);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(data1));
        heapSort2(arr);

        Date data2 = new Date();
        System.out.println(simpleDateFormat.format(data2));
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int arr[]) {
        int temp = 0;

        // 将无序序列构建成一个大顶堆
        // 从第一个非叶子结点开始调整 i = arr.length/2-1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        /**
         * 排序，将堆顶与最后一位元素交换，将最大元素沉到数组末端
         * 重新调整其余元素为大顶堆
         */
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }


    /**
     * 功能：将第i对应的非叶子结点的子树调整为大顶堆
     * 调整思路：访问i父节点的左右子节点，找出最大的子节点，与父节点i比较，如果大于父节点，则交换。
     * 因为调整是由底至顶调整，所以i节点以下节点的子树都是大顶堆。调整i节点只关注3个节点，即i节点和左右子节点。
     * 如果i节点与左右子节点某一个交换，只需要继续调整被交换过的子结点，另一个子节点无需调整。
     *
     * @param arr    完全二叉树
     * @param i      非叶子结点在树中的索引
     * @param length 需要调整的元素数量
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            // 找出叶子结点中最大的
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            // 与父节点i比较,大于则交换(因为与temp比较，相当于i与k完成了交换)
            if (arr[k] > temp) {
                arr[i] = arr[k];  // 报较大的子节点赋值给当前节点
                i = k;  // 从子节点，继续调整
            } else {
                // 因为从底至顶调整，所以子树是大顶堆，如果子树根节点小于当前节点，直接break
                break;
            }
        }
        arr[i] = temp;
    }


    public static void adjust(int[] arr, int i, int length){
        // length是调整数组的边界，一定要注意，不要使用arr.length
        for(int k = 2*i+1;k<length;k = k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>arr[i]){
                swap(arr,i,k);
                i = k;
            }else {
                break;
            }
        }
    }

    public static void heapSort2(int[] arr){
        for(int i = arr.length/2-1;i>=0;i--){
            adjust(arr,i,arr.length);
        }
        for(int j = arr.length-1;j>0;j--){
            swap(arr,0,j);
            adjust(arr,0,j);
        }
    }
    public static void swap(int arr[],int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}
