package com.redis.netty;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: movie
 * @Date: 2018/6/4 15:52
 */
public class SocketServerM implements Runnable {
    private Socket socket;
    private int clientNo;

    public SocketServerM(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            do {
                double len = dis.readDouble();
                System.out.println(Thread.currentThread().getName() + "received len :" + len);
                dos.writeDouble(len * len);
                dos.flush();
            } while (dis.readInt() != 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        int clientNum = 1;

        ExecutorService threadPool = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = serverSocket.accept();
            threadPool.execute(new SocketServerM(socket, clientNum));
            clientNum++;
        }
    }
}
