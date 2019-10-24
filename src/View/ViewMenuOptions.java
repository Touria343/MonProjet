package View;


import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewMenuOptions {

    private Text titre;
    private Menu model;
    private ImageView imgBg;
    private Group root;
    private ArrayList<ImageView> tabImage;
    private ImageView monLezard;
    private int currentIndice;
    private ImageView spider;
    private int i =1;
    private MediaPlayer videoBackground;
    private MediaView media;
    private Stage stage;
    private MediaView viewer;
    private ImageView stats;
    private ImageView bandeTop;
    private ImageView bandeFond;
    private ImageView chevron;
    private ImageView bandeBottom;
    private ImageView chevrondroit;


    /**
     * Constructeur du menu principal
     *
     * @param model (Modèle correspondant au menu)
     * @param root  (Groupe principal de la vue)
     */
    ViewMenuOptions(Menu model, Group root) {
        this.root = root;
        this.model = model;

        //  initListeImage();


        initBackground();
        initBandeTop();
        initBandeBottom();
        initChevron();
        initChevronDroit();
      //  initBandeFond();
        initStats();
        initVaisseauxCoin();

        setVueCompleteMenu();

    }

   /* private void initListeImage() {
        tabImage = new ArrayList<>();
        tabImage.add(new ImageView(Path.lezardBlue1));
        tabImage.add(new ImageView(Path.lezardBlue2));
        tabImage.add(new ImageView(Path.lezardBlue3));
        tabImage.add(new ImageView(Path.lezardBlue4));
        monLezard = tabImage.get(0);
        monLezard.setX(500);
        monLezard.setY(500);
        monLezard.setScaleX(0.2);
        monLezard.setScaleY(0.2);
    }*/

    private void initVaisseauxCoin() {

        spider = new ImageView(Path.vaisseauxCoin);

        spider.setX(600);
        spider.setY(200);
        spider.setFitHeight(750);
        spider.setFitWidth(850);

        spider.setPreserveRatio(false);

    }


    private void initChevron() {

        chevron = new ImageView(Path.chevrongauche);

       chevron.setX(520);
        chevron.setY(755);
        chevron.setFitHeight(80);
        chevron.setFitWidth(80);

        chevron.setPreserveRatio(false);

    }

    private void initChevronDroit() {

        chevrondroit = new ImageView(Path.chevrondroit);

        chevrondroit.setX(850);
        chevrondroit.setY(745);
        chevrondroit.setFitHeight(80);
        chevrondroit.setFitWidth(80);

        chevrondroit.setPreserveRatio(false);

    }




    private void initBandeTop() {

        bandeTop = new ImageView(Path.bandeTop);

        bandeTop.setX(-300);
        bandeTop.setY(0);
        bandeTop.setFitWidth(1500);

        bandeTop.setPreserveRatio(true);

    }
    private void initBandeBottom() {

        bandeBottom = new ImageView(Path.bandeBottom);

        bandeBottom.setX(500);
        bandeBottom.setY(900);
        bandeBottom.setFitWidth(1500);

        bandeBottom.setPreserveRatio(true);

    }

    private void initBandeFond() {

        bandeFond = new ImageView(Path.bandefond);

        bandeFond.setX(0);
        bandeFond.setY(-300);
        bandeFond.setFitWidth(1500);

        bandeFond.setPreserveRatio(true);

    }

    private void initStats() {

        stats = new ImageView(Path.stats1);

        stats.setX(80);
        stats.setY(430);
        stats.setFitWidth(800);

        stats.setPreserveRatio(true);

    }





    private void initTitre() {
        titre = new Text(10, 220, "La guerre des lezards");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 80);
        titre.setFont(policeTitre);
        titre.setRotate(-20);
    }


    /**
     * Mise en place de l'image de fond en fonction de la taille de l'écran de l'utilisateur
     */

    private void initBackground() {
        //imgBg = new ImageView("Asset/Images/fond_menu.jpg");
        //  Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        // imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        // imgBg.setFitWidth((int) primaryScreenBounds.getWidth());

     /*   videoBackground = new MediaPlayer(new Media(this.getClass().getResource(Path.videobackground1).toExternalForm()));

        videoBackground.setAutoPlay(true);

        media.setMediaPlayer(videoBackground);

       media.setFitHeight((int) primaryScreenBounds.getHeight());
        media.setFitWidth((int) primaryScreenBounds.getWidth());
*/
        videoBackground = new MediaPlayer(new Media(this.getClass().getResource(Path.videobackground2).toExternalForm()));

        videoBackground.setAutoPlay(true);
        videoBackground.setCycleCount(MediaPlayer.INDEFINITE);
        viewer = new MediaView(videoBackground);

        videoBackground.play();

        //change width and height to fit video
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();

        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(false);

      /*  if (viewer.isPreserveRatio()) {
            if (getHeight() > getWidth()) {
                viewer.setFitWidth(getWidth());
                imageView.setFitHeight(0);
            } else {
                imageView.setFitWidth(0);
                imageView.setFitHeight(getHeight());
            }
        } else {
            imageView.setFitWidth(getWidth());
            imageView.setFitHeight(getHeight());
        }
*/




    }

    /**
     * Ajoute a la vue tous les éléments composant le menu
     */
    void setVueCompleteMenu() {
        root.getChildren().clear();
        // root.getChildren().add(imgBg);
        //   root.getChildren().add(media);
        root.getChildren().add(viewer);


        // root.getChildren().add(titre);
        //  root.getChildren().add(monLezard);
      //  root.getChildren().add(bandeFond);


        root.getChildren().add(stats);
        root.getChildren().add(chevron);
        root.getChildren().add(chevrondroit);


        root.getChildren().add(bandeTop);
        root.getChildren().add(bandeBottom);

        root.getChildren().add(spider);

    }

    void setEvents(ControllerMenu mc) {
        //  titre.setOnMouseEntered(mc);
        //  monLezard.setOnMouseClicked(mc);
        // spider.setOnMouseEntered(mc);


    }

    public Text getTitre() {
        return titre;
    }

    public void setRandomColorForTitle() {
        titre.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));

    }
    
}
