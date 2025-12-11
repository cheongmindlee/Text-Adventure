package edu.grinnell.csc207.textadventure;

import java.util.ArrayList;
import java.util.List;

public class Basement implements Room {
  private List<String> itemsInRoom = new ArrayList<>();
  private boolean isLit;

  public Basement() {
    itemsInRoom.add("skeleton key");
    isLit = false;
  }

  /**
   * Returns action when player chooses to wait
   */
  @Override
  public void Wait() {
    System.out.println("You wait in the dark, damp basement. Nothing happens.");
  }

  /**
   * Moves a player in a certain direction
   * 
   * @param direction   a String (West)
   * @param currentRoom the current room the player is in
   * @param doors       a list of the doors in the game (contains whether they are
   *                    locked or not)
   * @return
   */
  @Override
  public Room move(String direction, Room currentRoom, List<Doors> doors) {
    direction = direction.toLowerCase();
    if (direction.equals("west")) {
      System.out.println("You walk back into the living room.");
      return currentRoom = new LivingRoom();
    } else {
      System.out.println("You can't go that way from the basement.");
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
   * Returns the effect of using an item in a room
   * 
   * @param input       The input of the user, contains the item, and the target
   * @param inventory   The players inventory
   * @param currentRoom the current room the player is in
   * @param doors       a list of the doors in the game (contains whether they are
   *                    locked or not)
   */
  @Override
  public void use(List<String> input, Inventory inventory, Room currentRoom, List<Doors> doors) {
    // The ending string will be the room name
    String room = "";
    String itemName = "";
    // keep going until we get an item or until the string ends
    for (int i = 0; i < input.size(); i++) {

      if (!inventory.hasItem(itemName.trim())) {
        itemName += input.get(i) + " ";
        // If we found an item add the rest of words to the room name
      } else if (input.get(i).toLowerCase().equals("on") || input.get(i).toLowerCase().equals("in")) {
        continue;
      } else {
        room += input.get(i) + " ";
      }
    }

    // Check if you have the item in your inventory
    itemName = itemName.trim().toLowerCase();
    if (!inventory.hasItem(itemName)) {
      System.out.println("You don't have " + itemName + " in your inventory to use.");
      return;
    }

    room = room.trim().toLowerCase();
    // Check to make sure the room is an adjacent room / exists
    room = room.trim().toLowerCase();
    if (room.equals("basement") && itemName.equals("flashlight")) {
      System.out.println("You use the flashlight to light up the basement! You can finally see your surroundings");
      isLit = true;
    } else {
      System.out.println("You can't use the " + itemName + " on/in the " + room
          + ". Either you can't use that item here or the item/room is invalid.");
      System.out.println("Your input should be of the form 'use <item name> on/in <room name>'");
    }

  }

  /**
   * Returns a description of the room and items in it
   */
  @Override
  public void surveyRoom() {
    if (isLit) {
      if (itemsInRoom.isEmpty()) {
        System.out
            .println("You look around the basement room but find nothing remotely interesting. It is damp and nasty");
      } else {
        System.out.println("You look around the living room and find:");
        for (String item : itemsInRoom) {
          System.out.println(item);
        }
      }
    } else {
      System.out.println("It's too dark to see anything in the basement. If only you had a light source...");
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