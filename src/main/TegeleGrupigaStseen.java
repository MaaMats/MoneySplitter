package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import loogika.Liige;

public class TegeleGrupigaStseen {

    private BorderPane layout1;
    private static ComboBox<Liige> liikmeDropDown;
    public static int selectedLiige;


    public TegeleGrupigaStseen() {

        // layoutide loomine
        layout1 = new BorderPane();
        VBox layout2 = new VBox();
        VBox layout3 = new VBox();
        VBox layout4 = new VBox();

        //info text
        Label infoText = new Label("vali grupp ja vali liige, et lisada oste.");

        //loon comboboxi
        liikmeDropDown = new ComboBox<>();
        liikmeDropDown.setMinWidth(100);

        //lisan tulbad tabelile
        TableColumn ostuNimi = new TableColumn("Ostu nimi");
        ostuNimi.setMaxWidth(50);
        // ostuNimi.setCellValueFactory(new PropertyValueFactory<Liige, String>("Ostu nimi"));

        TableColumn hind = new TableColumn("Hind");
        hind.setMaxWidth(50);
        // hind.setCellValueFactory(new PropertyValueFactory<Liige, Double>("hind"));
        TableView tabel = new TableView();
        tabel.getColumns().addAll(ostuNimi, hind);

        //loon nupud ja lisan funktsionaalsuse
        Button nupp1 = new Button("LISA OST");
        nupp1.setOnAction(event -> {
            selectedLiige = liikmeDropDown.getVisibleRowCount();
            LisaOstBox.lisaOstBox();
        });
        Button nupp2 = new Button("Jaga raha");

        //loon lõppliku layouti
        layout1.setTop(Main.menyyObj.getMenuBar());
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().add(liikmeDropDown);
        layout1.setRight(layout2);
        layout3.setAlignment(Pos.CENTER);
        layout3.getChildren().add(tabel);
        layout1.setLeft(layout3);
        layout4.setAlignment(Pos.CENTER);
        layout4.getChildren().addAll(nupp1, nupp2);
        layout1.setCenter(layout4);


    }

    public static void refreshComboBoxTegeleLiige() {
        ObservableList<Liige> chBoxRefh = FXCollections.observableArrayList(Main.getAndmeBaas().gruppideList.get(Main.getSelectedGrupp()).grupiLiikmed);
        liikmeDropDown.setItems(chBoxRefh);
    }

    public BorderPane getLayout1() {
        return layout1;
    }

}
