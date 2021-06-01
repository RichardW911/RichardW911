package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP 客户端
 */
public class TCPClient {
    // 服务器端 IP
    private static final String ip = "127.0.0.1";

    // 服务器端口号
    private static final int port = 9002;

    public static void main(String[] args) throws IOException {
        // 1.创建 tcp 客户端，并且连接到服务器端
        Socket socket = new Socket(ip, port);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in);
        ) {
            while (true) {
                System.out.print("->");
                String msg = scanner.nextLine();
                // 2.发送消息给服务器端
                writer.write(msg + "\n");
                writer.flush();
                // 3.接收服务器响应的内容
                String serMsg = reader.readLine();
                System.out.println("服务器反馈：" + serMsg);
            }
        }
    }
}
