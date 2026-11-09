import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Carter Jorgensen
 * Date: 11 / 09 / 2026
 * Purpose: To create a class that can model a graph using a matrix (or 2-dimensional arraylist)
 */
public class GraphAdjMatrix {
    //Attributes
    private final ArrayList<ArrayList<Double>> adjMatrix;

    //Constructors
    /**
     * A constructor that builds a graph using an Adjacency matrix from a given file
     * @param fName The name of the file being read
     */
    public GraphAdjMatrix(String fName) {
        try {
            //Create a FileReader and a Scanner to be able to read the file in bits and pieces
            Scanner zeroScanner = new Scanner(new FileReader(fName));

            //Need to initialize adjMatrix to have all zeros===================
            int adjMatSize = findLargestChar(zeroScanner);
            adjMatrix = new ArrayList<>(adjMatSize);

            System.out.println(adjMatSize);

            //loops through each column of the matrix
            for (int col = 0; col < adjMatSize; col++) {
                ArrayList<Double> tempRow = new ArrayList<>(adjMatSize); //The arraylist to be added to the matrix

                //loops through each row of the matrix
                for (int row = 0; row < adjMatSize; row++) {
                    tempRow.add(row, 0.0); //presets rows to 0.0
                }
                //Adds the row to the column
                adjMatrix.add(tempRow);
            }
            //=================================================================

            //now to add weights to the existing edges=========================
            Scanner weightScanner = new Scanner(new FileReader(fName));

            //loop runs while there is a next element to be read
            while (weightScanner.hasNext()) {
                //Get the first and second index's as integers
                int firstIndex = weightScanner.next().charAt(0) - 'A';
                int secondIndex = weightScanner.next().charAt(0) - 'A';

                //The weight of the edge
                double weight = weightScanner.nextDouble();

                //Graph is bidirectional so it has to go both ways
                adjMatrix.get(firstIndex).set(secondIndex, weight);
                adjMatrix.get(secondIndex).set(firstIndex,weight);
            }
            //=================================================================

            //close both scanners to save space
            zeroScanner.close();
            weightScanner.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Methods
    /**
     * A helper method to find the size of the 2-dimensional matrix
     * @param s The scanner that reads the file
     * @return The size of the matrix
     */
    private int findLargestChar(Scanner s) {
        //The first character is the 'largest'
        int first = s.next().charAt(0);

        //Sets the largest to the first int
        int largest = first;

        //loops while there is a next value within scanner s
        while (s.hasNext()) {
            int temp = s.next().charAt(0); //gets the int value of the character

            //checks if the temp is larger than the current largest
            if (temp > largest) {
                largest = temp;
            }

        }
        //returns the largest minus the first to account for the index values of characters
        return largest - first + 1;
    }

    /**
     * A method that simply prints out the info for the adjacency matrix
     */
    public void printAdjMatrix() {
        //loops through each array in adjMatrix
        for (ArrayList<Double> array : adjMatrix) {
            //loops through each double in the array
            for (Double aDouble : array) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }


}
