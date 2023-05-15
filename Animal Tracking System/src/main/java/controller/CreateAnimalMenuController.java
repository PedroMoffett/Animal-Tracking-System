package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DataProvider;
import model.Dog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateAnimalMenuController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private RadioButton VaccNoRBtn;

    @FXML
    private TextField animalidTxt;

    @FXML
    private TextField behaviorTxt;

    @FXML
    private TextField breedTxt;

    @FXML
    private TextField lifespanTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private RadioButton vaccYesrBtn;


    @FXML
    void onActionSaveAnimal(ActionEvent event) throws IOException {

        try{
            int id = Integer.parseInt(animalidTxt.getText());
            String breed = breedTxt.getText();
            int lifespan = Integer.parseInt(lifespanTxt.getText());
            String behavior = behaviorTxt.getText();
            double price = Double.parseDouble(priceTxt.getText());
            boolean isVaccinated;
            String special = null;

            if(vaccYesrBtn.isSelected())
                isVaccinated = true;
            else
                isVaccinated = false;

            DataProvider.addAnimal(new Dog(id, breed, lifespan, behavior, price, isVaccinated, special));

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        }
            catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setContentText("Please enter a valid value for each text field.");
                alert.showAndWait();
            }




    }

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}