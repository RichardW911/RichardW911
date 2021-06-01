import javax.sound.midi.Soundbank;
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class TestDemo{

    public static int Fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return Fib(n-1) + Fib(n-2);
    }
    public static int func(int N) {
        int i = 0;
        while(Fib(i) < N) {
            i++;
        }
        return Math.min((Fib(i) - N), (N - Fib(i - 1)));
    }
    public static int[] reOrderArray(int[] array) {
        // write code here
        if(array == null) return null;
        int begin = array[0];
        int end = array[array.length - 1];
        int ret = 0;
        while(begin < end) {
            if(array[begin] / 2 == 0 ) {
                while(array[end] / 2 == 0 && end > begin) {
                    end--;
                }
                ret = array[begin];
                array[begin] = array[end];
                array[end] = ret;
            }
            begin++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] target = {2,3,4,5,8,9,10};
        Solution solution = new Solution();
        List<String> list = solution.buildArray(target,10);
        System.out.println(list);
    }
}
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for(int i = 1; i <= n; i++) {
            if(j < target.length) {
                if(target[j] == i) {
                    if(s.isEmpty()) {
                        list.add("Push");
                        j++;
                    }else {
                        if(!s.isEmpty()) {
                            s.pop();
                            list.add("Pop");
                        }
                        list.add("Push");
                        j++;
                    }
                }else {
                    if(!s.isEmpty()) {
                        s.pop();
                        list.add("Pop");

                    }
                    list.add("Push");
                }
            }
        }
        return list;
    }
}


class Solution1 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(size == 0) return null;
        if(num.length < size) return null;
        ArrayList<Integer> arraylist = new ArrayList<>();
        int begin = 0;
        int end = begin + size - 1;
        int result = 0;
        int max = 0;
        while(end <= num.length - 1) {
            if(result < begin) {
                max = 0;
            }
            for(int i = begin; i <= end ; i++) {
                if(max < num[i]) {
                    max = num[i];
                    result = i;
                }
            }
            arraylist.add(max);
            begin++;
            end++;
        }
        return arraylist;
    }
}


