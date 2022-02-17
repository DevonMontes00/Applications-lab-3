package application.view;



import application.model.Fleet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class MainController implements EventHandler <ActionEvent> {
	
	@FXML
	private AnchorPane mainLayout;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private TextField shipText;
	
	@FXML
	private TextArea info;
	
	public void handle(ActionEvent e)
	{
		Fleet f = new Fleet("MotherShip");
		f.loadStarships("data/fleet.csv");
		f.loadMembers("data/personnel.csv");
		
		String ans = shipText.getText();
		ShipText(ans, f);
	}
	
	public void ShipText(String shipText, Fleet f) 
	{
		String ship = f.searchStarship(shipText);
		
		if(ship.equals(""))
		{
			info.setText("Invaild: Starship not found in database \nPlease input a valid starship name");
		}
		
		else 
		{
			info.setText(ship);
		}
			
	}
	
}
