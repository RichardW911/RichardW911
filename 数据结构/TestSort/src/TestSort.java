import java.util.ArrayList;
import java.util.Arrays;

public class TestSort {

    /**
     * 时间复杂度：
     * 最坏的情况下（数据是无序的）：O（n^2）
     * 最好的情况下（数据是有序的）：O（n）
     *   特点：越有序越快。
     *   题目：当前有一组待排序序列，但这组待排序序列大部分是有序的，
     *        请问下面哪个排序更适合？
     *        直接插入排序。
     *        另外：直接插入排序一般也会用在一些优化上。（快速排序）
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param array
     */
    public static void insertSort(int[] array) {
        for(int i = 1 ; i < array.length ; i++) {
            int tmp = array[i];
            int j = i - 1;
            for(; j >= 0 ; j--) {
                //如果这里是一个大于等于号 此时这个排序就不稳定了
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    /**
     * 希尔排序（了解）
     * 时间复杂度：
     * 最坏的情况下（数据是无序的）：O（n^2）
     * 最好的情况下（数据是有序的）：O（1.5）
     * 空间复杂度：O（1）
     * 稳定性：不稳定
     * @param array
     * @param gap
     */
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0 ; j = j - gap) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};//增量数组
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    /**
     * 选择排序：
     * 时间复杂度：O（n^2）
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = i + 1 ; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 堆排序：
     * 时间复杂度：O(nlog2n)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     */
    public static void heapSort(int[] array) {
        int tmp = 0;
        //1.将一个无序数组变为大根堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array,i,array.length);
        }
        //2.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端；
        //3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行+交换步骤，直到整个序列有序。
        for(int j = array.length - 1; j > 0 ; j--) {
            tmp = array[j];
            array[j] = array[0];
            array[0] = tmp;
            adjustHeap(array,0,j);
        }
    }

    /**
     *
     * @param array 待调整的数组（二叉树）
     * @param i 非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整
     */

    public static void adjustHeap(int[] array,int i,int length) {
        int tmp = array[i];//先取出当前元素的值，保存在临时变量里
        //开始调整
        //说明
        // k = i * 2 + 1 是i结点的左子结点
        for(int k = 2 * i + 1 ; k < length ; k = k * 2 + 1) {
            if(k+1 < length && array[k] < array[k + 1]) {//说明左子节点的值小于右子节点
                k++; //k指向右子节点
            }
            if(tmp < array[k]) {//如果子节点大于父节点
                array[i] = array[k];//把较大的值赋给当前节点
                i = k;//i 指向 k，继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值放到了最顶部（局部）
        array[i] = tmp;//将tmp的值放到调整后的位置
    }
    /**
     * 冒泡排序：
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param args
     */

    /**
     * 快速排序：
     * 时间复杂度：最好情况：O(nlogn) 最坏情况：O(n^2)
     * 空间复杂度：O(logn)
     * 稳定性：不稳定排序
     * @param array
     */
    public  static int pivot(int[] array,int start,int end) {
        int tmp = array[start];
        while(start < end) {
            while(start < end && array[end] >= tmp) {
                end--;
            }
            //把数据赋值给start
            array[start] = array[end];
            while(start < end && array[start] <= tmp) {
                start++;
            }
            //把数据给end
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }
    public  static void quick(int[] array, int low, int high) {
        if(low < high) {
            int piv = pivot(array,low,high);
            quick(array ,low,piv - 1);
            quick(array ,piv + 1,high);
        }
    }
    public static void quickSort(int[] array) {
        quick(array,0,array.length - 1);
    }

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] array = {3,10,2,7,19,78,65,127};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}

