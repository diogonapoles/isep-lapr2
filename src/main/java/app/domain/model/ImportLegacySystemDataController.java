package app.domain.model;

import app.controller.App;

public class ImportLegacySystemDataController {
    private App app;
    private Company company;



    public ImportLegacySystemDataController(){
        this.app = App.getInstance();
        this.company = app.getCompany();
    }
}
