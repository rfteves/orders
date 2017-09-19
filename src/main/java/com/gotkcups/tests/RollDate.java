/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gotkcups.tests;

import java.util.Calendar;

/**
 *
 * @author rfteves
 */
public class RollDate {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Calendar now = Calendar.getInstance();
    int y=0;
    while (++y < 800) {
      System.out.println(now.getTime());
      now.add(Calendar.DATE, 1);
    }
  }
  
}
