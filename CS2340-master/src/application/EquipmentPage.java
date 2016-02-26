package application;

import java.net.URL;
import java.util.ResourceBundle;
import view.Main;
import javafx.fxml.Initializable;

/**
 * This class generates the Equipment market page of the screen.
 *
 * @author Utkarsh Garg
 */

public class EquipmentPage implements Initializable {

	/**
	 * This method initializes the equipment page.
	 *
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	/**
	 * This method makes a call to set up the MarketPlace page.
	 */
	public final void goToMarketplace() {
		Main.setScene("MarketPlace.fxml");
	}
}
