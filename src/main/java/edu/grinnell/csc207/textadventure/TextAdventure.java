package edu.grinnell.csc207.textadventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextAdventure {
  public void main(String[] args) {

    // Initialize all necessary components
    Room currentRoom = new LivingRoom();
    Inventory inventory = new Inventory();
    Scanner scanner = new Scanner(System.in);
    List<Doors> doors = new ArrayList<>();

    doors.add(new Doors("front door", true));
    doors.add(new Doors("basement door", true));
    doors.add(new Doors("kitchen", false));

    System.out.println("Welcome to David's Text Adventure Escape Game!");
    System.out.println("Your goal is to escape this creepy house you woke up in.\n");

    // Keep track of game state
    int counter = 1;
    boolean gameState = true;

    System.out.println("Turn: " + counter + " =====");
    System.out.println("""
        You wake up to find yourself in a unfamiliar room.
        You see a dining table and are able to deduce that you are in a living room.
        You try to leave through the front door but it is locked tight with a keypad""");
    while (gameState) {

      // Get user input
      System.out.print("> ");
      String input = scanner.nextLine();
      Parser parser = new Parser(input);

      // keep asking for input until we get valid input
      while (parser.isValidAction() == false) {
        System.out.println("Invalid command, please try again.");
        input = scanner.nextLine();
        parser = new Parser(input);
      }

      // Check what the action word is and go through the switch cases
      switch (parser.getAction()) {
        case "move":
          String direction = parser.getSubject();
          direction = direction.toLowerCase();
          currentRoom = currentRoom.move(direction, currentRoom, doors);
          break;
        case "pick":
          // Tke the words after pick up and take it in as the item name
          String item = "";
          for (int i = 1; i < parser.getObject().size(); i++) {
            item += parser.getObject().get(i) + " ";

          }
          item = item.toLowerCase().trim();
          if (currentRoom.itemExists(item)) {
            currentRoom.pickUp(item);
            inventory.addItem(item);
          } else {
            System.out.println("You're hallucinating items. " + item + " does not exist in this room.");
            System.out.println("You should make your input of the form 'pick up <item name>'");
          }
          break;
        case "use":
          currentRoom.use(parser.getObject(), inventory, currentRoom, doors);
          break;
        case "survey":
          currentRoom.surveyRoom();
          break;
        case "wait":
          currentRoom.Wait();
          break;
        case "check":
          inventory.checkInventory();
          break;
        case "quit":
          System.out.println("Thanks for playing!");
          gameState = false;
          break;
      }

      if (currentRoom instanceof FrontDoor) {
        gameState = false;
      }
      counter++;
      System.out.println();
      System.out.println("Turn: " + counter + " =====");
    }

    scanner.close();
    System.out.println("You managed to escape! Good job I hope you had fun!");
  }
}
