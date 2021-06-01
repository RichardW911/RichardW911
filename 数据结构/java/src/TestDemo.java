import java.util.Arrays;
import java.util.*;
class Person {

    public String name;// 成员变量/字段 定义在类的内部 方法的外部
    public int age;// 实例成员变量
    public String sex;
    public static int count;// 静态成员变量

    //当成员变量没有初始化的时候 那么这些值是对应的默认值。
    //boolean false
    //char '\u0000'
    //实例成员方法
    public void eat() {
        System.out.println(name + "吃饭！");
    }

    //静态成员方法
    public static void func() {
        System.out.println("static func()");
    }

    public void show() {
        System.out.println("姓名：" + name + " 年龄：" + age);
    }


}
/*
* public:
* private:
* protected:
* 默认：
* */


class TestDemo {


    public static void main5(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.display();
        myLinkedList.reverseList();
        myLinkedList.display();



    }


    /*
java.lang.NullPointerException
  at line 15, Solution.deleteDuplicates
  at line 54, __DriverSolution__.__helper__
  at line 84, __Driver__.main
     */



    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.display();

    }
}













