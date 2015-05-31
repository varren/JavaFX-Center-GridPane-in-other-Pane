package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private GridPane grid;
    private AnchorPane anchorPane;
    private static double GRID_SIZE = 200;
    private static double PANE_SIZE = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.getChildren().addAll(exampleOne(), exampleTwo());

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public Node exampleOne() {
        grid = new GridPane();
        grid.setStyle("-fx-background-color: bisque;");
        grid.add(new Label("Demo with AnchorPane"),1,1);
        grid.setPrefSize(GRID_SIZE, GRID_SIZE);

        anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(grid);
        anchorPane.setStyle("-fx-background-color: cadetblue");
        anchorPane.setPrefSize(PANE_SIZE, PANE_SIZE);

        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                updatePosition();
            }
        });

        anchorPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                updatePosition();
            }
        });

        updatePosition();

        return anchorPane;
    }

    public void updatePosition() {
        double x = (anchorPane.getWidth() - GRID_SIZE) / 2;
        double y = (anchorPane.getHeight() - GRID_SIZE) / 2;

        AnchorPane.setRightAnchor(grid, x);
        AnchorPane.setTopAnchor(grid, y);
        AnchorPane.setLeftAnchor(grid, x);
        AnchorPane.setBottomAnchor(grid, y);
    }

    public Node exampleTwo() {
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: bisque;");
        grid.add(new Label("Demo with StackPane"),1,1);
        grid.setPrefSize(GRID_SIZE, GRID_SIZE);
        grid.setMaxSize(GRID_SIZE, GRID_SIZE);
        grid.setMinSize(GRID_SIZE, GRID_SIZE);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: cadetblue");
        root.setPrefSize(PANE_SIZE, PANE_SIZE);

        StackPane.setAlignment(grid, Pos.CENTER);
        root.getChildren().addAll(grid);
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
