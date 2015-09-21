import java.lang.ClassCastException;

public class Edge implements Comparable{

  private String town1;
  private String town2;
  private int distance;

  public Edge(String[] info) {
    this.town1 = info[0];
    this.town2 = info[1];
    this.distance = Integer.parseInt(info[2]);
  }

  public String town1() {
    return town1;
  }

  public String town2() {
    return town2;
  }

  public int distance() {
    return distance;
  }

  public int compareTo(Object o)  {
    if(o instanceof Edge) {
      return distance - ((Edge)o).distance();
    }
    else  {
      throw new ClassCastException();
    }
  }
}
