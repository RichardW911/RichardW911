import java.util.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int a = 0;
            int b = 0;
            for(int i = n / 2; i < n; i++) {
                if(isSu(i)) {
                    a = i;
                    b = n - i;
                    if(isSu(b)) {
                        System.out.println(b);
                        System.out.println(a);
                        break;
                    }
                }
            }

        }
    }
    public static boolean isSu(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int max = 0;
        while(n > 0) {
            int res = n & 1;
            if(Integer.toBinaryString(res).charAt(0) == '1') {
                count++;
            }else {
                if(max < count) {
                    max = count;
                }
                count = 0;
            }
            n = n >> 1;
        }
        if(max < count) {
            max = count;
        }
        System.out.println(max);
    }
}




class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String res = revest(n);
        System.out.println(res);
    }

    public static String revest(String str) {
        int left = 0;
        int right = str.length() - 1;
        char[] res = str.toCharArray();

        while(left < right) {
            char tmp = res[left];
            res[left] = res[right];
            res[right] = tmp;
            left++;
            right--;
        }

        StringBuilder s = new StringBuilder();
        for (char c :
                res) {
            s.append(c);
        }

        return s.toString();
    }
}

class LCA {
    public static void main(String[] args) {

        char[] a = {'1','1'};
        char b = a[1];
        System.out.println(a[0] == b);
    }
    public static int getLCA(int a, int b) {
        // write code here
        if(a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        while(a != b) {
            if(a == 1 && b == 1) return 1;
            if(a / 2 == b / 2) {
                return b / 2;
            }
            if(a <= b / 2) {
                b = b / 2;
            }else {
                a = a / 2;
                b = b / 2;
            }
            if(a == 1 ) {
                b = b / 2;
            }
            if(b == 1) {
                a = a /2;
            }
        }
        return 0;
    }
}
class Robot {
    public int countWays(int x, int y) {
        // write code here
        if(x == 1 || y == 1)
            return 1;
        return countWays(x - 1,y) + countWays(x,y - 1);
    }
}
class Main2 {
    public static void main(String[] args) {
        Queue<Integer> dog = new LinkedList<>();
        
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            //求出两个数的最大公约数
            int gcd = Gcd(a,b);
            //求最小公倍数
            int lcm = a * b / gcd;
            System.out.println(lcm);
        }
        in.close();

    }
    public static int Gcd(int a,int b) {
        int result = 0;
        if(a > b) {
            for(int i = b; i > 0; i--) {
                if(a % i == 0 && b % i == 0) {
                    result = i;
                    break;
                }
            }
        }else {
            for(int i = a; i > 0; i--) {
                if(a % i == 0 && b % i == 0) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}
class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[][] res =new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            int left = i - 1;
            int right = i + 1;
            //找左边
            while(left >= 0) {
                if (arr[left] < arr[i]) {
                    break;
                }
                left--;
            }
            res[i][0] = left;
            //找右边
            while(right <= n - 1) {
                if (arr[right] < arr[i]) {
                    break;
                }
                right++;
            }
            if(right <= n - 1) {
                res[i][1] = right;
            }else {
                res[i][1] = -1;
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(res[i][0]);
            System.out.print(" ");
            System.out.println(res[i][1]);
        }
    }


}

class TestClass {
   private static void testMethod() {
       System.out.println("testMethod");
   }

    public static void main(String[] args) {
        ((TestClass)null).testMethod();
        String s = "fmn";
        s.toUpperCase();
        System.out.println(s);
        String y =s.replace('f','F');
        y = y + "wxy";
        System.out.println(y);
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] res = new int[2];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i]) + 1);
            }else {
                map.put(arr[i],1);
            }
        }
        int j = 0;

        for(int i = 0; i < n; i++) {
            if(map.get(arr[i]) % 2 != 0) {
                if(j < 2) {
                    res[j] = arr[i];
                    j++;
                }
            }
        }
        System.out.print(res[0] + " "+ res[1]);
    }
}*/
