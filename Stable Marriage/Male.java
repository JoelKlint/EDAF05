import java.util.LinkedList;


public class Male {
	
	private String name;
	private LinkedList<Integer> prefs;
	private int id;
	private Female partner;
	
	public Male(int id, String name/*, LinkedList<Integer> prefs*/){
		this.name = name;
		prefs = new LinkedList<Integer>();
		this.id = id;
		this.partner = null;
	}
	
	public String getName(){
		return name;
	}
	
	public int id(){
		return id;
	}
	
	public int getPrefWoman(){
		if (prefs.size() == 0){
			return -1;
		}
		return prefs.pop();
	}
	
	public void setPartner(Female woman){
		partner = woman;
	}
	
	public Female getPartner()	{
		return partner;
	}
	
	public void addPref(Integer id)	{
		prefs.add(id);
	}
}