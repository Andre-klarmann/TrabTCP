package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    // Lista para armazenar as tarefas
    private ObservableList<String> tasks = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List Manager");

        // Layout principal
        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 20px;");

        // Campo de texto para adicionar novas tarefas
        TextField taskInput = new TextField();
        taskInput.setPromptText("Digite uma nova tarefa...");
        taskInput.setMaxWidth(300);

        // Botão para adicionar tarefas
        Button addButton = new Button("Adicionar Tarefa");

        // ListView para exibir as tarefas
        ListView<String> taskListView = new ListView<>(tasks);
        taskListView.setPrefSize(300, 200);

        // Botão para remover a tarefa selecionada
        Button removeButton = new Button("Remover Tarefa");

        // Adiciona evento para adicionar tarefa
        addButton.setOnAction(event -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskInput.clear();
            }
        });

        // Adiciona evento para remover tarefa
        removeButton.setOnAction(event -> {
            String selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                tasks.remove(selectedTask);
            }
        });

        // Layout para a parte superior
        HBox inputLayout = new HBox(10, taskInput, addButton);
        inputLayout.setAlignment(Pos.CENTER);

        // Layout principal de adição e listagem de tarefas
        mainLayout.getChildren().addAll(inputLayout, taskListView, removeButton);

        // Cena e configuração do palco
        Scene scene = new Scene(mainLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
