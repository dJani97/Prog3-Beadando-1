/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

/**
 *
 * @author djani
 */
public class Okostelefon extends Mobiltelefon {

    public static double max_internet_ido;

    private String operaciosRendszer;
    private boolean WiFiElerheto;
    private int netezesselToltottIdo;

    public Okostelefon(String tipus, String operaciosRendszer) {
        super(tipus);
        this.operaciosRendszer = operaciosRendszer;
    }

    public void kapcsolodik() {
        WiFiElerheto = true;
    }

    public void lekapcsolodik() {
        WiFiElerheto = false;
    }

    public void internetezik(int ido) {
        if (WiFiElerheto) {
            netezesselToltottIdo += ido;
        }
    }

    public boolean isWiFiElerheto() {
        return WiFiElerheto;
    }

    public String getOperaciosRendszer() {
        return operaciosRendszer;
    }

    public int getNetezesselToltottIdo() {
        return netezesselToltottIdo;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + this.getOperaciosRendszer();
    }

    @Override
    public Kutyu masolat() {
        return new Okostelefon(this.getTipus(), this.getOperaciosRendszer());
    }
}
