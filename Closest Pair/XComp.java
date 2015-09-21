import java.util.Comparator;

public class XComp implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		Double result = new Double(o1.getX() - o2.getX());
		return result.intValue();
	}

}
