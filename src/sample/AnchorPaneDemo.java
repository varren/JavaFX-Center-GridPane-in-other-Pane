package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AnchorPaneDemo  extends Application{
    private GridPane grid;
    private AnchorPane anchorPane;
    private static double GRID_SIZE = 200;
    private static double PANE_SIZE = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {

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

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void updatePosition() {
        double x = (anchorPane.getWidth() - GRID_SIZE) / 2;
        double y = (anchorPane.getHeight() - GRID_SIZE) / 2;

        AnchorPane.setRightAnchor(grid, x);
        AnchorPane.setTopAnchor(grid, y);
        AnchorPane.setLeftAnchor(grid, x);
        AnchorPane.setBottomAnchor(grid, y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
