package main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class Menyy {

    private static MenuBar topMenu;
    private static Menu fileMenu;
    private Menu looMenu;
    private Menu kustutaMenu;

    public Menyy() {
        // menu loomine jne.
        fileMenu = new Menu("_File");
        looMenu = new Menu("Lisa/Loo");
        kustutaMenu = new Menu("Kustuta");


        // fileMenu osad e. peamine menüü "file"
        fileMenu.getItems().addAll(looMenu, kustutaMenu);
        MenuItem j2lgi = new MenuItem("J2lgi kulutusi...");
        MenuItem jaga = new MenuItem("Jaga raha...");
        fileMenu.getItems().addAll(new SeparatorMenuItem(), j2lgi, jaga);

        // looMenu osad e. pea menu sees
        MenuItem lisaLiige = new MenuItem("Lisa uus liige");
        MenuItem looGrupp1 = new MenuItem("Loo uus grupp");
        looMenu.getItems().addAll(lisaLiige, looGrupp1);

        // kustutaMenu osad e. pea menu sees
        MenuItem kustutaGrupp = new MenuItem("Kustuta grupp...");
        MenuItem kustutaLiige = new MenuItem("Kustuta liige...");
        kustutaMenu.getItems().addAll(kustutaGrupp, kustutaLiige);


    }

    public static MenuBar getMenuBar() {
        // main menu bar
        topMenu = new MenuBar();
        topMenu.getMenus().addAll(fileMenu);

        return topMenu;
    }


}