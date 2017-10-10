package teszt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import alaposztalyok.*;
import feluletek.MobilJPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author djani
 */
public class MobilfoniaTeszt01 {
    
    
    // Másoltam mindent a feladat fájlból:
    private final int MAX_TELEFON_DB = 20; // kiválasztáskor max ennyi ember vásárol
    private final int HASZNALAT_SZAM =100; // ennyiszer fut le a használat
    private final int MAX_UZENETHOSSZ = 200;
    private final double SZAZALEK = 0.6; // ekkora eséllyel kapcsolódik az internethez
    private final int MAX_INTERNET_IDO = 200;
    private final double MOBIL_BILLENTYU_ERO = 0.5;
    private final double OKOS_TEL_BILLENTYU_ERO = 0.3;
    private final int FUGGOSEG_HATAR = 1000;
    private final int SEJT_HATAR = 200;
    
    // Globális teszt változók
    
    Mobiltelefon tesztKutyu01;
    Okostelefon tesztKutyu02;
    Ember tesztEmber01;
    
    
    public MobilfoniaTeszt01() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Ember.fuggosegiHatar = FUGGOSEG_HATAR;
        Ember.sejtHatar = SEJT_HATAR;
        Mobiltelefon.billentyuEro = MOBIL_BILLENTYU_ERO;
        Okostelefon.billentyuEro = OKOS_TEL_BILLENTYU_ERO;
        Okostelefon.max_internet_ido = MAX_INTERNET_IDO;
        
        tesztKutyu01 = new Mobiltelefon("Prototípus");
        tesztKutyu02 = new Okostelefon("Okos Prototípus", "Android 8.0");
        
        tesztEmber01 = new Ember("Jani", "010203TEST");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kutyuTeszt() {
        
        // a küldött üzenetek mérete számláló működik
        int uzenet = 20;
        tesztKutyu01.uzenetetKuld(uzenet);
        assertTrue(tesztKutyu01.getKuldottUzenetekMerete() == uzenet);
            
        // a különböző osztályba tartozó telefonok ID-je is egyedi marad
        // nem indul osztályonként újból a számozás
        assertTrue(tesztKutyu01.getSorszam() < tesztKutyu02.getSorszam());
        
        // a másolat nem azonos az eredetivel
        Kutyu masoltKutyu01 = tesztKutyu01.masolat();
        Kutyu masoltKutyu02 = tesztKutyu02.masolat();
        assertFalse(masoltKutyu01.equals(tesztKutyu01));
        assertFalse(masoltKutyu02.equals(tesztKutyu02));
    }
    
    @Test
    public void emberTeszt(){
        
        
        assertTrue(tesztEmber01.huvelykujjEro() == 0);
        
        
        
        
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
