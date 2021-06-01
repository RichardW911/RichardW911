import java.util.*;
public class test {
    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Double[] num = new Double[list.size()];
        for(int i = 0; i < num.length; i++) {
            num[i] = list.get(i).doubleValue();
        }
        Arrays.sort(num);
        Double result = null;
        if(num.length % 2 == 0) {
            result = (num[num.length / 2] + num[num.length / 2 - 1]) / 2;
        }else {
            result = num[num.length / 2];
        }
        return result;
    }

    public static void main(String[] args) {
        test test = new test();
        test.Insert(1);
        test.Insert(2);
        test.Insert(3);
        Double result = test.GetMedian();
        System.out.println(result);
    }
}