package ru.netology.javacore;

import org.junit.jupiter.api.*;

public class TodosTests {

    Todos sut;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running TodosTests");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("TodosTests completed");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete");
    }

    @BeforeEach
    public void init() {
        sut = new Todos();
    }

    @Test
    public void testAddTask() {
        Todos expected = new Todos();
        expected.todoList.add("D");

        sut.addTask("D");

        Assertions.assertEquals(expected.todoList, sut.todoList);
    }

    @Test
    public void testRemoveTask() {
        Todos expected = new Todos();
        expected.todoList.add("D");

        sut.addTask("D");
        sut.addTask("F");
        sut.removeTask("F");

        Assertions.assertEquals(expected.todoList, sut.todoList);
    }

    @Test
    public void testGetAllTask() {
        Todos list = new Todos();
        list.todoList.add("D");
        list.todoList.add("F");
        StringBuilder sb = new StringBuilder();
        for (String todo : list.todoList) {
            sb.append(todo + " ");
        }
        String expected = sb.toString();

        sut.addTask("D");
        sut.addTask("F");
        String result = sut.getAllTasks();

        Assertions.assertEquals(expected, result);
    }
}
