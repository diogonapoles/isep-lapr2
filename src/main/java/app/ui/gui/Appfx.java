package app.ui.gui;

import app.domain.model.Stats;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Appfx.
 */
public class Appfx extends Application {
    private Stage stage;
    private Appfx mainAppfx;
    private final double MINIMUM_WINDOW_WIDTH = 600.0;
    private final double MINIMUM_WINDOW_HEIGHT = 300.0;
    private final double SCENE_WIDTH = 450.0;
    private final double SCENE_HEIGHT = 350.0;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
        public void start(Stage stage) throws Exception {
            Stats stats = new Stats();
            stats.start();
            this.stage = stage ;
            stage.setTitle("LAPR2APP");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            stage.setResizable(false);
            //Image img = new Image("img.png");
            // stage.getIcons().add(img);
       /* try {
            //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
            var loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);

        }catch (Exception ex) {
            ex.printStackTrace();
        } */
        MainUI mainUI = new MainUI();
        mainUI.setMainApp(this);
           toMainScene();
            this.stage.show();




        }


    /**
     * To main scene.
     */
    public void toMainScene() {
        try {
            MainUI ui = (MainUI) replaceSceneContent("/fxml/Main.fxml");
            ui.setMainApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Appfx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets main app.
     *
     * @param mainAppfx the main appfx
     */
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }

    /**
     * Gets stage.
     *
     * @return the stage
     */
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Replace scene content initializable.
     *
     * @param fxml the fxml
     * @return the initializable
     * @throws Exception the exception
     */
    public Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Appfx.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Appfx.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page);
        scene.getStylesheets().add("/styles/Styles.css");
        this.stage.setScene(scene);
       this.stage.sizeToScene();
        return (Initializable) loader.getController();
    }


}
