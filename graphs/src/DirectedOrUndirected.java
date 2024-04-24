import java.util.ArrayList;

public class DirectedOrUndirected {
    //determines if the input is a directed graph

    public static boolean directedOrUndirected(int[][] input) {

        //the num of rows and the num of columns has to be the same to represent an adjacency matrix
        if(input.length != input[0].length) {
            return false;
        }

        //checks the symmetry of the matrix
        for(int i = 0; i<input.length; i++) {
            for(int j = 0; j<i; j++) {
                if(input[i][j] != input[j][i]) {
                    //if there are any differences in the symmetry of the matrix then it is
                    //not a directed graph
                    return true;
                }
            }
        }
        //if it is perfectly symmetric then it is an undirected graph
        return false;

    }


    public static void main(String[] args) {
        //example of one that is an undirected graph
        int[][] input = {
                {0,1,1},
                {1,0,1},
                {1,1,0},
        };
        //example of one that is directed
        int[][] input2 = {
                {0,1,0},
                {1,1,1},
                {1,1,0},
        };

        boolean result = directedOrUndirected(input);
        boolean result2 = directedOrUndirected(input2);
        System.out.println(result);
        System.out.println(result2);


    }
}
