package com.redis.netty;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: movie
 * @Date: 2018/5/31 19:10
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket client = serverSocket.accept();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        do {
            double length = dis.readDouble();
            System.out.println("server receive length:" + length);
            dos.writeDouble(length * length);
            dos.flush();
        } while (dis.readInt() != 0);
        serverSocket.close();
        client.close();
    }
}
