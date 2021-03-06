/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

/**
 * Comparable<Kutyu> -t hozzáadni!
 * @author djani
 */
public class Mobiltelefon implements Kutyu {

    public static double billentyuEro;

    private String tipus;
    private int sorszam;
    private int kuldottUzenetekMerete;
    private static int sorszam_szamlalo = 0;

    public Mobiltelefon(String tipus) {
        this.tipus = tipus;
        this.sorszam = sorszam_szamlalo;
        sorszam_szamlalo++;
    }

    @Override
    public void uzenetetKuld(int uzenetHossza) {
        kuldottUzenetekMerete += uzenetHossza;
    }

    public int getSorszam() {
        return sorszam;
    }

    public String getTipus() {
        return tipus;
    }

    public int getKuldottUzenetekMerete() {
        return kuldottUzenetekMerete;
    }

    @Override
    public int huvelykujjSejtek() {
        return (int) (kuldottUzenetekMerete * billentyuEro);
    }

    @Override
    public String toString() {
        return this.getSorszam() + ". " + tipus;
    }

    @Override
    public Kutyu masolat() {
        return new Mobiltelefon(this.getTipus());
    }

}
