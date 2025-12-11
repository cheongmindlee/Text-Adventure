package edu.grinnell.csc207.textadventure;

import java.util.ArrayList;
import java.util.List;

/**
 * Takes in a string and parses it into commands
 */
public class Parser {
  // Fields in Parser
  String action;
  List<String> object;
  String subject;

  public Parser(String input) {
    String[] words = input.split(" ");
    object = new ArrayList<>();

    // Depending on input length parse accordingly
    if (words.length < 2) {
      this.action = words[0];
      this.object.add("");
    } else {
      this.action = words[0];
      subject = words[1];
      for (int i = 1; i < words.length; i++) {
        this.object.add(words[i]);
      }
    }
  }

  /**
   * Checks if the action is a valid command
   * 
   * @return boolean
   */
  public boolean isValidAction() {
    action = action.toLowerCase();
    // Make sure the action is a valid command
    if (action.equals("move") || action.equals("talk") || action.equals("pick") ||
        action.equals("use") || action.equals("attack") || action.equals("survey") ||
        action.equals("wait") || action.equals("check") || action.equals("quit")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns the action, and standardizes it to all lower case
   * 
   * @return String
   */
  public String getAction() {

    return this.action.toLowerCase();
  }

  /**
   * Returns the object the action is performing on
   * 
   * @return
   */
  public List<String> getObject() {
    return this.object;
  }

  /**
   * Returns the subject and standardizes it to all lower case
   * 
   * @return String
   */
  public String getSubject() {
    return subject.toLowerCase();
  }
}
