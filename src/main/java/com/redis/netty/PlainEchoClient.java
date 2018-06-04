package com.redis.netty;

import java.io.*;
import java.net.Socket;

/**
 * @Author: movie
 * @Date: 2018/5/28 16:43
 */
public class PlainEchoClient {
    public void client() throws IOException {
        try {
            Socket client = new Socket("localhost", 9999);
//            PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
//            printWriter.write("hello server :");
//            printWriter.flush();
            DataInputStream dis = new DataInputStream(client.getInputStream());
//            System.out.println(dis.readUTF());
//            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
//            String line = reader.readLine();
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF("ping");
            dos.flush();
            System.out.println(dis.readUTF());
//            printWriter.close();
//            reader.close();
            client.close();
//            System.out.println("receiveed from server:" + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new PlainEchoClient().client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
