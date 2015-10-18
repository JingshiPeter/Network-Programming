import java.util.HashMap;
import java.util.Map;

public class Node {
	private final String name;
	private Map<String, Integer> attrs;
	Node(String name){
		this.name = name;
		this.attrs = new HashMap<String, Integer>();
	}
	public int getAttr(String attr){
		return this.attrs.get(attr);
	}
	public void setAttr(String attr, int value){
		this.attrs.put(attr, value);
	}
	public String getName(){
		return this.name;
	}
	public void setAttr(Map<String, Integer> input){
		this.attrs.putAll(input);
	}
	public String toString(boolean info){
		if (info) return("Node " + name + attrs.toString());
		return("Node "+ name);
	}
	public String toString(){
		return("Node "+ name);
	}
}
