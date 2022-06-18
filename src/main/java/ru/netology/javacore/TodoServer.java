package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;

public class TodoServer {
    private int port;
    private Todos todos;


    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        JSONParser parser = new JSONParser();

        try (ServerSocket serverSocket = new ServerSocket(8989);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String resp = in.readLine();
                    Object obj = parser.parse(resp);
                    JSONObject jsonObject = (JSONObject) obj;
                    String parseType = (String) jsonObject.get("type");
                    String parseTask = (String) jsonObject.get("task");

                    if (parseType.equals("ADD")) {
                        todos.addTask(parseTask);
                    } else if
                    (parseType.equals("REMOVE")) {
                        todos.removeTask(parseTask);
                    }
                    out.println(todos.getAllTasks());
                }
            }

        } catch (IOException | ParseException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
