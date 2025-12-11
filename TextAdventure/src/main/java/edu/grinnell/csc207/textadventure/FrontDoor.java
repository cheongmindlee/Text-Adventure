package edu.grinnell.csc207.textadventure;

import java.util.List;

public class FrontDoor implements Room {

  @Override
  public void Wait() {
    // Just for the interface no need for it to do anything because game ends once
    // we exit from the front door
  }

  @Override
  public Room move(String direction, Room currentRoom, List<Doors> doors) {

    // Just for the interface no need for it to do anything because game ends once
    // we exit from the front door
    return new FrontDoor();
  }

  @Override
  public void pickUp(String item) {
    // Just for the interface no need for it to do anything because game ends once
    // we exit from the front door
  }

  @Override
  public void use(List<String> input, Inventory inventory, Room currentRoom, List<Doors> doors) {
    // Just for the interface no need for it to do anything because game ends once
    // we exit from the front door
  }

  @Override
  public void surveyRoom() {
    // Just for the interface no need for it to do anything because game ends once
    // we exit from the front door
  }

  @Override
  public boolean itemExists(String item) {
    // Just for the interface no need for it to do anything because game ends once
    // we exit from the front door
    return true;
  }

}
