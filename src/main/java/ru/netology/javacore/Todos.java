package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    protected List<String> todoList = new ArrayList<>();

    public void addTask(String task) {
        todoList.add(task);
    }

    public void removeTask(String task) {
        todoList.remove(task);
    }

    public String getAllTasks() {

        Collections.sort(todoList);
        StringBuilder sb = new StringBuilder();
        for (String todo : todoList) {
            sb.append(todo + " ");
        }
        return sb.toString();
    }

}
