/** CMPT_435L_800
 * Project 1 -- Maze Solver
 * Filename: Driver_prj1.java
 * Student Name: Eric Stenton
 * Due Date: February 12, 2020
 * Version 1.0
 *
 * This file contains the main function for the Maze Solver project.
 * It uses a depth-first search in order to find a path from the
 * start location to the end location.
 */

import java.util.Scanner;

/**
 * Driver_prj1
 *
 * This class implements Location, LocationStack, and Maze objects to
 * find the solution to a given maze in system input.
 */
public class Driver_prj1 {

    /** main
     *  parameters:
     *      args -- the array of command line argument values
     *  return value: nothing
     *
     *  This function uses a depth-first search to determine whether a solution
     *  exists for a given maze in system input. It prints its results.
     */
    public static void main(String[] args) {
        // Initialize scanner variable
        Scanner input = new Scanner(System.in);

        // Make sure there is input
        if( !input.hasNextInt() ){
            System.out.println("No solution found");
            return;
        }

        // Create maze object and read maze from system input
        Maze maze = new Maze();
        maze.streamIn(input);

        // Initialize location stack
        LocationStack locationStack = new LocationStack();

        // Initialize starting location
        Location currentLocation = maze.getStartLocation();
        locationStack.push(currentLocation);
        currentLocation.start();

        // Explore the maze until end location is found
        while ( !maze.isEndLocation(currentLocation) ) {

            // Get next location or backtrack if needed
            if ( !currentLocation.isDone() ) {

                // Go to next location
                currentLocation = currentLocation.nextNeighbor();

                // Add location to the stack if it is valid and not a previous
                // location
                if ( maze.isValidLocation(currentLocation) &&
                     !locationStack.isOn(currentLocation) ) {

                    locationStack.push(currentLocation);
                    currentLocation.start();

                } else {

                    // Return from non-valid location
                    currentLocation = locationStack.getTop();

                }

            } else {

                // Backtrack
                locationStack.pop();

                // Check if there is no solution
                if ( locationStack.isEmpty() ) {
                    System.out.println("No solution found");
                    return;
                }

                currentLocation = locationStack.getTop();

            }
        }

        // A solution was found
        System.out.println("Solution found:");
        locationStack.streamOut(locationStack);
    }
}