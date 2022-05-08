package app.ui;

import app.ui.console.MainMenuUI;

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
    public static void main(String[] args)
    {
        try
        {
            MainMenuUI menu = new MainMenuUI();

            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
