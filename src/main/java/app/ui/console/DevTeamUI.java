package app.ui.console;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{

    public DevTeamUI()
    {

    }
    public void run()
    {
        System.out.println("\n");
        System.out.printf("Development Team:\n");
        System.out.printf("\t Carolina Barbosa - 1211638@isep.ipp.pt \n");
        System.out.printf("\t Diogo Napoles - 1211155@isep.ipp.pt \n");
        System.out.printf("\t Gustavo Caiano - 1210983@isep.ipp.pt \n");
        System.out.printf("\t Joao Teixeira - 1210957@isep.ipp.pt \n");
        System.out.println("\n");
    }
}
