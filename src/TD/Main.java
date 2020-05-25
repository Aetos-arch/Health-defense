package TD;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
            BorderPane root = FXMLLoader.load(getClass().getResource("/TD/Vue/vue.fxml"));
            Scene scene = new Scene(root, 1200, 1200);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.centerOnScreen();

        } catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        launch(args);
    }
}
