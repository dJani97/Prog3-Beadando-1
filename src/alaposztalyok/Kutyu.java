/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

/**
 * Kütyü interfész, mely leírja egy Kütyü legfőbb jellemzőit.
 * @author djani
 */
public interface Kutyu {
        
    public void uzenetetKuld(int uzenetHossza);
    
    public int huvelykujjSejtek();
    
    public Kutyu masolat();
    
}
