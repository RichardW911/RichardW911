package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {
    //服务器端IP
    private  static final String ip = "1.116.201.185";
    //服务器端口号
    private static final int port = 9002;
    //数据包大小
    private static final int blength = 1024;
    public static void main(String[] args) throws IOException {
        //1.创建客户端
        DatagramSocket datagramSocket = new DatagramSocket();
        //让用户来输入发送的消息
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("->");
            //接收到用户输入的信息
            String msg = scanner.nextLine();
            //2.构建发送数据包
            DatagramPacket datagramPacketPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            //3.发送消息
            datagramSocket.send(datagramPacketPacket);
            //接收服务器的消息
            DatagramPacket serPacket = new DatagramPacket(new byte[blength],blength);
            datagramSocket.receive(serPacket);
            System.out.println("收到服务器端信息：" + new String(serPacket.getData()));
        }
    }
}
