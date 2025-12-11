package edu.grinnell.csc207.textadventure;

import java.util.ArrayList;
import java.util.List;

public class LivingRoom implements Room {

  private List<String> itemsInRoom = new ArrayList<>();

  public LivingRoom() {
    itemsInRoom.add("Golden Key");
  }

  /**
   * Returns action when player chooses to wait
   */
  @Override
  public void Wait() {
    System.out.println("You wait for a moment hoping help arrives. You're an idiot. No one is coming to save you. " +
        "You have no friends so no one knows you're missing. You're stuck in here... Alone.");
  }

  /**
   * Moves a player in a certain direction
   * 
   * @param direction   a String (North, South, East)
   * @param currentRoom the current room the player is in
   * @param doors       a list of the doors in the game (contains whether they are
   *                    locked or not)
   * @return
   */
  @Override
  public Room move(String direction, Room currentRoom, List<Doors> doors) {
    // Standardize direction to lowercase
    direction = direction.toLowerCase();
    if (direction.equals("north")) {
      if (doors.get(0).getLocked()) {
        System.out.println(
            "You try to open the front door, but it's locked tight . It requires a weirdly shaped key to open");
        return currentRoom;
      } else {
        System.out.println("You walk out the front door to freedom.");
        return currentRoom = new FrontDoor();
      }
    } else if (direction.equals("east")) {
      if (doors.get(1).getLocked()) {
        System.out.println("You try to go into the basement but the door is locked. Maybe there's a key somewhere?");
        return currentRoom;
      } else {
        System.out.println("You walk into the basement. It's dark and creepy down here.");
        return currentRoom = new Basement();
      }

    } else if (direction.equals("south")) {
      System.out.println("You walk into the kitchen");
      return currentRoom = new Kitchen();
    } else if (direction.equals("west")) {

      // Worry about these later
      System.out.println("You walk into a bedroom.");
      return currentRoom;
    } else {
      System.out.println("Those direction are not valid. Sit down and think about your actions. You can only move " +
          "north, south, east, or west.");
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
    // Check if item can be used in room and apply effects
    if (room.equals("basement") && itemName.equals("golden key")) {
      doors.get(1).setLocked(false);
      System.out.println("You use the Golden Key to unlock the basement!");
    } else if (room.equals("front door") && itemName.equals("skeleton key")) {
      doors.get(0).setLocked(false);
      System.out.println("You use the Skeleton Key to unlock the front door! You can finally step outside to freedom!");
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
    if (itemsInRoom.isEmpty()) {
      System.out.println("You look around the living room but find nothing remotely interesting.");
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
