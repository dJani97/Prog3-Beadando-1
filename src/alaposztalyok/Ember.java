/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djani
 */
public class Ember {
    
    public static int sejtHatar;
    public static int fuggosegiHatar;
    public static enum KiegeszitoAdat {SZEMELYI_SZAM, HUVELYKUJJ_ERO}
    
    private static KiegeszitoAdat kiegeszitoAdat = KiegeszitoAdat.SZEMELYI_SZAM;
    private String nev;
    private String szemSzam;
    private List<Kutyu> kutyuk = new ArrayList<>();


    public Ember(String nev, String szemSzam) {
        this.nev = nev;
        this.szemSzam = szemSzam;
    }
    
    public void kutyutVesz(Kutyu kutyu){
        if(!kutyuk.contains(kutyu)){
            this.kutyuk.add(kutyu);
        }
    }
    
    public int huvelykujjEro(){
        int osszeg = 0;
        for(Kutyu kutyu : kutyuk){
            osszeg += kutyu.huvelykujjSejtek();
        }
        return osszeg;
    }
    
    public int netIdo(){
        int osszeg = 0;
        for(Kutyu kutyu : kutyuk){
            if(kutyu instanceof Okostelefon){
                osszeg += ((Okostelefon) kutyu).getNetezesselToltottIdo();
            }
        }
        return osszeg;
    }
    
    public String diagnozis(){
        String eredmeny = "";
        
        eredmeny += (this.huvelykujjEro() < sejtHatar) ? "normális, " : "kóros hüvelykujjhasználat, " ;
        eredmeny += "\n";
        eredmeny += (this.netIdo()< fuggosegiHatar) ? "normális" : "kóros netfüggő" ;
        
        return eredmeny;
    }

    public List<Kutyu> getKutyuk() {
        return new ArrayList<>(kutyuk);
    }

    public String getSzemSzam() {
        return szemSzam;
    }

    public static void setKiegeszitoAdat(KiegeszitoAdat kiegeszitoAdat) {
        Ember.kiegeszitoAdat = kiegeszitoAdat;
    }

    @Override
    public String toString() {
        switch(kiegeszitoAdat){
            case HUVELYKUJJ_ERO:
                return nev + "; hüvelykerő: " + huvelykujjEro();
                
            case SZEMELYI_SZAM:
                return nev + " (" + getSzemSzam() + ')';
                
            default:
                return nev;
        }
    }
    
    
    
    
}
