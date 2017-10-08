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
    
    private String nev;
    private String szemSzam;
    private List<Kutyu> kutyuk = new ArrayList<>();
    
    public void kutyutVesz(Kutyu kutyu){
        if(!kutyuk.contains(kutyu)){
            this.kutyuk.add(kutyu);
        }
    }

    public Ember(String nev, String szemSzam) {
        this.nev = nev;
        this.szemSzam = szemSzam;
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
        
        eredmeny += (this.huvelykujjEro() < sejtHatar) ? "normális" : "kóros hüvelykujjhasználat" ;
        eredmeny += "\n";
        eredmeny += (this.netIdo()< fuggosegiHatar) ? "normális" : "kóros netfüggő" ;
        
        return eredmeny;
    }

    @Override
    public String toString() {
        return nev + " (" + szemSzam + ')';
    }
    
    
    
    
}
