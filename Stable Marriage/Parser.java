import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Parser {

	Scanner scan;
	HashMap<Integer, Female> women;
	HashMap<Integer, Male> men;

	public Parser(String fileName) {
		File f = new File(fileName);
		try {
			scan = new Scanner(f);
			men = new HashMap<Integer, Male>();
			women = new HashMap<Integer, Female>();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND! GET TO THE CHOPPAH!");
			System.exit(0);
		}
	}

	public void readAll() {
		String begin = scan.nextLine();
		while (!(begin.charAt(0) == 'n')) {
			begin = scan.nextLine();
		}		
		while (scan.hasNext()) {
			String line = scan.nextLine();	
			if(line.equals(""))	{
				break;
			}
			String[]splittedLine = line.split(" ");
				
			int mId = Integer.parseInt(splittedLine[0]);
			// :TODO ta bort
//			System.out.println(mId + " " + name);

			String name = splittedLine[1];
			men.put(mId, new Male(mId, name));			
			
			
			
			line = scan.nextLine();
			splittedLine = line.split(" ");
			int wId = Integer.parseInt(splittedLine[0]);			
			// :TODO ta bort
//			System.out.println(wId + " " + name);
			
			name = splittedLine[1];
			women.put(wId, new Female(wId, name));
		}
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[]splittedLine = line.split(": ");
			int id = Integer.parseInt(splittedLine[0]);
			
			if (id % 2 == 0) {
				Female f = women.get(id);
				splittedLine = splittedLine[1].split(" ");
				for (int i = 0; i < splittedLine.length; i++) {
//					int temp = Integer.parseInt(splittedLine[i]);
//					System.out.println(temp);
					f.addPref(Integer.parseInt(splittedLine[i]));
				}
			}
			else	{
				Male m = men.get(id);
				splittedLine = splittedLine[1].split(" ");
				for (int i = 0; i < splittedLine.length; i++) {
//					int temp = Integer.parseInt(splittedLine[i]);
//					System.out.println(temp);
					m.addPref(Integer.parseInt(splittedLine[i]));
				}
			}
		}
	}
	
	public HashMap<Integer, Female> getFemales()	{
		return women;
	}
	
	public LinkedList<Male> getMales()	{
		int amountOfMen = men.size();
		LinkedList<Male> males = new LinkedList<Male>();
		for(int i = 1; i <= amountOfMen*2; i+=2){
			males.add(men.get(i));
		}
		return males;
	}
}