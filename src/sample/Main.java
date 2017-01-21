package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX ch424");
        primaryStage.show();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(grid, 700, 375);
        primaryStage.setScene(scene);


        Text scenetitle = new Text("Please enter city's names");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label city1 = new Label("Enter the first city:");
        grid.add(city1, 0, 1);
        TextField city1input = new TextField();
        grid.add(city1input, 1, 1);

        Label city2 = new Label("Enter the second city:");
        grid.add(city2, 0, 2);
        TextField city2input = new TextField();
        grid.add(city2input, 1, 2);

        Label city3 = new Label("Enter the Third city:");
        grid.add(city3, 0, 3);
        TextField city3input = new TextField();
        grid.add(city3input, 1, 3);


        Button btn = new Button("set alphabetical order");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text result = new Text();
        grid.add(result, 1, 8);


        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String[] input = new String[3];

                input[0] = city1input.getText().trim();
                input[1] = city2input.getText().trim();
                input[2] = city3input.getText().trim();

                Arrays.sort(input, String.CASE_INSENSITIVE_ORDER);
                result.setFill(Color.FIREBRICK);
                result.setText("The three cities in alphabetical order are " + Arrays.toString(input));
            }
        });
    }

}