package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import view.Main;
import model.GameData;
import model.MarketPlace;
import model.Mercenaries;
import model.Person;
import model.savedGames;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MercenaryPage implements Initializable {
	// instance variables
	private GameData d;
	private Person person;
	private MarketPlace market;
	private ArrayList<Mercenaries> mercenaryList;
	private int currentView;
	private int price;
	private int[] skills;

	private final int BASE_PRICE = 5000;

	@FXML
	AnchorPane anchor;

	// fxml objects on menuBar
	@FXML
	Label playerName;
	@FXML
	Label money;
	@FXML
	Label cargoBayStatus;
	@FXML
	Label fuelLabel;
	@FXML
	Label playerTurn;

	// fxml objects on the page
	@FXML
	ImageView fighterImage;
	@FXML
	ImageView pilotImage;
	@FXML
	ImageView engineerImage;
	@FXML
	ImageView traderImage;
	@FXML
	ImageView investorImage;
	@FXML
	ImageView rightArrow;
	@FXML
	ImageView leftArrow;
	@FXML
	Label name;
	@FXML
	Label noMoney;
	@FXML
	Label noMoreCrew;
	@FXML
	Label priceLabel;
	@FXML
	Label skillChange0;
	@FXML
	Label skillChange1;
	@FXML
	Label skillChange2;
	@FXML
	Label skillChange3;
	@FXML
	Label skillChange4;
	@FXML
	ProgressBar progressBar01;
	@FXML
	ProgressBar progressBar02;
	@FXML
	ProgressBar progressBar03;
	@FXML
	ProgressBar progressBar04;
	@FXML
	ProgressBar progressBar05;
	@FXML
	ProgressBar progressBar11;
	@FXML
	ProgressBar progressBar12;
	@FXML
	ProgressBar progressBar13;
	@FXML
	ProgressBar progressBar14;
	@FXML
	ProgressBar progressBar15;

	@FXML
	ImageView activePerson1;
	@FXML
	ImageView inactivePerson1;
	@FXML
	ImageView activePerson2;
	@FXML
	ImageView inactivePerson2;

	@Override
	public final void initialize(final URL location,
			final ResourceBundle resources) {
		d = GameData.getData();
		person = d.getPerson();
		market = person.getPlanet().getMarketPlace();
		mercenaryList = market.getMercenaries();

		currentView = 0;
		updateArrows();
		// initialize the labels
		setSkillsAndName(0);
		menuBarLabels();
		updateLabels();
		crewUpdate();
		// initialize menuBar items

	}

	private void crewUpdate() {
		inactivePerson2.setVisible(true);
		inactivePerson1.setVisible(false);
		activePerson2.setVisible(false);
		activePerson1.setVisible(false);
		if (person.getShip().getCrewCapacity() == 1) {
			if (person.getShip().getCrewCount() == 1) {
				inactivePerson2.setVisible(false);
				activePerson2.setVisible(true);
			}
		} else {
			inactivePerson1.setVisible(true);
			if (person.getShip().getCrewCount() == 1) {
				inactivePerson2.setVisible(false);
				activePerson2.setVisible(true);
			} else if (person.getShip().getCrewCount() == 2) {
				inactivePerson2.setVisible(false);
				activePerson2.setVisible(true);
				inactivePerson1.setVisible(false);
				activePerson1.setVisible(true);
			}
		}
	}

	private void menuBarLabels() {
		playerName.setText("Welcome " + person.getName() + "!");
		money.setText("$" + person.myMoney);
		cargoBayStatus.setText("" + person.getShip().getCargoBayCount() + "/"
				+ person.getShip().getCargoBayCapacity());
		fuelLabel.setText("" + person.getShip().getFuel());
		playerTurn.setText("" + person.getTurn());
	}

	private void setSkillsAndName(final int current) {
		// create getName methods
		Mercenaries temp = mercenaryList.get(current);
		updateImage(temp);

		name.setText("Name: " + temp.getName());
		// showing primary occupation
		if (temp.getMaxSkill() == 0) {
			name.setText(name.getText() + " (Pilot)");
		} else if (temp.getMaxSkill() == 1) {
			name.setText(name.getText() + " (Fighter)");
		} else if (temp.getMaxSkill() == 2) {
			name.setText(name.getText() + " (Trader)");
		} else if (temp.getMaxSkill() == 3) {
			name.setText(name.getText() + " (Engineer)");
		} else {
			name.setText(name.getText() + " (Investor)");
		}

		// get skills array for mercenary and person
		int[] skills = temp.getSkills();
		int[] personSkills = person.getSkills();

		// setting baseline bars
		progressBar01.setProgress((personSkills[0] / 15.0));
		progressBar02.setProgress((personSkills[1] / 15.0));
		progressBar03.setProgress((personSkills[2] / 15.0));
		progressBar04.setProgress((personSkills[3] / 15.0));
		progressBar05.setProgress((personSkills[4] / 15.0));

		// setting upgrade bars
		progressBar11.setProgress((personSkills[0] + skills[0]) / 15.0);
		progressBar12.setProgress((personSkills[1] + skills[1]) / 15.0);
		progressBar13.setProgress((personSkills[2] + skills[2]) / 15.0);
		progressBar14.setProgress((personSkills[3] + skills[3]) / 15.0);
		progressBar15.setProgress((personSkills[4] + skills[4]) / 15.0);

		// creating fadeTransition for all the bars
		FadeTransition f1 = new FadeTransition(Duration.millis(750),
				progressBar11);
		f1.setFromValue(0.5);
		f1.setToValue(0.3);
		f1.setCycleCount(Animation.INDEFINITE);
		f1.setAutoReverse(true);
		f1.play();

		FadeTransition f2 = new FadeTransition(Duration.millis(750),
				progressBar12);
		f2.setFromValue(0.5);
		f2.setToValue(0.3);
		f2.setCycleCount(Animation.INDEFINITE);
		f2.setAutoReverse(true);
		f2.play();

		FadeTransition f3 = new FadeTransition(Duration.millis(750),
				progressBar13);
		f3.setFromValue(0.5);
		f3.setToValue(0.3);
		f3.setCycleCount(Animation.INDEFINITE);
		f3.setAutoReverse(true);
		f3.play();

		FadeTransition f4 = new FadeTransition(Duration.millis(750),
				progressBar14);
		f4.setFromValue(0.5);
		f4.setToValue(0.3);
		f4.setCycleCount(Animation.INDEFINITE);
		f4.setAutoReverse(true);
		f4.play();

		FadeTransition f5 = new FadeTransition(Duration.millis(750),
				progressBar15);
		f5.setFromValue(0.5);
		f5.setToValue(0.3);
		f5.setCycleCount(Animation.INDEFINITE);
		f5.setAutoReverse(true);
		f5.play();

		int value0 = personSkills[0] + skills[0];
		int value1 = personSkills[1] + skills[1];
		int value2 = personSkills[2] + skills[2];
		int value3 = personSkills[3] + skills[3];
		int value4 = personSkills[4] + skills[4];

		int point0 = (Math.min(15, value0) - personSkills[0]);
		int point1 = (Math.min(15, value1) - personSkills[1]);
		int point2 = (Math.min(15, value2) - personSkills[2]);
		int point3 = (Math.min(15, value3) - personSkills[3]);
		int point4 = (Math.min(15, value4) - personSkills[4]);

		int pointTotal = point0 + point1 + point2 + point3 + point4;
		int price = (int) (((double) pointTotal / 15) * BASE_PRICE);

		priceLabel.setText("Price: $" + price);

		int skill0 = Math.min(15, value0);
		int skill1 = Math.min(15, value1);
		int skill2 = Math.min(15, value2);
		int skill3 = Math.min(15, value3);
		int skill4 = Math.min(15, value4);

		this.skills = new int[] { skill0, skill1, skill2, skill3, skill4 };

		skillChange0.setText(Math.min(15, value0) + " (+" + (point0) + ")");
		skillChange1.setText(Math.min(15, value1) + " (+" + (point1) + ")");
		skillChange2.setText(Math.min(15, value2) + " (+" + (point2) + ")");
		skillChange3.setText(Math.min(15, value3) + " (+" + (point3) + ")");
		skillChange4.setText(Math.min(15, value4) + " (+" + (point4) + ")");

	}

	private void updateLabels() {
		if (person.myMoney < price) {
			noMoney.setVisible(true);
		} else {
			noMoney.setVisible(false);
		}

		if (person.getShip().getCrewCount() == person.getShip()
				.getCrewCapacity()) {
			noMoreCrew.setVisible(true);
		} else {
			noMoreCrew.setVisible(false);
		}
	}

	private void updateImage(final Mercenaries current) {
		// reset everythign
		pilotImage.setVisible(false);
		fighterImage.setVisible(false);
		traderImage.setVisible(false);
		engineerImage.setVisible(false);
		investorImage.setVisible(false);

		// take the highest skill
		int maxSkillIndex = current.getMaxSkill();
		// change image
		Image temp;
		if (maxSkillIndex == 0) {
			pilotImage.setVisible(true);
		} else if (maxSkillIndex == 1) {
			fighterImage.setVisible(true);
		} else if (maxSkillIndex == 2) {
			traderImage.setVisible(true);
		} else if (maxSkillIndex == 3) {
			engineerImage.setVisible(true);
		} else {
			investorImage.setVisible(true);
		}
	}

	private void updateArrows() {
		leftArrow.setVisible(false);
		rightArrow.setVisible(false);

		if (currentView > 0) {
			leftArrow.setVisible(true);
		}
		if (currentView < (mercenaryList.size() - 1)) {
			rightArrow.setVisible(true);
		}
	}

	@FXML
	public final void buy() {
		if (person.getShip().getCrewCount() < person.getShip()
				.getCrewCapacity()) {
			person.getShip().addMercenary(mercenaryList.get(currentView));
			market.getMercenaries().remove(currentView);
			person.myMoney = person.myMoney - price;
			person.setSkills(skills);
			Main.setScene("Game.fxml");
		}
	}

	@FXML
	public final void moveRight() {
		currentView++;
		setSkillsAndName(currentView);
		updateArrows();
	}

	@FXML
	public final void moveLeft() {
		currentView--;
		setSkillsAndName(currentView);
		updateArrows();
	}

	@FXML
	public final void goToMarketPlace() {
		Main.setScene("../view/MarketPlace.fxml");
	}

	@FXML
	public final void returnToMainScreen() {
		Main.setScene("../view/Game.fxml");
	}

	@FXML
	public final void save() {
		savedGames saveNewGame = new savedGames();
		saveNewGame.writeToFile();
		Main.setScene("welcomeScreen.fxml");
	}

}
