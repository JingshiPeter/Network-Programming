//name: Yiqian Zhang and Jingshi Sun
//EID: yz6834 and js79735

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
// RBLL is immutable after creation

public class RBLLword{
	Set<String> nodes;
	Map<String,String> nodesLabel;
	Map<String, Set<String>> toSet;
	
	RBLLword(){
		this.toSet = new HashMap<String, Set<String>>();
		this.nodes = new HashSet<String>();
		this.nodesLabel = new HashMap<String,String>();
	}
	public boolean nodeExist(String name){
		return this.nodes.contains(name);
	}
	public void addNode(String name) {
		// TODO Auto-generated method stub
		nodes.add(name);
		nodesLabel.put(name,"w");
		Set<String> tmp = new HashSet<String>();
		toSet.put(name,tmp);
	}

	public void addEdge(String from, String to) {
		// TODO Auto-generated method stub
		Set<String> tmp = toSet.get(from);
		tmp.add(to);
		tmp = toSet.get(to);
		tmp.add(from);
	}

	public List<String> getNodes() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		for(String nodename : nodes){
			result.add(nodename);
		}
		return result;
	}
	public String getLabel(String input){
		return nodesLabel.get(input);
	}
	public void setLabel(String input, String label){
		nodesLabel.put(input, label);
	}
	public List<String> getSucc(String input) {
		// O(1) time;
		List<String> result = new ArrayList<String>();
		for(String succ : toSet.get(input)) result.add(succ);
		return result;
	}

}
