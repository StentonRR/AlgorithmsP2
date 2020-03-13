/** CMPT_435L_800
 * Project 1 -- Maze Solver
 * Filename: LocationStack.java
 * Student Name: Eric Stenton
 * Due Date: February 12, 2020
 * Version 1.0
 *
 * This file contains functions pertaining to the creation of a stack that
 * holds location node objects that serve as a linked list structure. Each
 * node points to a location in which the search has defined as its current
 * path.
 */


/**
 * LocationStack
 *
 * This class defines a stack that holds location objects. It provides standard
 * stack functions such as push, pop, and others. The top variable is a
 * reference to the uppermost location node stored in the stack.
 */
class LocationStack {
  private LocationStack(LocationStack s) { assert(false); }
  private LocationStackNode top;

  /** LocationStack
   *  parameters: nothing
   *  return value: nothing
   *
   *  This function serves as the constructor for the LocationStack object.
   *  It requires no input variables and it initializes the top variable to
   *  null.
   */
  LocationStack() {
    top = null;
  }

  /** push
   *  parameters:
   *      loc -- Location object to push onto stack.
   *  return value: nothing
   *
   *  This function adds a location object onto the stack. It also reorders
   *  the previous top location node under the new one and replaces the top
   *  variable.
   */
  void push(Location loc) {
    // Create a new node where next node is the previous one on top
    LocationStackNode node = new LocationStackNode(loc, top);

    // Make the top node variable equal to the new one
    top = node;
  }

  /** pop
   *  parameters: nothing
   *  return value: nothing
   *
   *  This function removes the top location node on the stack. It does this
   *  simply by replacing the top variable with the next node.
   */
  void pop() {
    // Replace the top node with the node specified as the next one
    top = top.getNextNode();
  }

  /** getTop
   *  parameters: nothing
   *  return value:
   *      Location -- The location that is currently at the top of the stack.
   *
   *  This function retrieves the location at the top of the stack and
   *  returns it.
   */
  Location getTop() {
    return top.getLocation();
  }

  /** isEmpty
   *  parameters: nothing
   *  return value:
   *      boolean -- true if the stack is empty and false if it is not
   *
   *  This function determines if the stack is empty by checking if the
   *  top location node is null.
   */
  boolean isEmpty() {
    // Stack is empty only when the top node is null
    return top == null;
  }

  /** isOn
   *  parameters:
   *      loc -- A location object to check if it exists in the stack.
   *  return value:
   *      boolean -- true if location object is in stack and false if not.
   *
   *  This function loops through the stack and checks if the given location
   *  object is equal to any of the location objects in the stack.
   */
  boolean isOn(Location loc) {

    // Loop through nodes and check for an equal location
    LocationStackNode currentNode = top;
    while (currentNode != null) {
      if ( currentNode.getLocation().isEqual(loc) ) {
        return true; // An equal location was found
      }

      currentNode = currentNode.getNextNode();
    }

    return false; // An equal location was not found
  }

  /** streamOut
   *  parameters:
   *      s -- The stack to be printed.
   *  return value: nothing
   *
   *  This function prints the contents of the location stack by first
   *  reversing the linked list of nodes within it, then prints each location
   *  as the linked list is returned to its original order.
   */
  void streamOut(LocationStack s) {

    // Get starting variables -- will act as a sliding window when iterating
    LocationStackNode previousNode = null;
    LocationStackNode currentNode = top;
    LocationStackNode nextNode;

    // Initial pass & link switch
    while (currentNode != null) {

      // Define next node
      nextNode = currentNode.getNextNode();

      // Switch link
      currentNode.setNextNode(previousNode);

      // Move node 'window' down by one
      previousNode = currentNode;
      currentNode = nextNode;
    }

    // Replace top with the last one after loop
    top = previousNode;


    // Reset variables
    previousNode = null;
    currentNode = top;

    // Second pass & link switch
    while (currentNode != null) {

      // Print location
      currentNode.getLocation().streamOut();

      // Define next node
      nextNode = currentNode.getNextNode();

      // Switch link
      currentNode.setNextNode(previousNode);

      // Move node 'window' down by one
      previousNode = currentNode;
      currentNode = nextNode;

      // Get prints to be on new lines
      System.out.println("");

    }

    // Replace top with the last one after loop
    top = previousNode;

  }
}


/**
 * LocationStackNode
 *
 * This class defines a location node that acts as a component within a linked
 * list which serves as the implementation of the location stack. Each node
 * has a location object and a reference to the node that follows it.
 */
class LocationStackNode {
  private LocationStackNode() { assert(false); }
  private LocationStackNode(LocationStackNode s) { assert(false); }

  private Location location;
  private LocationStackNode nextNode;

  /** LocationStackNode
   *  parameters:
   *      loc -- The location object to be stored within the node.
   *      next -- A reference to the following location node.
   *  return value: nothing
   *
   *  This function serves as the constructor for the LocationStackNode object.
   *  It initializes the location and nextNode variables with the given
   *  parameters.
   */
  LocationStackNode(Location loc, LocationStackNode next) {
    location = loc;
    nextNode = next;
  }

  /** getLocation
   *  parameters: nothing
   *  return value:
   *      Location -- The location object stored within the node object.
   *
   *  This function simply returns a reference to the location object stored
   *  in the location node object. Otherwise it returns null.
   */
  Location getLocation() {
    return location;
  }

  /** getNextNode
   *  parameters: nothing
   *  return value:
   *      LocationStackNode -- A reference to the location node that follows.
   *
   *  This function returns the location node that follows. Otherwise it
   *  returns null.
   */
  LocationStackNode getNextNode() {
    return nextNode;
  }

  /** getNextNode
   *  parameters:
   *      next -- A reference to a location node to be set as the next one.
   *  return value: nothing
   *
   *  This function sets the next location node of a given location node with
   *  the specified one.
   */
  void setNextNode(LocationStackNode next) {
    nextNode = next;
  }
}
