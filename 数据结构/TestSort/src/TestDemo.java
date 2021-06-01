import java.util.ArrayList;
import java.util.Arrays;

public class TestDemo {

    public static void main(String[] args) {
        int[] a = {123,34,234,54,12,45};
        TestSort.heapSort(a);
        System.out.println(Arrays.toString(a));

    }
}
