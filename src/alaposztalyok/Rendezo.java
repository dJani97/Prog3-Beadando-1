/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.util.Comparator;

/**
 *
 * @author djani
 */
public class Rendezo implements Comparator<Ember> {

    private static boolean novekvo = false;

    
    public static void setNovekvo(boolean novekvo) {
        Rendezo.novekvo = novekvo;
    }
    
    
    @Override
    public int compare(Ember o1, Ember o2) {

        if(novekvo){
            return o1.huvelykujjEro() - o2.huvelykujjEro();
        } else {
            return o2.huvelykujjEro() - o1.huvelykujjEro();
        }
        
    }
}
