/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel.dataStructure;

/**
 *
 * @author vojta3310
 */
public class OtazkaData {
  private final String id;
  private final String zadani;
  private final String dokument;
  private int pouzito;

  public OtazkaData(String id, String text, String file_path, int used) {
    this.id = id;
    this.zadani = text;
    this.dokument = file_path;
    this.pouzito = used;
  }  
  
  public void pouzij(){   // volat po uplinuti 15 min a pak ulozit
    pouzito++;
  }

  public String getId() {
    return id;
  }

  public String getZadani() {
    return zadani;
  }

  public String getDokument() {
    return dokument;
  }

  public int getPouzito() {
    return pouzito;
  }  
  
}
