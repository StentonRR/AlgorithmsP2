/** CMPT_435L_800
 * Project 1 -- Maze Solver
 * Filename: Maze.java
 * Student Name: Eric Stenton
 * Due Date: February 12, 2020
 * Version 1.0
 *
 * This file contains the functions to define a maze from values given through
 * system input.
 */

import java.util.Scanner;

/**
 * Maze
 *
 * This class defines the maze object to be solved. It provides a list of valid
 * locations, the number of them, the start location, and the end location.
 */
class Maze {
  private Maze(Maze m) { assert(false); }

  private int validLocationCount;
  private Location[] validLocations;

  private Location startLocation;
  private Location endLocation;

  /** Maze
   *  parameters: nothing
   *  return value: nothing
   *
   *  This function serves as the constructor for the Maze object. It
   *  requires no input variables; it initializes the validLocationCount
   *  variable to 0 and the start and end location variables to new instances
   *  of location objects.
   */
  Maze() {
    validLocationCount = 0;
    startLocation = new Location();
    endLocation = new Location();
  }

  /** getStartLocation
   *  parameters: nothing
   *  return value:
   *      Location -- The starting location of the maze.
   *
   *  This function simply returns the location object describing the start
   *  of the maze.
   */
  Location getStartLocation() {
    return startLocation;
  }

  /** isValidLocation
   *  parameters:
   *      loc -- The location object to check if it contains row and column
   *             values defining a valid location in the maze.
   *  return value:
   *      boolean -- True if the location object describes a valid location and
   *                 false if not.
   *
   *  This function loops through the list of valid locations and checks if the
   *  specified location object defines a location equal to one of the valid
   *  ones.
   */
  boolean isValidLocation(Location loc) {

    for (int i = 0; i < validLocationCount; i++) {
      if ( validLocations[i].isEqual(loc) ) {
        return true;
      }
    }

    return false;
  }

  /** isEndLocation
   *  parameters:
   *      loc -- The location object to check if it contains row and column
   *             values equal to the ending location of the maze.
   *  return value:
   *      boolean -- True if the location object describes a location equal
   *                 to the ending location and false if not.
   *
   *  This function simply checks for equality between the specified location
   *  object and the ending location object of the maze.
   */
  boolean isEndLocation(Location loc) {
    return endLocation.isEqual(loc);
  }

  /** streamIn
   *  parameters:
   *      input -- A scanner object used to read system input.
   *  return value: nothing
   *
   *  This function obtains the maze definition from system input. The first
   *  integer defines the number of valid locations. The following number of
   *  lines equal to the number of valid locations each has a row and a column
   *  value for a valid location. The last two lines have a row and a column
   *  value for the start and end location respectively.
   */
  void streamIn(Scanner input) {

    // Read number of locations
    validLocationCount = input.nextInt();

    // Initialize array with number of locations
    validLocations = new Location[validLocationCount];

    // Read valid locations
    for (int i = 0; i < validLocationCount; i++) {
      validLocations[i] = new Location();
      validLocations[i].streamIn(input);
    }

    // Read start and end locations
    startLocation.streamIn(input);
    endLocation.streamIn(input);
  }
}
