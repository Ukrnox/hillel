package com.babayan.homeworks.homework_17;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class JsonGetter {
    public static String getJsonString() {
        StringBuilder response;
        try(Socket socket = new Socket("jsonplaceholder.typicode.com", 80);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            String s = "GET /users/5 HTTP/1.1\n" +
                    "Host: jsonplaceholder.typicode.com\n" +
                    "\n" +
                    "\n";
            outputStream.write(s.getBytes());
            response = new StringBuilder();
            System.out.println(socket.isConnected());
            try {
                int ch;
                while (socket.isConnected()) {
                    ch = inputStream.read();
                    System.out.print((char) ch);
                    response.append((char) ch);
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        try {
            String[] split = response.toString().split("\n(?=\\{)");
            return split[1];
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }
}