import java.util.LinkedList;


public class Female {
	
	private String name;
	private LinkedList<Integer> prefs;
	private int id;
	private Male partner;
	
	public Female(int id, String name/*, LinkedList<Integer> prefs*/){
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
	
	public boolean didSheAcceptProposer(Male proposer, LinkedList<Male> singles){
		if (partner == null){
			partner = proposer;
			proposer.setPartner(this);
			return true;
		}
		for(Integer i : prefs){
			if(i == partner.id())	{
				return false;
			}
			else if(i == proposer.id())	{
				singles.add(partner);
				partner = proposer;
				proposer.setPartner(this);
				return true;
			}
		}
		return false;
	}
	
	public Male getPartner()	{
		return partner;
	}
	
	public void addPref(Integer id)	{
		prefs.add(id);
	}

}