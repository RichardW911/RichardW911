import java.util.Scanner;

public class ShuiXianHuaShu {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            int count = 0;
            int tmp = i;
            while(tmp != 0) {
                count++;
                tmp = tmp/10;
            }
            tmp = i;
            int sum = 0;
            while(tmp != 0) {
                sum += Math.pow(tmp%10,count);
                tmp /= 10;
            }
            if(sum == i) {
                System.out.println(i);
            }
        }
    }
}
