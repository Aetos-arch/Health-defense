package Tower_Defense.Controleur;

import Tower_Defense.Exception.MoneyException;
import Tower_Defense.Exception.NomTropLongException;
import Tower_Defense.Exception.PasDeNomException;
import Tower_Defense.Exception.PlacementException;
import Tower_Defense.Modele.Partie;
import Tower_Defense.Modele.Tourelle.TourelleFiole;
import Tower_Defense.Modele.Tourelle.TourelleSeringue;
import Tower_Defense.Modele.Tourelle.TourelleVaccin;
import Tower_Defense.Modele.Tourelle.TourelleVitamine;
import Tower_Defense.Vue.VueMap;
import Tower_Defense.Vue.VuePers;
import Tower_Defense.Vue.VueTourelle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    @FXML
    private TilePane tilePaneMap;
    @FXML
    private Pane paneEntite;
    @FXML
    private Label labelPV;
    @FXML
    private Label labelVague;
    @FXML
    private Label labelScore;
    @FXML
    private Label labelMoney;
    @FXML
    private Label labelInfo;
    @FXML
    private Text legendeText;
    @FXML
    private Label legendeNom;
    @FXML
    private VBox boxPersonnages;
    @FXML
    private VBox boxStatuts;
    @FXML
    private Button boutonRegles;
    @FXML
    private Text textRegleEtScore;
    @FXML
    private Button boutonScores;
    @FXML
    private Text textScores;
    @FXML
    private VBox blocInfo;
    @FXML
    private Label gameOver;
    @FXML
    private Button boutonVagueSuivante;
    @FXML
    private Label textSaisirNom;
    @FXML
    private TextField saisirNom;

    private Partie partie;
    private VueMap vM;
    private VuePers vP;
    private VueTourelle vT;
    private Timeline gameLoop;

    public IntegerProperty nbTour;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.partie = new Partie();
        vM = new VueMap(partie.getEnv().getMap(), tilePaneMap);
        this.partie.getEnv().getTirs().addListener(new ListenerTirs(paneEntite));
        this.partie.getEnv().getTours().addListener(new ListenerTourelles(paneEntite));
        this.partie.getEnv().getPersos().addListener(new ListenerPers(paneEntite, this));
        initGame();
        this.nbTour = new SimpleIntegerProperty(0);
        this.labelMoney.textProperty().bind(this.partie.moneyProperty().asString());
        this.labelScore.textProperty().bind(this.partie.scoreProperty().asString());
        this.labelVague.textProperty().bind(this.partie.vagueProperty().asString());
        this.labelPV.textProperty().bind(this.partie.pvProperty().asString());
    }

    private void initGame() {
		gameLoop = new Timeline();
		MediaPlayer mp = new MediaPlayer(new Media(new File("src/Sources/gameOverSound.mp3").toURI().toString()));
        mp.setVolume(1);
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(Duration.seconds(0.04), (ev -> {

			if (this.partie.estPerdu()) {
				mp.seek(Duration.ZERO);
				mp.play();
				this.partie.ajouterScore();
				this.gameOver.setVisible(true);
				this.boutonVagueSuivante.textProperty().setValue("Recommencer");
				gameLoop.stop();
			} else if (this.partie.niveauFini()) {
				gameLoop.stop();
			} else {
				this.partie.unTour();
				this.nbTour.set(this.nbTour.getValue() + 1);
			}
        }));
        gameLoop.getKeyFrames().add(kf);
    }
    
    @FXML
    void onDragDetected(MouseEvent event) {
    	ImageView imageview = (ImageView) event.getSource();
        Dragboard db = imageview.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        Image image = new Image("Sources/Tourelles/" + imageview.getId() + "Dragged.png");
        db.setDragView(image,8,8);
        cb.putString(imageview.getId());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    void onDragOver(DragEvent event) {
        if (event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    
    @FXML
    void onDragDropped(DragEvent event) {
    	if(event.getX() != 800 && event.getY() != 480) {
    		try {
    			switch (event.getDragboard().getString()) {
    					case "tourelleVitamine":
    					this.partie.ajouterTour(new TourelleVitamine((int) Math.floor(event.getX() / 16) * 16, (int) Math.floor(event.getY() / 16) * 16, partie.getEnv()));
			        	  break;

			          case "tourelleSeringue":
			        	  this.partie.ajouterTour(new TourelleSeringue((int) Math.floor(event.getX() / 16) * 16, (int) Math.floor(event.getY() / 16) * 16, partie.getEnv()));
			        	  break;
			            
			          case "tourelleVaccin":
			        	  this.partie.ajouterTour(new TourelleVaccin((int) Math.floor(event.getX() / 16) * 16, (int) Math.floor(event.getY() / 16) * 16, partie.getEnv()));
			        	  break;
			        	  
			          case "tourelleFiole":
			        	  this.partie.ajouterTour(new TourelleFiole((int) Math.floor(event.getX() / 16) * 16, (int) Math.floor(event.getY() / 16) * 16, partie.getEnv()));
			        	  break;
			        
			          default:
			        	  break;
		        }
    		}
    		catch (MoneyException e) {
    			this.legendeNom.textProperty().setValue("Avertissement");
    			this.legendeText.textProperty().setValue("Vous n'avez pas assez d'argent pour acheter cette tourelle.");
    		}
    		catch (PlacementException e) {
    			this.legendeNom.textProperty().setValue("Avertissement");
    			this.legendeText.textProperty().setValue("Le placement est impossible sur d'autres tourelles, sur les batiments, sur la route et sur la première colonne.");
    		}
    	}
    }
    
    @FXML
    void onMouseClicked(MouseEvent event) {
    	ImageView imageview = (ImageView) event.getTarget();
    	switch (imageview.getId()) {
    	
    	// Légende personnages
    	
		case "infecteSansSymptome":
			this.legendeNom.textProperty().setValue("Infecté sans symptôme");
			this.legendeText.textProperty().setValue("Contamination : faible\n"
					+ "Vitesse : moyenne");
			break;

		case "infecteJogger":
			this.legendeNom.textProperty().setValue("Infecté jogger");
			this.legendeText.textProperty().setValue("Contamination : moyenne\n"
					+ "Vitesse : moyenne\n"
					+ "Il accélère quand on lui tire dessus.");
			break;
			
		case "infecteGrave":
			this.legendeNom.textProperty().setValue("Infecté grave");
			this.legendeText.textProperty().setValue("Contamination : élevée\n"
					+ "Vitesse : lente\n"
					+ "Force l’attaque des tours sur lui.");
			break;
			
		case "infecteQuiTousse":
			this.legendeNom.textProperty().setValue("Infecté qui tousse");
			this.legendeText.textProperty().setValue("Contamination : moyenne\n"
					+ "Vitesse : moyenne\n"
					+ "Il empêche les tirs des tourelles sur les infectés à proximité de lui quand on lui tire dessus.");
			break;
			
		case "personnageSain":
			this.legendeNom.textProperty().setValue("Personnage sain");
			this.legendeText.textProperty().setValue("Personnage soigné.");
			break;
			
		// Légende statuts
			
		case "infecteHot":
			this.legendeNom.textProperty().setValue("Soin sur la durée");
			this.legendeText.textProperty().setValue("L'infecté prend du soin chaque tour.");
			break;
			
		case "infecteProtection":
			this.legendeNom.textProperty().setValue("Protection");
			this.legendeText.textProperty().setValue("L'infecté est protégé des tirs.");
			break;
			
		default:
			break;
		}
    }
    
    @FXML
    void info(ActionEvent event) {
    	Button bouton = (Button) event.getSource();
    	switch (bouton.getId()) {
		case "infoVitamine":
			this.legendeNom.textProperty().setValue("Tourelle vitamine");
			this.legendeText.textProperty().setValue("Type de tir : Mitraillette\n"
					+ "Soin : peu\n"
					+ "Cadence de tir : forte\n"
					+ "Portée : courte");
			break;
			
		case "infoSeringue":
			this.legendeNom.textProperty().setValue("Tourelle seringue");
			this.legendeText.textProperty().setValue("Type de tir : Coup par coup\n"
					+ "Soin : important\n"
					+ "Cadence de tir : moyenne\n"
					+ "Portée : moyenne\n"
					+ "Ralenti les ennemis proches.");
			break;
			
		case "infoVaccin":
			this.legendeNom.textProperty().setValue("Tourelle vaccin");
			this.legendeText.textProperty().setValue("Type de tir : Sniper\n"
					+ "Soin : sur la durée\n"
					+ "Cadence de tir : faible\n"
					+ "Portée : longue");
			break;
			
		case "infoFiole":
			this.legendeNom.textProperty().setValue("Tourelle fiole");
			this.legendeText.textProperty().setValue("Type de tir : Dégât de zone\n"
					+ "Soin : moyen\n"
					+ "Cadence de tir : faible\n"
					+ "Portée : très longue");
			break;

		default:
			break;
		}
    }

    @FXML
    void vagueSuivante(ActionEvent event) {
    	try {
	    	if(this.boutonVagueSuivante.getText().equals("Recommencer")) {
	    		this.textSaisirNom.setVisible(true);
	    		this.saisirNom.setVisible(true);
	    		this.partie.nouvellePartie();
	    		this.nbTour.setValue(0);
	    		this.gameOver.setVisible(false);
	    		this.boutonVagueSuivante.setText("Vague suivante");
	    	}
	    	else if(this.boutonVagueSuivante.getText().equals("Vague suivante")){
	    		if(this.saisirNom.getText().isEmpty()) throw new PasDeNomException();
	    		if(this.saisirNom.getText().length() > 10) throw new NomTropLongException();
	    		this.partie.setNomJoueur(this.saisirNom.getText());
	    		this.textSaisirNom.setVisible(false);
	    		this.saisirNom.setVisible(false);
		        gameLoop.play();
		        if(this.partie.getVague() == 0)
		        	this.partie.lancerNiveau();
		        if(this.partie.niveauFini())
		        	this.partie.lancerNiveau();
	    	}
    	} catch (PasDeNomException e) {
    		this.legendeNom.textProperty().setValue("Avertissement");
			this.legendeText.textProperty().setValue("Vous n'avez pas saisie de nom.");
    	} catch (NomTropLongException e) {
    		this.legendeNom.textProperty().setValue("Avertissement");
			this.legendeText.textProperty().setValue("Vous avez saisie un nom trop long.\n(<= 10 caractères)");
		}
    }
    
    @FXML
    void regles(ActionEvent event) {
    	if(this.boutonRegles.getText().equals("Règles")) {
    		this.boxPersonnages.setVisible(false);
        	this.boxStatuts.setVisible(false);
        	this.blocInfo.setVisible(false);
        	this.boutonScores.setVisible(false);
        	this.boutonRegles.setText("Masquer règles");
        	this.textRegleEtScore.setText("Vous êtes dans un univers moderne apocalyptique où des personnes infectés tentent d'aller dans un bunker de gens sains. "
        			+ "Vous devez les soigner avant qu’ils arrivent au bunker en achetant des tourelles mis à disposition sous le plateau de jeu "
        			+ "avec de l'argent obtenu en soignant les infectés.\nPour acheter une tourelle, il faut cliquer sur l'image de la tourelle et la glisser sur la map. \n"
        			+ "Pour avoir plus d'informations sur les tourelles, les infectés et les statuts. Vous pouvez cliquer sur les boutons \"Info\" sous les tourelles "
        			+ "ou cliquer sur les differents images des infectés et statuts. \n\n"
        			+ "Si vous avez fini de lire les règles, vous pouvez les masquer avec le bouton juste au dessus.\n\n"
        			+ "Bon jeu !");
    	}
    	else if(this.boutonRegles.getText().equals("Masquer règles") || this.boutonRegles.getText().equals("Masquer scores")) {
    		this.boxPersonnages.setVisible(true);
        	this.boxStatuts.setVisible(true);
        	this.blocInfo.setVisible(true);
        	this.boutonScores.setVisible(true);
        	this.boutonRegles.setText("Règles");
        	this.textRegleEtScore.setText("");
    	}
	}
    
    @FXML
    void scores(ActionEvent event) {
    	if(this.boutonScores.getText().equals("Scores")) {
    		this.boxPersonnages.setVisible(false);
        	this.boxStatuts.setVisible(false);
        	this.blocInfo.setVisible(false);
        	this.boutonScores.setVisible(false);
        	if(this.partie.afficheScores().isEmpty())
        		this.textRegleEtScore.setText("Aucun score enregistré.");
        	else
        		this.textRegleEtScore.setText(this.partie.afficheScores());
        	this.boutonRegles.setText("Masquer scores");
    	}
    }

    public int getTour() {
        return this.nbTour.get();
    }

    public Partie getPartie() {
    	return this.partie;
    }
}