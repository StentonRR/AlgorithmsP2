/** CMPT_435L_800
 * Project 1 -- Maze Solver
 * Filename: Location.java
 * Student Name: Eric Stenton
 * Due Date: February 12, 2020
 * Version 1.0
 *
 * This file contains functions pertaining to the creation of a location object.
 * Such objects represent locations within a given maze.
 */

import java.util.Scanner;

/**
 * Location
 *
 * This class defines a location object which provides an iterator for its
 * neighbors and defines its own column and row number.
 */
class Location {
  final int RIGHT = 0;
  final int DOWN  = 1;
  final int LEFT  = 2;
  final int UP    = 3;
  final int DONE  = 4;

  private int row;
  private int col;
  int nextDirection;   // mutable

  /** Location
   *  parameters: nothing
   *  return value: nothing
   *
   *  This function serves as the constructor for the Location object. It
   *  requires no input variables; it initializes the row and col numbers to
   *  0 and the nextDirection variable to DONE.
   */
  Location() {
    row = 0;
    col = 0;
    nextDirection = DONE;
  }

  /** start
   *  parameters: nothing
   *  return value: nothing
   *
   *  This function simply changes the value of the nextDirection variable to
   *  RIGHT in order to start the process of determining the correct next step
   *  from this location.
   */
  void start() {  // const
    nextDirection = RIGHT;
  }

  /** nextNeighbor
   *  parameters: nothing
   *  return value:
   *      Location -- The location object of the next neighboring location.
   *
   *  This function returns a location object originating as a copy of the
   *  location object instance. The copy's row or column value is modified
   *  to change it into the next location to evaluate.
   */
  Location nextNeighbor() {  // const

    // Create a copy
    Location p = new Location();
    p.row = row;
    p.col = col;

    if ( nextDirection == RIGHT ) {
      p.col++;
    } else if ( nextDirection == DOWN ) {
      p.row++;
    } else if ( nextDirection == LEFT ) {
      p.col--;
    } else if ( nextDirection == UP ) {
      p.row--;
    }

    nextDirection++;
    return p;
  }

  /** isDone
   *  parameters: nothing
   *  return value:
   *      boolean -- True if the nextDirection variable is equal to DONE and
   *                 false if not.
   *
   *  This function simply checks if there are any more directions to evaluate
   *  from the current location. If not, it returns true and this location is
   *  'done'.
   */
  boolean isDone() {  // const
    return nextDirection == DONE;
  }

  /** isEqual
   *  parameters:
   *      loc -- The location object to test its equality with the current one.
   *  return value:
   *      boolean -- True if the provided location object is equal to the
   *                 current one and false if it is not.
   *
   *  This function checks the equality of two location objects by determining
   *  if their row and column values are the same.
   */
  boolean isEqual(Location loc) {  // const
    return ( row == loc.row && col == loc.col );
  }

  /** streamOut
   *  parameters: nothing
   *  return value: nothing
   *
   *  This function prints the location object's row and column values.
   */
  void streamOut() {
    System.out.print( row + " " + col );
  }

  /** streamIn
   *  parameters:
   *      input -- A scanner object used to read system input.
   *  return value: nothing
   *
   *  This function obtains the location's row and column values using the
   *  provided scanner object.
   */
  void streamIn(Scanner input) {
    row = input.nextInt();
    col = input.nextInt();
  }

}
