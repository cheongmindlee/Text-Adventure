package edu.grinnell.csc207.textadventure;

public class Doors {
  String door;
  boolean isLocked;

  public Doors(String door, boolean isLocked) {
    this.door = door;
    this.isLocked = isLocked;
  }

  /**
   * Returns whether the door is locked
   * 
   * @return boolean
   */
  public boolean getLocked() {
    return this.isLocked;
  }

  /**
   * Set the door to be locked or unlocked
   * 
   * @param locked boolean
   */
  public void setLocked(boolean locked) {
    this.isLocked = locked;
  }
}
