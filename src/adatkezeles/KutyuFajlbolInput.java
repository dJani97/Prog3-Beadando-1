/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Kutyu;
import alaposztalyok.Mobiltelefon;
import alaposztalyok.Okostelefon;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class KutyuFajlbolInput implements AdatInput<Kutyu> {

    private URI fajlUtvonal;
    private String CHAR_SET = "UTF-8";

    public KutyuFajlbolInput(URI fajlUtvonal) {
        this.fajlUtvonal = fajlUtvonal;
    }

    @Override
    public List<Kutyu> adatLista() throws Exception {

        List<Kutyu> kutyuk = new ArrayList<>();

        try (
                Scanner fajlScanner = new Scanner(new File(fajlUtvonal));) {
            /*
            Nokia Lumia;Windows Phone
            Nokia
             */

            String sor, adatok[];
            Kutyu kutyu = null;

            while (fajlScanner.hasNextLine()) {
                adatok = fajlScanner.nextLine().split(";");
                if (adatok.length == 1) {
                    kutyu = new Mobiltelefon(adatok[0]);
                } else if (adatok.length == 2) {
                    kutyu = new Okostelefon(adatok[0], adatok[1]);
                } else {
                    kutyu = null;
                }

                if (kutyu != null) {
                    kutyuk.add(kutyu);
                }
            }
        }

        return kutyuk;

    }

    @Override
    public DefaultComboBoxModel<Kutyu> adatModel() throws Exception {

        DefaultComboBoxModel<Kutyu> kutyuModel = new DefaultComboBoxModel<>();

        for (Kutyu kutyu : adatLista()) {
            kutyuModel.addElement(kutyu);
        }

        return kutyuModel;
    }
}
