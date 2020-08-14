package MasterCard.ProgrammingTest;

import java.util.ArrayList;

public class Node {
    public String label;
    public ArrayList<Node> adj;
    public Node(String label) {
        this.adj = new ArrayList<>();
        this.label = label;
    }
}
