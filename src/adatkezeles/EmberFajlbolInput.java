/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Ember;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.DefaultListModel;



public class EmberFajlbolInput implements AdatInput <Ember> {
    
    private URI fajlUtvonal;
    private String CHAR_SET = "UTF-8";
    
    

    public EmberFajlbolInput(URI fajlUtvonal) {
        this.fajlUtvonal = fajlUtvonal;
    }

    @Override
    public List<Ember> adatLista() throws Exception {
        
        List<Ember> emberek = new ArrayList<>();
        
        try(
            Scanner fajlScanner = new Scanner(new File(fajlUtvonal));
            ){
            /*
            Békési Judit;187354SE
            */
            
            String adatok[];
            Ember ember = null;
            
            while(fajlScanner.hasNextLine()){
                adatok = fajlScanner.nextLine().split(";");
                if(adatok.length == 2){
                    ember = new Ember(adatok[0], adatok[1]);
                } else {
                    ember = null;
                }
                
                if(ember != null){
                emberek.add(ember);
                }
            }
            
            
        } 
        
        return emberek;
        
    }

    @Override
    public DefaultListModel<Ember> adatModel() throws Exception {
        DefaultListModel<Ember> emberModel = new DefaultListModel<>();
        
        for(Ember ember : adatLista()){
            emberModel.addElement(ember);
        }
        
        return emberModel;
    }
}
