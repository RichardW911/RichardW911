package org.example;

public class Test extends ababa{

    public static void main(String[] args) {
        ababa ababa = new ababa() {
            @Override
            public int a() {
                return 0;
            }
        };
        int res = ababa.a();
        String str = "i";
        String string = new String("i");
        System.out.println(str == string);
        System.out.println(res);


    }


    public int a() {

        String str = "abc";
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return 1;
    }
}
