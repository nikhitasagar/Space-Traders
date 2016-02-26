package application;

import java.net.URL;
import java.util.ResourceBundle;

import model.GameData;
import model.Person;
import model.PiratePlayer;
import model.Planet;
import model.Ship;
import model.savedGames;
import view.Main;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

public class PirateInteraction implements Initializable {

	// moving objects
	@FXML
	ImageView personImage;
	@FXML
	ImageView shipImage;
	@FXML
	ImageView laser1;
	@FXML
	ImageView laser2;

	// information objects
	@FXML
	Label hpLabelShip;
	@FXML
	Label hpLabelPerson;
	@FXML
	ProgressBar hpBarShip;
	@FXML
	ProgressBar hpBarPerson;

	private GameData d;
	private Person person;
	private Ship ship;
	private Planet planet;
	private PiratePlayer pirate;

	@Override
	public final void initialize(final URL arg0, final ResourceBundle arg1) {
		// TODO Auto-generated method stub
		d = GameData.getData();
		person = d.getPerson();
		ship = person.getShip();
		planet = person.getPlanet();
		pirate = planet.getCurrentPirate();
		updateLabels();
	}

	public final void updateLabels() {
		hpLabelShip.setText("HP: " + Math.max(0, pirate.getStrength()) + "/"
				+ pirate.getShip().getMaxHullStrength());
		hpBarShip.setProgress((double) Math.max(0, pirate.getStrength())
				/ pirate.getShip().getMaxHullStrength());

		hpLabelPerson.setText("HP: " + Math.max(0, ship.getHullStrength())
				+ "/" + ship.getMaxHullStrength());
		hpBarPerson.setProgress((double) Math.max(0, ship.getHullStrength())
				/ ship.getMaxHullStrength());
	}

	@FXML
	public final void returnToMainScreen() {
		Main.setScene("../view/Game.fxml");
	}

	@FXML
	public final void move() {
		// do actual stuff here

		// animate here
		// move your man first
		Path path = new Path();
		path.getElements().add(new MoveTo(74, 134));
		path.getElements().add(new HLineTo(104));
		path.getElements().add(new HLineTo(74));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(400));
		pathTransition.setNode(personImage);
		pathTransition.setPath(path);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(true);
		pathTransition.play();
		// move the ship then
		Path path2 = new Path();
		path2.getElements().add(new MoveTo(126, 88));
		path2.getElements().add(new HLineTo(156));
		path2.getElements().add(new MoveTo(156, 88));
		path2.getElements().add(new VLineTo(111));
		path2.getElements().add(new VLineTo(88));
		path2.getElements().add(new VLineTo(111));
		path2.getElements().add(new VLineTo(88));
		path2.getElements().add(new MoveTo(156, 88));
		path2.getElements().add(new HLineTo(126));
		PathTransition pathTransition2 = new PathTransition();
		pathTransition2.setDuration(Duration.millis(400));
		pathTransition2.setNode(shipImage);
		pathTransition2.setPath(path2);
		pathTransition2.setCycleCount(1);
		pathTransition2.setAutoReverse(true);
		pathTransition2.play();
		// the lasers
		Path path3 = new Path();
		path3.getElements().add(new MoveTo(20, 10));
		path3.getElements().add(new LineTo(350, -100));
		PathTransition pathTransition3 = new PathTransition();
		pathTransition3.setDuration(Duration.millis(200));
		pathTransition3.setNode(laser1);
		pathTransition3.setPath(path3);
		pathTransition3.setCycleCount(1);
		pathTransition3.setAutoReverse(true);
		pathTransition3.play();
		Path path4 = new Path();
		path4.getElements().add(new MoveTo(20, 0));
		path4.getElements().add(new LineTo(350, -150));
		PathTransition pathTransition4 = new PathTransition();
		pathTransition4.setDuration(Duration.millis(200));
		pathTransition4.setNode(laser2);
		pathTransition4.setPath(path4);
		pathTransition4.setCycleCount(1);
		pathTransition4.setAutoReverse(true);
		pathTransition4.play();

		// Exchanging damage.
		System.out.println("AND THE PLAYER ATTACKS!!");
		// reduce hull strength from pirate
		// reduce hull strength from player
		ship.hullStrength -= 1;
		pirate.setPirateStrength(pirate.getStrength() - person.damage);
		System.out.println(pirate.ship.hullStrength);
		System.out.println(ship.hullStrength);

		// CHECK FOR NEGATIVE BEFORE
		// UPDATING HEALTH BAR.
		updateLabels();
		if (pirate.getStrength() < 0) {
			returnToMainScreen();
		}

	}

	@FXML
	public final void save() {
		savedGames saveNewGame = new savedGames();
		saveNewGame.writeToFile();
		Main.setScene("Game.fxml");
	}

}
