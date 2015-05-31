package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneDemo  extends Application{

    private static double GRID_SIZE = 200;
    private static double PANE_SIZE = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
