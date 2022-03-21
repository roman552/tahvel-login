
package tahvel;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import login.Login;

public class Tahvel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Button btn = new Button();

        
        textField.setText("sinu isikukood");
        textField.setPrefWidth(300);
        
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
        btn.setText("login");
        btn.setPrefWidth(200);

        
       
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String isikukood = textField.textProperty().getValue();
                System.out.println(isikukood);
                Login.login(isikukood);
                
            }
        });

        
        GridPane gridPane = new GridPane();
        
        gridPane.setVgap(15);
        
        gridPane.add(textField, 0, 0, 2, 1);
        gridPane.add(btn, 1, 1, 1, 1);
        gridPane.setHalignment(textField, HPos.CENTER);
        gridPane.setHalignment(btn, HPos.CENTER);
        
        Scene scene = new Scene(gridPane, 280, 80);
        
        primaryStage.setTitle("Tahvel login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
