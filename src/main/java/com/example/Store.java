package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private static String filePath = "todo.txt";

    public static List<String> read() {
        try {
            return tryRead();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> tryRead() throws FileNotFoundException {
        File file = new File(filePath);
        List<String> todoList = new ArrayList<>();
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                todoList.add(sc.nextLine());
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return todoList;
    }

    public static void appendTodoToFile(String todo) {
        try {
            tryAppendTodoToFile(todo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tryAppendTodoToFile(String todo) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, Charset.forName("utf-8"),
                true);) {
            fw.write(todo);
            fw.write("\n");
        }
    }

    public static void save(List<String> todoList){
        try {
            trySave(todoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void trySave(List<String> todoList) throws IOException{
        try (FileWriter fw = new FileWriter(filePath,Charset.forName("utf-8"),false)){
            for(String todo :todoList){
                fw.write(todo);
                fw.write("\n");
            }
        }
    }
}
