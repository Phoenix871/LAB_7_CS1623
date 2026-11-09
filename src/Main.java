import java.io.File;

/**
 * @author Carter Jorgensen
 * Date: 11 / 08 / 2026
 * Purpose: A main class to run my code
 */
public class Main {
    public static void main(String[] args) {


        GraphAdjMatrix g = new GraphAdjMatrix("src/Files/Test.txt");

        g.printAdjMatrix();
    }
}
