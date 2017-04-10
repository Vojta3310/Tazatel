/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel;

/**
 *
 * @author vojta3310
 */
public class otazka {
  private final String id;
  private final String text;
  private final String file_path;
  private int used;

  public otazka(String id, String text, String file_path, int used) {
    this.id = id;
    this.text = text;
    this.file_path = file_path;
    this.used = used;
  }  
  
  private void use(){   // volat po uplinuti 15 min a pak ulozit
    used++;
  }

  public String getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public String getFile_path() {
    return file_path;
  }

  public int getUsed() {
    return used;
  }
  
  
}
