import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

    public static void main (String[]args) {
      //n+m
      Parser parser = new Parser(args[0]);
      HashMap<String, ArrayList<Edge>> allEdges = parser.getEdges();
      ArrayList<String> allTowns = parser.getTowns();

      HashSet<String> visited = new HashSet<String>();
      HashSet<Edge> visitedEdges = new HashSet<Edge>();
      PriorityQueue<Edge> reachable = new PriorityQueue<Edge>();

      int totalDistance = 0;

      visited.add(allTowns.get(0)); // Start town index
      reachable.addAll(allEdges.get(allTowns.get(0))); // Start town index
      //n
      while(visited.size() < allTowns.size())  {
        //log(n)
        Edge minEdge = reachable.poll();
        //m-(n-1)
        while(visited.contains(minEdge.town1()) && visited.contains(minEdge.town2()))  {
          visitedEdges.add(minEdge);
          //log(n)
          minEdge = reachable.poll();
        }
        if(visited.contains(minEdge.town1())) {
          visited.add(minEdge.town2());
          //sorteras varje gång
          reachable.addAll(allEdges.get(minEdge.town2()));
        }else{
          visited.add(minEdge.town1());
          //sorteras varje gång
          reachable.addAll(allEdges.get(minEdge.town1()));
        }
        visitedEdges.add(minEdge);
        reachable.removeAll(visitedEdges);
        totalDistance += minEdge.distance();
      }

      System.out.println(totalDistance);
  }
}
