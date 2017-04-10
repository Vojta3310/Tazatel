/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel.dataStructure;

import tazatel.dataStructure.OtazkaData;
import java.util.ArrayList;

/**
 *
 * @author Ondřej Bleha
 */
public class OtazkyData {
    
    private final ArrayList<PredmetData> predmety;
    
    public OtazkyData() {
        this.predmety = new ArrayList<>();
    }
    
    public void addPredmet(String nazev) {
        predmety.add(new PredmetData(nazev));
    }
    
    public void addOtazka(OtazkaData otazka) {
        if(!predmety.isEmpty()) {
            predmety.get(predmety.size()-1).addOtazka(otazka);
        }        
    }
    
    public int getPocetPredmetu() {
        return predmety.size();
    }
    
    public PredmetData getPredmet(int index) {
        return predmety.get(index);
    }
    
}
