module main.ims {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens main.ims to javafx.fxml;
    exports main.ims;
    exports controller;
    opens controller to javafx.fxml;
}