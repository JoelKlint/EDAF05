import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {

  private ArrayList<String> allTowns;
  private HashMap<String, ArrayList<Edge>> allEdges;

  public Parser(String fileName) {
    allTowns = new ArrayList<String>();
    allEdges = new HashMap<String, ArrayList<Edge>>();
    File file = new File(fileName);
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found");
      System.exit(0);
    }
    String s;

    //n+m
    while(scan.hasNext()) {
      s = scan.nextLine();

      //n (antal städer)
      if(s.charAt(s.length()-1) != ']') {
        if(s.charAt(0) == '"')  {
          s = s.substring(1, s.length()-1);
        }
        allTowns.add(s);
      }

      //m
      else  {
        s = s.replace("\"", "");
        String[] splittedTowns = s.split("--| \\[");
        splittedTowns[2] = splittedTowns[2].substring(0, splittedTowns[2].length()-1);
        Edge edge = new Edge(splittedTowns);

        ArrayList<Edge> temp = allEdges.get(edge.town1());
        if(temp == null)  {
          temp = new ArrayList<Edge>();
        }
        temp.add(edge);
        allEdges.put(edge.town1(), temp);

        temp = allEdges.get(edge.town2());
        if(temp == null)  {
          temp = new ArrayList<Edge>();
        }
        temp.add(edge);
        allEdges.put(edge.town2(), temp);
      }
    }
  }

  public ArrayList<String> getTowns() {
    return allTowns;
  }

  public HashMap<String, ArrayList<Edge>> getEdges() {
    return allEdges;
  }

}
