package com.redis.netty;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: movie
 * @Date: 2018/5/31 19:23
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        while (!flag) {
            System.out.println("input side:");
            double length = scanner.nextDouble();
            dos.writeDouble(length);
            dos.flush();
            double area = dis.readDouble();
            System.out.println("area:" + area);
            while (true) {
                System.out.println("continue Y/N");
                String next = scanner.next();
                if ("N".equalsIgnoreCase(next)) {
                    dos.writeInt(0);
                    dos.flush();
                    flag = true;
                    break;
                } else if ("Y".equalsIgnoreCase(next)) {
                    dos.writeInt(1);
                    dos.flush();
                    break;
                } else {
                    System.out.println("next:" + next);
                }
            }
        }
        socket.close();
    }
}

