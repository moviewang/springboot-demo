package com.redis.netty;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: movie
 * @Date: 2018/5/28 16:29
 */
public class PlainEchoServer {
    public void server(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("Accepted connection from " + client);
//                new Thread(() -> {
                    try {
                        DataInputStream dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

//                        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                        String line = dis.readUTF();
                        System.out.println("server reply :" + line);
//                        pw.println("server reply" + line);
                        dos.writeUTF(line);
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (client != null) {
                            try {
                                client.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
//                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new PlainEchoServer().server(9999);
    }
}
