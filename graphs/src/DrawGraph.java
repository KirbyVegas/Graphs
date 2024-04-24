import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.file.*;
import org.graphstream.ui.layout.*;
import java.util.HashMap;

public class DrawGraph {



    //Incomplete
    public static void drawGraph(String input) {

        //new graph to hold the nodes
        SingleGraph graph = new SingleGraph("New Graph");
        HashMap<Character, Integer> node = new HashMap<>();

        //methods to make the input into just letters and numbers so we can iterate through it
        input = input.replace(" ", "");
        input = input.replace("(", "");
        input = input.replace(")", "");
        input = input.replace(",", "");


        //for loop to add each letter as a vertex and each number as an edge
        for(int i = 0; i <input.length(); i = i+2) {
            for(int j = 1; j<input.length(); j= j+2) {
                node.put(input.charAt(i), Integer.parseInt(String.valueOf(input.charAt(j))));
            }
        }

        //for each character in the hashmap, make it into a node and add it to the graph
        for(Character c : node.keySet()) {
            Node n = graph.addNode(String.valueOf(c));

            //get the integer associated with the vertex so we can compute what it is connected to
            int index = node.get(c);
            //the index that we get from going forward in the array, which we get by taking the length and adding the number, and if it is
            //more than the length of the array we take the remainder
            int endIndexForward = (input.length() + index - 1) % input.length();;
            int endIndexBackward = (index + 1) % input.length();
//            int numOfNodes = input.length()/2;
//            if(index + index < numOfNodes) {
//                n.setAttribute(c, );
//            }

            //something I tried from the documentation, but not really sure what parameter means what
            //graph.addEdge(String.valueOf(input.charAt(endIndexForward)), String.valueOf(c), String.valueOf(input.charAt(endIndexForward)), true);
            //graph.addEdge(String.valueOf(input.charAt(endIndexBackward)), String.valueOf(c), String.valueOf(input.charAt(endIndexBackward)), true);


        }

        //graph.display();

    }



    public static void main(String[] args) {
        //take this input and put it into vertices and edges
        String input = "(I,2) , (A, 5) , (E, 4) , (F,1) , (T, 2) , (S, 3)";

        drawGraph(input);
    }
}
