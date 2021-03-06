package com.babayan.homeworks.homework_17;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class JsonGetter {
    public static String getJsonString() throws IOException {
        Socket socket = new Socket("jsonplaceholder.typicode.com", 80);
        InputStream inputStream = socket.getInputStream();
        String s = "GET /users/5 HTTP/1.1\n" +
                "Host: jsonplaceholder.typicode.com\n" +
                "\n" +
                "\n";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(s.getBytes());
        int ch;
        StringBuilder response = new StringBuilder();
        try {
            while ((ch = inputStream.read()) != -1) {
                response.append((char) ch);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        String[] split = response.toString().split("\n(?=\\{)");
        return split[1];
    }
}