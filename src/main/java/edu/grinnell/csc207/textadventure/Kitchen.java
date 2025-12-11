package edu.grinnell.csc207.textadventure;

import java.util.ArrayList;
import java.util.List;

public class Kitchen implements Room {
  private List<String> itemsInRoom = new ArrayList<>();

  public Kitchen() {
    itemsInRoom.add("flashlight");
  }

  /**
   * Returns action when player chooses to wait
   */
  @Override
  public void Wait() {
    System.out.println("It is a pretty uneventful wait in the kitchen.");
  }

  /**
   * Moves a player in a certain direction
   * 
   * @param direction   a String (North)
   * @param currentRoom the current room the player is in
   * @param doors       a list of the doors in the game (contains whether they are
   *                    locked or not)
   * @return
   */
  @Override
  public Room move(String direction, Room currentRoom, List<Doors> doors) {
    direction = direction.toLowerCase();
    if (direction.equals("north")) {
      System.out.println("You walk back into the living room.");
      return currentRoom = new LivingRoom();
    } else {
      System.out.println("You can't go that way from the kitchen.");
      return currentRoom;
    }
  }

  /**
   * Gives information when a player inspects an item
   * 
   * @param item String item name
   */
  @Override
  public void pickUp(String item) {
    System.out.println("You hold onto the " + item + ". It could be useful later.");
  }

  /**
   * Returns the effect of using an item in a room, but in kitchen you cannot use
   * any items so this function just informs the user of that
   * 
   * @param input       The input of the user, contains the item, and the target
   * @param inventory   The players inventory
   * @param currentRoom the current room the player is in
   * @param doors       a list of the doors in the game (contains whether they are
   *                    locked or not)
   */
  @Override
  public void use(List<String> input, Inventory inventory, Room currentRoom, List<Doors> doors) {
    System.out.println("You can't use items in the kitchen right now.");
  }

  /**
   * Returns a description of the room and items in it
   */
  @Override
  public void surveyRoom() {
    if (itemsInRoom.isEmpty()) {
      System.out
          .println(
              "You look around the kitchen but find its depressingly empty. No food to sustain yourself. You need to find a way out");
    } else {
      System.out.println("You look around the living room and find:");
      for (String item : itemsInRoom) {
        System.out.println(item);
      }
    }
  }

  /**
   * Returns whether or not an item exists in the room
   * 
   * @return boolean
   */
  @Override
  public boolean itemExists(String item) {
    for (String items : itemsInRoom) {
      items = items.toLowerCase();
      if (items.equals(item)) {
        return true;
      }
    }
    return false;
  }

}
