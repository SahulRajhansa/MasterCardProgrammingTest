package MasterCard.ProgrammingTest;

public class GraphAjdacencyMatrix {
    int vertex;
    int matrix[][];

    public GraphAjdacencyMatrix(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination) {
        //add edge
        matrix[source][destination] = 1;

        //add bak edge for undirected graph
        matrix[destination][source] = 1;
    }

}