package com.example.todoquest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloApplication extends Application {

    private Usuario usuario;
    private GerenciadorTarefas gerenciador;

    private VBox taskListArea;
    private VBox taskinfo;
    private ComboBox<String> typeCombo;
    private TextField pointsField;
    private TextField bonusField;
    private TextField descField;

    private ProgressBar forcaBar;
    private ProgressBar inteligenciaBar;
    private ProgressBar culturaBar;
    private ProgressBar sorteBar;
    private ProgressBar levelProgressBar;
    private Label nivelLabel;
    private Label userNameLabel;

    @Override
    public void start(Stage stage) {
        // Initially show the login screen
        Scene loginScene = createLoginScene(stage);
        stage.setScene(loginScene);
        stage.setTitle("Login - TO-DO Quest");
        stage.show();
    }

    private Scene createLoginScene(Stage primaryStage) {
        Label userLabel = new Label("Username:");
        userLabel.setTextFill(Color.WHITE);
        userLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        TextField userField = new TextField();
        Button loginButton = new Button("Login");

        HBox inputBox = new HBox(10, userLabel, userField);
        inputBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, inputBox, loginButton);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #2c2c2c;");

        loginButton.setOnAction(e -> {
            String name = userField.getText().trim();
            if (!name.isEmpty()) {
                usuario = new Usuario(name);
                // set initial attributes and level
                usuario.setNivel(0);
                usuario.setForca(0);
                usuario.setInteligencia(0);
                usuario.setCultura(0);
                usuario.setSorte(0);

                gerenciador = new GerenciadorTarefas();

                // After login, show main scene
                Scene mainScene = createMainScene();
                primaryStage.setTitle("TO-DO Quest - " + usuario.getNome());
                primaryStage.setScene(mainScene);
            } else {
                showAlert("Aviso", "Por favor, insira um nome de usuário.");
            }
        });

        return new Scene(vBox, 300, 150);
    }

    private Scene createMainScene() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #2c2c2c;");

        // Top: Title and User Info
        root.setTop(createTopBar());

        // Left: Attribute bars
        VBox attributeBox = new VBox(15);
        attributeBox.setPadding(new Insets(20));
        attributeBox.setAlignment(Pos.TOP_LEFT);
        forcaBar = createAttributeBar(Color.RED);
        inteligenciaBar = createAttributeBar(Color.BLUE);
        culturaBar = createAttributeBar(Color.ORANGE);
        sorteBar = createAttributeBar(Color.GREEN);

        attributeBox.getChildren().addAll(
                wrapAttributeBar("Força", Color.RED, forcaBar),
                wrapAttributeBar("Inteligência", Color.BLUE, inteligenciaBar),
                wrapAttributeBar("Cultura", Color.ORANGE, culturaBar),
                wrapAttributeBar("Sorte", Color.GREEN, sorteBar)
        );

        taskinfo = new VBox(15);
        taskinfo.setPadding(new Insets(20));
        taskinfo.setAlignment(Pos.TOP_LEFT);

        RefreshTaskInfo();

        VBox leftBox = new VBox(20);
        leftBox.setPadding(new Insets(0));
        leftBox.setAlignment(Pos.TOP_LEFT);

        leftBox.getChildren().addAll(attributeBox, taskinfo);

        root.setLeft(leftBox);

        // Right: Profile image area
        root.setRight(createProfileBox());

        // Bottom: Tasks area
        root.setBottom(createTasksArea());

        Scene scene = new Scene(root, 900, 600);
        refreshTaskList();
        updateAttributeBars();
        return scene;
    }

    private HBox createTopBar() {
        HBox topBox = new HBox();
        topBox.setPadding(new Insets(20, 20, 20, 20));
        topBox.setSpacing(20);
        topBox.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("TO-DO Quest");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Right side of top: Username, Level, and Score Bar
        HBox userInfoBox = new HBox(10);
        userInfoBox.setAlignment(Pos.CENTER_RIGHT);

        userNameLabel = new Label(usuario.getNome());
        userNameLabel.setTextFill(Color.WHITE);
        userNameLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        nivelLabel = new Label("Nível " + usuario.getNivel());
        nivelLabel.setTextFill(Color.WHITE);
        nivelLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        levelProgressBar = new ProgressBar(0.0);
        levelProgressBar.setPrefWidth(150);
        levelProgressBar.setStyle("-fx-accent: #00c8ff;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        userInfoBox.getChildren().addAll(spacer, userNameLabel, nivelLabel, levelProgressBar);
        topBox.getChildren().addAll(title, userInfoBox);

        return topBox;
    }

    private VBox createProfileBox() {
        VBox profileBox = new VBox();
        profileBox.setPadding(new Insets(20));
        profileBox.setAlignment(Pos.CENTER);
        Rectangle profilePlaceholder = new Rectangle(150, 150);
        profilePlaceholder.setFill(Color.rgb(20, 20, 60));
        Label faceLabel = new Label(":-)");
        faceLabel.setTextFill(Color.WHITE);
        faceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        StackPane profileStack = new StackPane(profilePlaceholder, faceLabel);
        profileBox.getChildren().add(profileStack);
        return profileBox;
    }

    private VBox createTasksArea() {
        VBox taskArea = new VBox();
        taskArea.setPadding(new Insets(20));
        taskArea.setSpacing(10);
        taskArea.setStyle("-fx-background-color: #4f4f4f;");

        // Add form to create a new task
        HBox addForm = new HBox(10);
        addForm.setAlignment(Pos.CENTER_LEFT);

        typeCombo = new ComboBox<>();
        typeCombo.getItems().addAll("Forca", "Inteligencia", "Cultura", "Sorte");
        typeCombo.setPromptText("Tipo");

        pointsField = new TextField();
        pointsField.setPromptText("Pontos");
        pointsField.setPrefWidth(60);

        bonusField = new TextField();
        bonusField.setPromptText("Bonus");
        bonusField.setPrefWidth(60);

        descField = new TextField();
        descField.setPromptText("Descrição");
        descField.setPrefWidth(200);

        Button addBtn = new Button("Add Task");
        addBtn.setOnAction(e -> addTask());

        addForm.getChildren().addAll(typeCombo, pointsField, bonusField, descField, addBtn);

        taskListArea = new VBox(5);
        taskListArea.setPadding(new Insets(10));

        taskArea.getChildren().addAll(addForm, taskListArea);
        return taskArea;
    }

    private void addTask() {
        String tipo = typeCombo.getValue();
        if (tipo == null || tipo.isEmpty()) {
            showAlert("Erro", "Selecione um tipo de tarefa.");
            return;
        }

        String desc = descField.getText().trim();
        if (desc.isEmpty()) {
            showAlert("Erro", "Descrição não pode ser vazia.");
            return;
        }

        int pontos;
        int bonus;
        try {
            pontos = Integer.parseInt(pointsField.getText().trim());
            bonus = Integer.parseInt(bonusField.getText().trim());
        } catch (NumberFormatException ex) {
            showAlert("Erro", "Pontos e Bônus devem ser números.");
            return;
        }

        gerenciador.criaTarefa(tipo, pontos, desc, bonus);

        // Clear fields
        typeCombo.setValue(null);
        pointsField.clear();
        bonusField.clear();
        descField.clear();

        refreshTaskList();
        RefreshTaskInfo();
    }

    private Label createTaskInfoLabel(String taskType, int completedTasks, int totalTasks) {
        return new Label(taskType + ": " + completedTasks + "/" + totalTasks + " tarefas completadas");
    }

    private void RefreshTaskInfo(){
        Label forcaInfo = createTaskInfoLabel("Força", gerenciador.getTotalForcaTaskCompleted(), gerenciador.getTotalForcaTasks());
        Label inteligenciaInfo = createTaskInfoLabel("Inteligência", gerenciador.getTotalInteligenciaTaskCompleted(), gerenciador.getTotalInteligenciaTasks());
        Label culturaInfo = createTaskInfoLabel("Cultura", gerenciador.getTotalCulturaTaskCompleted(), gerenciador.getTotalCulturaTasks());
        Label sorteInfo = createTaskInfoLabel("Sorte", gerenciador.getTotalSorteTaskCompleted(), gerenciador.getTotalSorteTasks());

        forcaInfo.setTextFill(Color.WHITE);
        forcaInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        inteligenciaInfo.setTextFill(Color.WHITE);
        inteligenciaInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        culturaInfo.setTextFill(Color.WHITE);
        culturaInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        sorteInfo.setTextFill(Color.WHITE);
        sorteInfo.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        taskinfo.getChildren().clear();
        taskinfo.getChildren().addAll(
                forcaInfo,
                inteligenciaInfo,
                culturaInfo,
                sorteInfo
        );
    }

    private void refreshTaskList() {

        taskListArea.getChildren().clear();

        addTasksOfType("Forca", gerenciador.getTarefasForca());
        addTasksOfType("Inteligencia", gerenciador.getTarefasInteligencia());
        addTasksOfType("Sorte", gerenciador.getTarefasSorte());
        addTasksOfType("Cultura", gerenciador.getTarefasCultura());
    }

    private void addTasksOfType(String tipo, ArrayList<? extends Tarefa> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Tarefa t = tasks.get(i);
            Color bulletColor;
            switch (tipo.toLowerCase()) {
                case "forca": bulletColor = Color.RED; break;
                case "inteligencia": bulletColor = Color.BLUE; break;
                case "sorte": bulletColor = Color.GREEN; break;
                case "cultura": bulletColor = Color.ORANGE; break;
                default: bulletColor = Color.WHITE;
            }

            String dateTime = "Data/Hora";
            int pontos = t.getPontos();
            String bonusStr = getBonusString(t);

            HBox taskItem = createTaskItem(bulletColor, "+"+pontos, bonusStr, t.getDescricao(), dateTime, false, tipo, i, t);
            taskListArea.getChildren().add(taskItem);
        }
    }

    private String getBonusString(Tarefa t) {
        if (t instanceof TarefaForca) {
            return "+" + ((TarefaForca) t).getBonus();
        } else if (t instanceof TarefaInteligencia) {
            return "+" + ((TarefaInteligencia) t).getBonus();
        } else if (t instanceof TarefaSorte) {
            return "+" + ((TarefaSorte) t).getBonus();
        } else if (t instanceof TarefaCultura) {
            return "+" + ((TarefaCultura) t).getBonus();
        }
        return "+0";
    }

    private HBox createTaskItem(Color bulletColor, String points, String bonus, String desc, String dateTime, boolean checked, String tipo, int index, Tarefa t) {
        Rectangle bullet = new Rectangle(10,10);
        bullet.setArcWidth(2);
        bullet.setArcHeight(2);
        bullet.setFill(bulletColor);

        Label pointsLabel = new Label(points);
        pointsLabel.setTextFill(Color.WHITE);
        pointsLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        Label bonusLabel = new Label(bonus);
        bonusLabel.setTextFill(Color.LIGHTGRAY);
        bonusLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        Label descLabel = new Label(desc);
        descLabel.setTextFill(Color.WHITE);
        descLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        Label dateLabel = new Label(dateTime);
        dateLabel.setTextFill(Color.LIGHTGRAY);
        dateLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        CheckBox doneCheck = new CheckBox();
        doneCheck.setSelected(checked);

        doneCheck.setOnAction(e -> {
            if (doneCheck.isSelected()) {
                completeTask(t);
                removeTask(tipo, index);
            }
        });

        Button removeBtn = new Button("Remover");
        removeBtn.setOnAction(e -> removeTask(tipo, index));

        HBox taskBox = new HBox(10, bullet, pointsLabel, bonusLabel, descLabel, dateLabel, doneCheck, removeBtn);
        taskBox.setAlignment(Pos.CENTER_LEFT);
        taskBox.setPadding(new Insets(5));
        return taskBox;
    }

    private void removeTask(String tipo, int index) {
        boolean success = gerenciador.deletaTarefa(tipo, index);
        if (!success) {
            showAlert("Erro", "Não foi possível remover a tarefa. Verifique o índice.");
        } else {
            refreshTaskList();
        }
    }

    private ProgressBar createAttributeBar(Color color) {
        ProgressBar attrBar = new ProgressBar();
        attrBar.setPrefWidth(150);
        attrBar.setStyle("-fx-accent: " + toRgbString(color) + ";");
        return attrBar;
    }

    private HBox wrapAttributeBar(String name, Color color, ProgressBar bar) {
        Label attrLabel = new Label(name);
        attrLabel.setTextFill(Color.WHITE);
        attrLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        HBox box = new HBox(10, bar, attrLabel);
        box.setAlignment(Pos.CENTER_LEFT);
        return box;
    }

    private void completeTask(Tarefa t) {
        if (t instanceof TarefaForca) {
            usuario.setForca(usuario.getForca() + ((TarefaForca) t).getBonus());
            gerenciador.completeForcaTask();
        } else if (t instanceof TarefaInteligencia) {
            usuario.setInteligencia(usuario.getInteligencia() + ((TarefaInteligencia) t).getBonus());
            gerenciador.completeInteligenciaTask();
        } else if (t instanceof TarefaCultura) {
            usuario.setCultura(usuario.getCultura() + ((TarefaCultura) t).getBonus());
            gerenciador.completeCulturaTask();
        } else if (t instanceof TarefaSorte) {
            usuario.setSorte(usuario.getSorte() + ((TarefaSorte) t).getBonus());
            gerenciador.completeSorteTask();

        }

        updateAttributeBars();
        RefreshTaskInfo();
    }

    private void updateAttributeBars() {
        forcaBar.setProgress((double)usuario.getForca() / 100.0);
        inteligenciaBar.setProgress((double)usuario.getInteligencia() / 100.0);
        culturaBar.setProgress((double)usuario.getCultura() / 100.0);
        sorteBar.setProgress((double)usuario.getSorte() / 100.0);

        double totalAttributes = usuario.getForca() + usuario.getInteligencia() + usuario.getCultura() + usuario.getSorte();
        double progress = totalAttributes / 400.0;
        if (progress > 1.0) {
            progress = 0.0;
            usuario.setNivel(usuario.getNivel()+1);
            forcaBar.setProgress(0.0);
            inteligenciaBar.setProgress(0.0);
            culturaBar.setProgress(0.0);
            sorteBar.setProgress(0.0);
            usuario.setForca(0);
            usuario.setInteligencia(0);
            usuario.setSorte(0);
            usuario.setCultura(0);
        }
        levelProgressBar.setProgress(progress);
        nivelLabel.setText("Nível " + usuario.getNivel());
        userNameLabel.setText(usuario.getNome());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle(title);
        alert.showAndWait();
    }

    private String toRgbString(Color c) {
        return String.format("#%02X%02X%02X",
                (int)(c.getRed()*255),
                (int)(c.getGreen()*255),
                (int)(c.getBlue()*255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
