package app.ui;

import app.domain.model.Stats;
import app.ui.console.MainMenuUI;
import javafx.fxml.JavaFXBuilderFactory;

/**
 * The type Main.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
//Teste
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args){
        try
        {
            MainMenuUI menu = new MainMenuUI();

            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
