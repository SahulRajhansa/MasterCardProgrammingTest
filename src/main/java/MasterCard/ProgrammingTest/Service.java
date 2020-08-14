package MasterCard.ProgrammingTest;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    Graph g;
    HashMap<String,Integer> set;

    public void createGraph() throws IOException {
        Path path = Paths.get("Routes.txt");
        set = new HashMap<String, Integer>();
        List<String> fileContents = Files.readAllLines(path);
        int i = 0;
        for (String d:fileContents
        ) {
            String[] s  = d.split(",");
            for (String p: s
            ) {
                p.replace(',',' ');
                if(!p.equals("")){
                    if(!set.containsKey(p))
                        set.put(p,i++);
                }
            }
        }
        g = new Graph(set.size());
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        g.addEdge(4, 5);
    }
    boolean boom(int source, int destination){
        g.DFS(source,destination);
        return g.flag;
    }

}



