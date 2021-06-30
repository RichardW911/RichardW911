import com.sun.deploy.uitoolkit.impl.text.TextPluginUIToolkit;
import com.sun.org.apache.xerces.internal.xinclude.XInclude11TextReader;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLFault;
import sun.net.httpserver.HttpServerImpl;

import javax.net.ssl.SSLServerSocket;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.*;



import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int n = sc.nextInt();

        while(sc.hasNext()) {
            for(int i = 0; i < n; i++) {
                String[] str = sc.nextLine().split(" ");
                if(str[1].equals("connect")) {
                    stack.push(str[0]);
                    if(stack.size() > max) {
                        max = stack.size();
                    }
                }else if(str[1].equals("disconnect")) {
                    stack.pop();
                }
            }
            System.out.println(max);
        }
        TimeUnit.SECONDS.sleep(100);
    }
    Semaphore semaphore = new Semaphore(2,true);
}


class Main99
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while((str=br.readLine())!=null)
        {
            String[] strs= str.split(" ");
            int m= Integer.parseInt(strs[0]);
            int n= Integer.parseInt(strs[1]);
            int[][] nums=new int[m][n];
            for(int i=0;i<m;i++){
                String strr = br.readLine();
                String[] b = strr.split(" ");
                for(int j=0;j<n;j++){
                    nums[i][j] = Integer.parseInt(b[j]);
                }
            }
            String[] res={""};
            peocess(nums,0,0,"(0,0)\n",res);
            if(res[0].length()==0)
                System.out.println("(0,0)");
            else System.out.println(res[0].substring(0,res[0].length()-1));
        }
    }
    public static void peocess(int[][]arr,int x,int y,String path,String[]res)
    {
        if ((x==arr.length-1)&&(y==arr[x].length-1))
        {
            if (arr[x][y]==0)
                res[0]=path;
            return;
        }
        if (x>arr.length-1||y>arr[x].length-1)
            return;

        if (x+1<arr.length&&arr[x+1][y]==0)
            peocess(arr,x+1,y,path+"("+(x+1)+","+y+")\n",res);
        if (y+1<arr[x].length&&arr[x][y+1]==0)
            peocess(arr,x,y+1,path+"("+x+","+(y+1)+")\n",res);
    }
}


/*
public class Main {
    private int n;
    private int m;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }



    }

    public void backTrack(int[][] nums,int n, int m, int i, int j) {


        if(i == n - 1 && j == m - 1 ) {
            return;
        }

        for(; j < m; j++) {

            if(nums[i][j] == 1 || j + 1 >= m) {
                backTrack(nums,n,m,i + 1, j);
            }

        }


        backTrack(nums,n,m,i,j - 1);
    }
}
*/











class Main10 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = findFib(n);
        if(res == -1) System.out.println("null");
        else System.out.println(res);





        /*Scanner in = new Scanner(System.in);
        HashMap<Character,Integer> map = new HashMap<>();
        while (in.hasNext()) {
            String str = in.nextLine();
            char[] ch = str.toCharArray();
            for (char c : ch) {
                if(map.containsKey(c)) {
                    map.put(c,map.get(c) + 1);
                } else {
                    map.put(c,1);
                }
            }

            int i;
            for(i = 0; i < ch.length; i++) {
                if(map.get(ch[i]) == 1) {
                    System.out.println(ch[i]);
                    break;
                }
            }
            if(i == ch.length) {
                System.out.println("-1");
            }
        }*/
    }

    public static int Fib1(int n) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;
        return Fib1(n - 1) + Fib1(n - 2);
    }


    public static int Fib2(int n) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;
        int a = 0;
        int b = 1;
        for(int i = n - 2; i > 0; i--) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }


    public static int findFib(int n) {
        if(n == 0) return 1;
        if(n == 1) return 2;
        int a = 0;
        int b = 1;
        int count = 2;
        while(b < n) {
            int c = a + b;
            a = b;
            b = c;
            count++;
        }
        if(b != n) {
            return -1;
        }else {
            return count;
        }

    }
}
/*
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();//怪物数量
            int a = in.nextInt();//小易的初始能力值
            int[] num = new int[n];//每个怪物的防御力
            for(int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }

            for(int i = 0; i < n; i++) {
                if(a >= num[i]) {
                    a = a + num[i];
                } else {
                    a = a + GCD(a,num[i]);
                }
            }

            System.out.println(a);
        }
    }


    //求最大公约数
    public static int GCD(int m,int n) {
        if(m<n) {
            int k=m;
            m=n;
            n=k;
        }
        //if(m%n!=0) {
        //    m=m%n;
        //    return gcd(m,n);
        //}
        //return n;
        return m%n == 0?n:GCD(n,m%n);
    }
}*/
