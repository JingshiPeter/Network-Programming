import java.util.HashMap;
import java.util.Map;

public class Edge {
	private final String from;
	private final String to;
	private Map<String,Integer> attrs;
	Edge(String from, String to){
		this.from = from;
		this.to = to;
		attrs = new HashMap<String,Integer>();
	}
	Edge(String from, String to, String attr, int val){
		this.from = from;
		this.to = to;
		attrs = new HashMap<String,Integer>();
		setAttr(attr,val);
	}
	Edge(String from, String to, Map<String,Integer> input){
		this.from = from;
		this.to = to;
		attrs = new HashMap<String,Integer>();
		setAttr(input);
	}
	public int getAttr(String attr){
		return this.attrs.get(attr);
	}
	public void setAttr(String attr, int value){
		this.attrs.put(attr, value);
	}
	public String getName(){
		return(this.from.toString() + this.to.toString());
	}
	public void setAttr(Map<String, Integer> input){
		this.attrs.putAll(input);
	}
	public String toString(){
		return("Edge " + this.from + "->" +this.to);
	}
	public boolean equals(String from, String to){
		if (from == this.from && to == this.to) return true;
		return false;
	}
}
