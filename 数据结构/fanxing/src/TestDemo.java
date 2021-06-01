import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 意义:
* 1.自动进行类型检查
* 2，自动进行类型转换
*
* 写一个通用的顺序表？
* 1.class MyArrayList<T>   <T>:代表占位符 表示当前类是一个泛型类
* 2.简单类型不能做泛型类型的参数
*
*
* 泛型的上界：
* class Algorithm<T extends Comparable<T> >
* T:T类型 一定要实现Comparable 接口
*
* 泛型方法
* */
class Algorithm<T extends Comparable<T> > {
    public T findMaxVal(T[] array) {
        T max = array[0];
        for(int i = 1; i < array.length ; i++) {
            if(array[i].compareTo(max) >= 0) {
                max = array[i];
            }
        }
        return max;
    }
}

/**
 * 泛型方法
 */
class Algorithm2 {
    public static<T extends Comparable<T> > T findMaxVal(T[] array) {
        T max = array[0];
        for(int i = 1; i < array.length ; i++) {
            if(array[i].compareTo(max) >= 0) {
                max = array[i];
            }
        }
        return max;
    }
}
/**
 * 写一个方法 打印一个list当中所有的数据
 *
 * 通配符： 同别府实际上也是一种泛型，一般用在源码中
 * 泛型一般用于读取和写入
 * 通配符一般用于读取
 *
 * 通配符上界：<? extends E>
 * 通配符下界：<? super E>
 */
class Test {
    public static<T> void print(ArrayList<T> list) {
        for (T x:list) {
            System.out.println(x);
        }
    }
}

class MyArrayList<T>{

    public T[] elem;
    public int usedSize;

    public MyArrayList() {
        //this.elem = new T[10];
        this.elem = (T[])new Object[10];
    }

    public void  add(T data) {
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    public T get(int pos) {
        return this.elem[pos];
    }
}


public class TestDemo {

    public static void main(String[] args) {

        Algorithm<Integer> algorithm = new Algorithm<>();
        Integer[] array ={20,2,3,4,11,6,7};
        System.out.println(algorithm.findMaxVal(array));
        System.out.println(Algorithm2.findMaxVal(array));
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println("=======================");
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Test.print(list1);
        System.out.println("=======================");


        /*List<Integer> list = new ArrayList<>();
        int a = 10;
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println("===================");
        System.out.println(list.isEmpty());
        list.addAll(1, Collections.singleton(a));*/
    }
    public static void main1(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();

        myArrayList1.add("adfwerewrf");
        myArrayList1.add("sdfdsf");
        myArrayList1.add("bit");
        String str = myArrayList1.get(2);
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(2);
       int val = myArrayList2.get(1);
        MyArrayList<Double> myArrayList3 = new MyArrayList<>();
       /* MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(19.8);
        myArrayList.add("sadfadsffds");
        String str = (String)myArrayList.get(2);
        System.out.println(str);*/

    }
}
