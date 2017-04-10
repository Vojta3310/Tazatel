/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel.dataStructure;

import tazatel.dataStructure.OtazkaData;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ondřej Bleha
 */
public class PredmetData {
    
    private final String nazev;
    private ArrayList<OtazkaData> otazky;
    
    public PredmetData(String nazev) {
        this.nazev = nazev;
        this.otazky = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return nazev;
    }
    
    public String getNazev() {
        return nazev;
    }
    
    public void addOtazka(OtazkaData otazka) {
        otazky.add(otazka);
    }
    
    public void zprehazejOtazky() {
        ArrayList<OtazkaData> temp = new ArrayList<>();
        for (int i = 0; i < otazky.size(); i++) {
            Random ran = new Random();
            temp.add(otazky.remove(ran.nextInt(otazky.size())));
        }
        this.otazky = temp;
    }
    
    public int getPocetOtazek() {
        return otazky.size();
    }
    
}
