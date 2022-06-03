package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;

public class ImportLegacySystemDataController {
    private App app;
    private Company company;



    public ImportLegacySystemDataController(){
        this.app = App.getInstance();
        this.company = app.getCompany();
    }
}
