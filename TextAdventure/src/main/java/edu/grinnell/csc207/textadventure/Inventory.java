package edu.grinnell.csc207.textadventure;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private List<String> items;

  public Inventory() {
    this.items = new ArrayList<>();
  }

  /**
   * Adds an item to players inventory
   * 
   * @param item String item name
   */
  public void addItem(String item) {
    items.add(item);
  }

  /**
   * Removes an item from players inventory
   * 
   * @param item String item name
   */
  public void removeItem(String item) {
    items.remove(item);
  }

  /**
   * Prints out all of the players invnetory
   */
  public void checkInventory() {
    if (items.isEmpty()) {
      System.out.println("Your inventory is empty!");
    } else {
      System.out.println("You look into your inventory and find");
      for (String item : items) {
        System.out.println(item);
      }
    }
  }

  public boolean hasItem(String item) {
    return items.contains(item);
  }
}
