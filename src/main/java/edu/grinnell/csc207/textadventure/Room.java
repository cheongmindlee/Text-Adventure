package edu.grinnell.csc207.textadventure;

import java.util.List;

public interface Room {

  /**
   * Returns action when player chooses to wait
   */
  public void Wait();

  /**
   * Moves a player in a certain direction
   * 
   * @param direction   a String (North, South, East, West)
   * @param currentRoom the current room the player is in
   * @param doors       a list of the doors in the game (contains whether they are
   *                    locked or not)
   * @return
   */
  public Room move(String direction, Room currentRoom, List<Doors> doors);

  /**
   * Gives information when a player inspects an item
   * 
   * @param item String item name
   */
  public void pickUp(String item);

  /**
   * Returns the effect of using an item in a room
   * 
   * @param input       The input of the user, contains the item, and the target
   * @param inventory   The players inventory
   * @param currentRoom the current room the player is in
   * @param doors       a list of the doors in the game (contains whether they are
   *                    locked or not)
   */
  public void use(List<String> input, Inventory inventory, Room currentRoom, List<Doors> doors);

  /**
   * Returns a description of the room and items in it
   */
  public void surveyRoom();

  /**
   * Returns whether or not an item exists in the room
   * 
   * @return boolean
   */
  public boolean itemExists(String item);
}
