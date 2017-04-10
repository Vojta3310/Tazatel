/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel;

import AbstractList.AbstractList;
import AbstractList.IAbstractList;

/**
 *
 * @author vojta3310
 */
public class vjestnik {
  private IAbstractList<otazka> otazky;
  private otazka aktualni;
  private int hotovo;
  
  public void load(String xml){  //nacte z xml nak
   otazky=new AbstractList();
   otazky.add(new otazka("STT1","víroba Fe", "stt/1.pdf", 0));
  }
  
  public void Save(String xml){  //ulozi do xml

  }
  
  public void next(){  //vygeneruje dalsi nahodnou
    
  }

  public otazka getAktualni() { //vraci aktualni
    return aktualni;
  }

  public int getHotovo() {  //pocet zodpovezenych
    return hotovo;
  }

  public int getPocet() {  // celkem
    return otazky.getPocet();
  }
  
  
}
