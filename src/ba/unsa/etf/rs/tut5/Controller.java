package ba.unsa.etf.rs.tut5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField imeField;
    public TextField emailField;
    public TextField korisnickoField;
    public TextField prezimeField;
    public PasswordField lozinkaField;
    public Button btnAdd;
    public Button btnEnd;
    public ListView<Korisnik> listKorisnik;
    private KorisniciModel model;

    public Controller(KorisniciModel model) {
        this.model = model;
    }

    public void btnAddAction(ActionEvent actionEvent) {
    }

    public void btnEndAction(ActionEvent actionEvent) {
        Stage myStage = (Stage)btnEnd.getScene().getWindow();
        myStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        bind();
        listKorisnik.setItems(model.getKorisnici());
        listKorisnik.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observable, Korisnik oldValue, Korisnik newValue) {

            }
        });
    }

    private void unbind() {
        imeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korisnickoField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().usernameProperty());
        lozinkaField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }

    private void bind() {
        imeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailField.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korisnickoField.textProperty().bindBidirectional(model.getTrenutniKorisnik().usernameProperty());
        lozinkaField.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }
}
