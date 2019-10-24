package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import java.nio.file.Paths;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;

import static javafx.scene.text.FontWeight.*;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal mp;
    private ViewMenuOptions mo;
    private Menu model;
    private ControllerMenu controllerMenu;
    private String Dir = System.getProperty("user.dir");
    private MediaPlayer videoBackground;
    private Button btn;
    private Button btn2,btn3,btn4;
    private Scene scene, scene2;
    private Text t;
    private ImageView img1;
    private Stage stage;
    private MediaPlayer music;
    private MediaView viewer;




    /**
     * Permet le lancement de l'application : méthode obligatoire pour JavaFX
     *
     * @param primaryStage ()
     * @throws Exception ()
     */



    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        // root représente le panel qui va être affiché : tout ce qui doit être affiché doit lui être ajouté
        Group root = new Group();
        Scene menuDemarrage = new Scene(root, Color.BLACK);

        model = new Menu();

        mp = new ViewMenuPrincipal(model, root);
        controllerMenu = new ControllerMenu(this, model);




        // Affichage du menu


       // File f = new File(Dir, "..//Asset//Video//TypoYellow_27791.mp4)");


        //Converts media to string URL
       /* Media media = new Media(f.toURI().toURL().toString());
        javafx.scene.media.MediaPlayer player = new   javafx.scene.media.MediaPlayer(media);
        MediaView viewer = new MediaView(player);*/




            Group root2 = new Group();

            Scene scene2 = new Scene(root2, Color.WHITE);

        Menu model = new Menu();

        mo = new ViewMenuOptions(model, root2);

            Text jouer = new Text(300, 850, "- Jouer -");
            jouer.setFont(Font.font("Dead Kansas", 35));
            jouer.setFill (Color.WHITE);

        Text choixVaiss = new Text(554, 850, "- Choix des vaisseaux  -");
        choixVaiss.setFont(Font.font("Dead Kansas", 35));
        choixVaiss.setFill (Color.WHITE);

        Text quitter = new Text(1000, 850, "- Quitter  -");
        quitter.setFont(Font.font("Dead Kansas", 35));
        quitter.setFill (Color.WHITE);

        Text geoCroiseur = new Text(50, 180, "- G  é  o  -  c  r  o  i  s  e  u  r \n      G  é  n  é  s  i  s   T-16 -");
        geoCroiseur.setFont(Font.font("Dead Kansas", EXTRA_BOLD, 60));
        geoCroiseur.setFill (Color.WHITE);

        Text joueur1 = new Text(630, 800, "- Joueur - 1");
        joueur1.setFont(Font.font("Dead Kansas", SEMI_BOLD, 37));
        joueur1.setFill (Color.DARKRED);


        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.2f, 0.2f, 0.2f));

        Reflection r = new Reflection();
        r.setFraction(0.7f);

        geoCroiseur.setEffect(r);


        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        joueur1.setEffect(r);

        music = new MediaPlayer(new Media(this.getClass().getResource(Path.son).toExternalForm()));

        music.setAutoPlay(true);
        viewer = new MediaView(music);


        music.play();


      //  geoCroiseur.setEffect(ds);

      //  geoCroiseur.setEffect(is);



            btn = initButton(100, 80, "- Entrer -");
            btn2 = initButton(200, 120, "- Jouer -");
            btn3 = initButton(200, 170, "- Choix des vaisseaux -");


            btn3.setOnAction(event -> {

                primaryStage.setScene(scene2);
                primaryStage.setFullScreen(true);

            });

choixVaiss.setOnMousePressed(mouseEvent -> {

    primaryStage.setScene(scene2);
    primaryStage.setFullScreen(true);



});



            // composition des scènes
            
           // root2.getChildren().addAll(img1);
            root.getChildren().add(jouer);
            root.getChildren().add(choixVaiss);
            root.getChildren().add(quitter);

            root2.getChildren().add(geoCroiseur);
            root2.getChildren().add(joueur1);



        //root2.getChildren().add(t);

            // gestion de l'affichage au lancement
            primaryStage.setScene(menuDemarrage);

            primaryStage.show();


        primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(menuDemarrage);
        primaryStage.setResizable(true);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();


        }

        private Button initButton(int longeur, int largeur, String texteDuBouton) {

            // Création d'un bouton
            Button b = new Button();
            b.setLayoutX(longeur);
            b.setLayoutY(largeur);
            b.setText(texteDuBouton);
            return b;







        //set the Scene
       // Scene scenes = new Scene(root2, 500, 500, Color.BLACK);



    }

    public void setEventHandlerMenu(ControllerMenu cm) {
        mp.setEvents(cm);
    }

    // GETTERS AND SETTERS
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewMenuPrincipal getMp() {
        return mp;
    }
}