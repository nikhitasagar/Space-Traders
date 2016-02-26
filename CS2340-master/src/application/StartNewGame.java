package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import view.Main;
import model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
//import javafx.scene.control.TextArea;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
import javafx.scene.shape.Shape;

/**
 * This class generates the player configuration screen where the player assigns
 * skill points and a name for his game session.
 *
 * @author Utkarsh Garg
 */

public class StartNewGame implements Initializable {

	public Label pilotPoints;
	public Label fighterPoints;
	public Label traderPoints;
	public Label engineerPoints;
	public Label investorPoints;
	public Label skillPoints;
	public TextField nameField;

	private Shape shape;

	private GameData d;
	private Person person;
	private Universe universe;

	@Override
	public final void initialize(final URL location,
			final ResourceBundle resources) {
		pPointsIncrement();
		pPointsDecrement();
		fPointsIncrement();
		fPointsDecrement();
		tPointsIncrement();
		tPointsDecrement();
		ePointsIncrement();
		ePointsDecrement();
		iPointsIncrement();
		iPointsDecrement();
	}

	public final void pPointsIncrement() {
		if ((Integer.parseInt(pilotPoints.getText())) < 15
				&& skillPointsModify() < 15) {
			pilotPoints.setText((Integer.parseInt(pilotPoints.getText()) + 1)
					+ "");
		}
		skillPointsModify();
	}

	public final void pPointsDecrement() {
		if ((Integer.parseInt(pilotPoints.getText())) > 0) {
			pilotPoints.setText((Integer.parseInt(pilotPoints.getText()) - 1)
					+ "");
		}
		skillPointsModify();
	}

	public final void fPointsIncrement() {
		if ((Integer.parseInt(fighterPoints.getText())) < 15
				&& skillPointsModify() < 15) {
			fighterPoints
					.setText((Integer.parseInt(fighterPoints.getText()) + 1)
							+ "");
		}
		skillPointsModify();
	}

	public final void fPointsDecrement() {
		if ((Integer.parseInt(fighterPoints.getText())) > 0) {
			fighterPoints
					.setText((Integer.parseInt(fighterPoints.getText()) - 1)
							+ "");
		}
		skillPointsModify();
	}

	public final void tPointsIncrement() {
		if ((Integer.parseInt(traderPoints.getText())) < 15
				&& skillPointsModify() < 15) {
			traderPoints.setText((Integer.parseInt(traderPoints.getText()) + 1)
					+ "");
		}
		skillPointsModify();
	}

	public final void tPointsDecrement() {
		if ((Integer.parseInt(traderPoints.getText())) > 0) {
			traderPoints.setText((Integer.parseInt(traderPoints.getText()) - 1)
					+ "");
		}
		skillPointsModify();
	}

	public final void ePointsIncrement() {
		if ((Integer.parseInt(engineerPoints.getText())) < 15
				&& skillPointsModify() < 15) {
			engineerPoints
					.setText((Integer.parseInt(engineerPoints.getText()) + 1)
							+ "");
		}
		skillPointsModify();
	}

	public final void ePointsDecrement() {
		if ((Integer.parseInt(engineerPoints.getText())) > 0) {
			engineerPoints
					.setText((Integer.parseInt(engineerPoints.getText()) - 1)
							+ "");
		}
		skillPointsModify();
	}

	public final void iPointsIncrement() {
		if ((Integer.parseInt(investorPoints.getText())) < 15
				&& skillPointsModify() < 15) {
			investorPoints
					.setText((Integer.parseInt(investorPoints.getText()) + 1)
							+ "");
		}
		skillPointsModify();
	}

	public final void iPointsDecrement() {
		if ((Integer.parseInt(investorPoints.getText())) > 0) {
			investorPoints
					.setText((Integer.parseInt(investorPoints.getText()) - 1)
							+ "");
		}
		skillPointsModify();
	}

	public final int skillPointsModify() {
		int skillVal = Integer.parseInt(pilotPoints.getText())
				+ Integer.parseInt(fighterPoints.getText())
				+ Integer.parseInt(traderPoints.getText())
				+ Integer.parseInt(engineerPoints.getText())
				+ Integer.parseInt(investorPoints.getText());
		skillPoints.setText(skillVal + "");
		return skillVal;
	}

	@FXML
	public final void cancelAction() {
		Main.setScene("welcomeScreen.fxml");
	}

	@FXML
	public final void proceed() {
		String name = nameField.getText();
		int[] skills = { Integer.parseInt(pilotPoints.getText()),
				Integer.parseInt(fighterPoints.getText()),
				Integer.parseInt(traderPoints.getText()),
				Integer.parseInt(engineerPoints.getText()),
				Integer.parseInt(investorPoints.getText()) };
		if (skillPointsModify() == 15 && !nameField.getText().equals("")) {
			d = new GameData();
			person = new Person(name, skills);
			universe = new Universe();
			createUniverse();
			person.setPlanet(universe.getStartingSolarSystem());
			person.getPlanet().toggleDrasticEvents();
			d.setPerson(person);
			d.setUniverse(universe);
			GameData.setData(d);
			Main.setScene("Game.fxml");
		}
	}

	private void createUniverse() {
		// this method is there because Serializable does not allow
		// java.scene.Shape to be saved (since its not Serializable)
		// but we still want to ensure that there are no overlapping
		// planets
		int loop = universe.getUniverseSize();
		shape = new Circle(1, 1, 1);
		Random gen = new Random();
		for (int i = 0; i < loop; i++) {
			int x = gen.nextInt(Universe.UNIVERSE_LENGTH + 1);
			int y = gen.nextInt(Universe.UNIVERSE_WIDTH + 1);

			while (shape.contains(x, y)) {
				x = gen.nextInt(Universe.UNIVERSE_LENGTH) + 1;
				y = gen.nextInt(Universe.UNIVERSE_WIDTH) + 1;
			}
			shape = Shape.union(shape, new Circle(x, y, 7));
			universe.addPlanet(x, y, i);
		}
	}
}
