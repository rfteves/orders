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
public class TestWeekday {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Calendar now = Calendar.getInstance();
    System.out.println("now " + now.getTime());
    System.out.println(now.get(Calendar.DAY_OF_WEEK));
    int working = 0;
    boolean added = false;
    while (working < 5) {
      added = false;
      now.add(Calendar.DATE, 1);
      System.out.println("now " + now.getTime());
      if (now.get(Calendar.DAY_OF_WEEK) > 1 && now.get(Calendar.DAY_OF_WEEK) < 7) {
        ++working;
        added = true; 
      }
      if (added && (now.get(Calendar.DAY_OF_WEEK) == 1 || now.get(Calendar.DAY_OF_WEEK) == 7)) {
        --working;
      }
    }
    System.out.println("del " + now.getTime());
  }
  
}
