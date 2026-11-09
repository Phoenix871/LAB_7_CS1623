import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphAdjMatrix {
    //Attributes
    private ArrayList<ArrayList<Double>> adjMatrix;

    //Constructors
    /**
     * A constructor that builds a graph using an Adjacency matrix from a given file
     * @param fName The name of the file being read
     */
    public GraphAdjMatrix(String fName) {
        try {
            //Create a FileReader and a Scanner to be able to read the file in bits and pieces
            FileReader reader = new FileReader(fName);
            Scanner scanner = new Scanner(reader);

            //Need to initialize adjMatrix to have all zeros
            System.out.println(findLargestChar(scanner));


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

        while (s.hasNext()) {
            int temp = s.next().charAt(0);

            if (temp > largest) {
                largest = temp;
            }

        }

        return largest - first;
    }


}
