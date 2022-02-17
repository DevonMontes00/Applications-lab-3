package application;
	

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane mainLayout;
	
	/**
	 * This method starts the application the Federation App
	 * 
	 * @param primaryStage primaryStage for the app
	 * @author iog693
	 * @throws IOException
	 */
	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Federation App");
		showMainView();
	}
	
	/**
	 * Shows the main view of the application
	 * 
	 * @author iog693
	 * @throws IOException
	 */
	public void showMainView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Main.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * main function that launches the application
	 * 
	 * @author iog693
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}
