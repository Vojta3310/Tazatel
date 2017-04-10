/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel;

import AbstractList.AbstractList;
import AbstractList.IAbstractList;
import AbstractList.IIterator;
import java.util.Random;

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
    int i=0;
    int c=Integer.MAX_VALUE;
    IIterator a=otazky.vytvorIterator();
    a.vynulujIterator();
    otazka b=(otazka) a.zpristupniAktualni();
    while (a.hasNext()){  //zjistim nejniší c
      if (b.getUsed()<c)
        c=b.getUsed();
      b=(otazka) a.getNext();
    }
    
    AbstractList<otazka> d;
    d=new AbstractList();
    a.vynulujIterator();
    b=(otazka) a.zpristupniAktualni();
    while (a.hasNext()){  //vsechny s nejmensim vyberu
      if (b.getUsed()==c){
        i++;
        d.add(b);
      }
        c=b.getUsed();
      b=(otazka) a.getNext();
    }
    
    //vybrat náhodnou z d
    Random randomGenerator= new Random();
    int e=randomGenerator.nextInt(i);
    IIterator f =d.vytvorIterator();
    f.vynulujIterator();
    otazka g=(otazka) f.zpristupniAktualni();
    for (int j = 0; j < i; j++) {
      g=(otazka) f.getNext();
    }
    aktualni=g;
    hotovo=otazky.getPocet()-i;
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
