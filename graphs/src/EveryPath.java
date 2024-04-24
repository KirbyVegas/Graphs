
import java.util.ArrayList;
import java.util.Collection;

public class EveryPath {

    public static void everyPath(Vertex u, Vertex w, int currLength, Graph g, ArrayList<Vertex> list, ArrayList<Vertex> visited) {
        if(currLength == 5 || u.equals(w)) {
            System.out.println("Path:");
            //prints out all the vertexes in the path
            for(Vertex vertex: list) {
                System.out.print(vertex.getLabel() +" ");
            }
            System.out.println("\n");
            return;
        }

        if(currLength<5) {
            Collection<Edge> uEdges = g.getEdgesFrom(u);
            //looks at every edge that u is going to

            for (Edge edge : uEdges) {
                Vertex v = edge.toVertex;
                if (!visited.contains(v)) {
                    list.add(v);
                    visited.add(v);
                    everyPath(v, w, currLength + 1, g, list, visited);
                    list.remove(list.size() - 1);
                    visited.remove(v);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        ArrayList<Vertex> list = new ArrayList<>();
        ArrayList<Vertex> visited = new ArrayList<>();


        Vertex v0 = g.addVertex("0");
        Vertex v1 = g.addVertex("1");
        Vertex v2 = g.addVertex("2");
        Vertex v3 = g.addVertex("3");
        Vertex v4 = g.addVertex("4");
        g.addDirectedEdge(v0, v1, 1);
        g.addDirectedEdge(v0, v3, 1);
        g.addDirectedEdge(v1, v2, 1);
        g.addDirectedEdge(v2, v4, 1);
        g.addDirectedEdge(v2, v1, 1);
        g.addDirectedEdge(v3, v2, 1);
        g.addDirectedEdge(v3, v4, 1);

        list.add(v0);
        visited.add(v0);
        everyPath(v0,v4,0,g,list, visited);

    }
}