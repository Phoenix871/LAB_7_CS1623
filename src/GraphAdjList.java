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
    private final List<List<AbstractMap.SimpleEntry<Character, Double>>> adjList;


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
                char fromNode = firstScanner.next().charAt(0); //to get an accurate index
                char toNode = firstScanner.next().charAt(0); //store simply as a character
                Double edgeWeight = firstScanner.nextDouble(); //not used right now but helps skip a character in the file
                //=============================================================

                if (!characters.contains(fromNode - 'A')) {
                    characters.add(fromNode - 'A');
                }
                if (!characters.contains(toNode - 'A')) {
                    characters.add(toNode - 'A');
                }
            }
            //=================================================================

            //need to find out how many lists to have in adjList
            int largest = characters.getFirst(); //keeps track of the 'largest' letter
            for (Integer i : characters) { //loops through the arraylist
                if (i > largest) {
                    largest = i;
                }
            }

            for (int i = 0; i <= largest; i++) {
                adjList.add(new ArrayList<>()); //adds a new list for every letter up to the largest
            }

            //Now to add the values============================================
            Scanner secondScanner = new Scanner(new FileReader(fName)); //New scanner for adding data

            while (secondScanner.hasNext()) {
                //All the relevant information for this current loop===========
                char fromNode = secondScanner.next().charAt(0); //to get an accurate index
                char toNode = secondScanner.next().charAt(0); //store simply as a character
                Double edgeWeight = secondScanner.nextDouble(); //not used right now but helps skip a character in the file
                //=============================================================

                adjList.get(fromNode - 'A').add(new AbstractMap.SimpleEntry<>(toNode, edgeWeight)); //adds the edge in one direction
                adjList.get(toNode - 'A').add(new AbstractMap.SimpleEntry<>(fromNode, edgeWeight)); //adds the edge in the other direction

            }

            //just to save some memory, good practice
            firstScanner.close();
            secondScanner.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Methods
    /**
     * A small method to simply print out the contents of the adjacency list
     */
    public void printAdjList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(((char) (i + 'A')) + ": " + adjList.get(i).toString());

            System.out.println();
        }
    }
}
