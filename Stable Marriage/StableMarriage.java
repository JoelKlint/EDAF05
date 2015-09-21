import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class StableMarriage {
	public static void main(String[] args) {
		String fileName = null;
		if(args.length != 0)	{
			fileName = args[0];
		}
		else	{
			System.out.println("Please insert filename");
			System.exit(0);
		}
		
		Parser p = new Parser(fileName);
		p.readAll();
		HashMap<Integer, Female> females = p.getFemales();
		LinkedList<Male> males = p.getMales();
		LinkedList<Male> singles = new LinkedList<Male>();
		
		Iterator<Male> it = males.iterator();
		while(it.hasNext())	{
			singles.add(it.next());
		}
		
		while(!singles.isEmpty())	{
			Male proposer = singles.pop();			
			while(!females.get(proposer.getPrefWoman()).didSheAcceptProposer(proposer, singles))	{
			}			
		}
		for(Male m : males)	{
			System.out.println(m.getName() + " -- " + m.getPartner().getName());
		}
		
	}
}