public class Test2 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] res = solution.subSort(array);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}

class Solution1 {
    public int[] subSort(int[] array) {
        int[] res = new int[2];
        int start = -1;
        int end = -1;
        int i = 1;
        while(i < array.length) {
            //判断前半段是否有序
            if(array[i - 1] <= array[i]) {
                i++;
                continue;
            }

            start = i - 1;
            //调整开始窗口
            while(array[start] > array[i]) {
                if(start < 0) {
                    res[0] = -1;
                    res[1] = -1;
                    return res;
                }
                start--;
            }
            i++;
        }

        i = array.length - 1;
        while(i >= 1) {
            //判断前半段是否有序
            if(array[i - 1] <= array[i]) {
                i--;
                continue;
            }
            if(i == array.length - 1) {
                end = array.length - 1;
            }
            end = i + 1;
            //调整结束窗口
            while(array[end] < array[i]) {
                if(end == array.length ) {
                    res[0] = -1;
                    res[1] = -1;
                    return res;
                }
                end++;
            }
            i--;
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
}