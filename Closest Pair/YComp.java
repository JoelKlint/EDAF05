import java.util.Comparator;

public class YComp implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		Double result = new Double(o1.getY() - o2.getY());
		return result.intValue();
	}

}
