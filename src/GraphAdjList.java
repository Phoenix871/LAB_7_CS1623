import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Carter Jorgensen
 * Date: 11 / 09 / 2026
 * Purpose: To create a class that can model a graph using a adjancency list
 */
public class GraphAdjList {
    //Attributes (gonna try List's for this one)
    private final List<List<AbstractMap.SimpleEntry<Integer, Double>>> adjList;


    //Constructors
    public GraphAdjList(String fName) {
        try {
            adjList = new ArrayList<>();

            //What will read the file the first time through
            Scanner firstScanner = new Scanner(new FileReader(fName));

            //An arraylist to keep track of the characters that show up
            ArrayList<Integer> characters = new ArrayList<Integer>();

            //A loop to run through the whole file=============================
            while (firstScanner.hasNext()) {
                //All the relevant information for this current loop===========
                int fromNode = firstScanner.next().charAt(0) - 'A'; //to get an accurate index
                int toNode = firstScanner.next().charAt(0) - 'A'; //ditto ^
                Double edgeWeight = firstScanner.nextDouble(); //not used right now but helps skip a character in the file
                //=============================================================

                if (!characters.contains(fromNode)) {
                    characters.add(fromNode);
                }
                if (!characters.contains(toNode)) {
                    characters.add(toNode);
                }
            }
            //=================================================================

            adjList.add;

            //Now to add the values============================================
            Scanner secondScanner = new Scanner(fName); //New scanner for adding data

            while (s)





        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Methods


}
