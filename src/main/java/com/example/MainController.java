package com.example;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML
    private TextArea editField;

    @FXML
    private ListView<String> listField;

    @FXML
    private Label statusLabel;

    @FXML

    void initialize(){
        System.out.println("init....");
        List<String> todoList = Store.read();
        listField.getItems().addAll(todoList);
    }

    @FXML
    void onClickAddButton(ActionEvent event) {
        String newTodo = editField.getText();
        if(!newTodo.isEmpty()){
        listField.getItems().add(newTodo);
        Store.appendTodoToFile(newTodo);
        editField.setText("");
        statusLabel.setText("Státusz");
        }else{
            statusLabel.setText("Üres a szerkesztő mező");
        }

    }

    @FXML
    void onClickDelButton(ActionEvent event) {
        Object delItem = listField.getSelectionModel().getSelectedItem();
        if (delItem != null ){
            listField.getItems().remove(delItem);
            Store.save(listField.getItems());
        }

    }

    @FXML
    void onClickModifyButton(ActionEvent event) {

    }

}
