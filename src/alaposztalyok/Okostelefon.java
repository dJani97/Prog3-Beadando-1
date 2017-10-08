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
public class Okostelefon extends Mobiltelefon{
    
    private String operaciosRendszer;
    private boolean vanWiFi;
    private int netezesselToltottIdo;

    public int getNetezesselToltottIdo() {
        return netezesselToltottIdo;
    }

    public Okostelefon(String tipus, String operaciosRendszer) {
        super(tipus);
        this.operaciosRendszer = operaciosRendszer;
    }
    
    public void kapcsolodik(){
        vanWiFi = true;
    }
    
    public void lekapcsolodik(){
        vanWiFi = false;
    }
    
    public void internetezik(int ido){
        if(vanWiFi){
            netezesselToltottIdo += ido;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "; " + this.getOperaciosRendszer();
    }

    @Override
    public Kutyu masolat() {
        return new Okostelefon(this.getTipus(), this.getOperaciosRendszer());
    }

    public String getOperaciosRendszer() {
        return operaciosRendszer;
    }
    
}
