import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Tuple is an object and each new instance have different HashCode()
// Two tuple with same Strings hash to different HashCode, so HashMap doesn't work

public class DOK implements NetWork{
	Map <String,Map<String,Integer>> myNodes;
	Map<Tuple<String, String>,Map<String,Integer>> myEdges;
	
	DOK(){
		myEdges = new HashMap<Tuple<String, String>,Map<String,Integer>>();
		myNodes = new HashMap<String,Map<String,Integer>>();
	}
	@Override
	public void addNode(String name) {
		Map<String,Integer> emptyMap = new HashMap<String,Integer>();
		myNodes.put(name,emptyMap);
		
	}
	@Override
	public void addNode(String name, String attr, int val) {
		Map<String,Integer> tmp = new HashMap<String,Integer>();
		tmp.put(attr, val);
		myNodes.put(name,tmp);
		
	}
	@Override
	public void addEdge(String from, String to, String attr, int val) {
		if(!myNodes.containsKey(from)){
			Map<String, Integer> tmp1 = new HashMap<String,Integer>();
			myNodes.put(from,tmp1);
		}
		if(!myNodes.containsKey(to)){
			Map<String, Integer> tmp2 = new HashMap<String,Integer>();
			myNodes.put(from,tmp2);
		}
		Tuple<String,String> edgeName = new Tuple<String,String>(from,to);
		Map<String, Integer> attrs = new HashMap<String, Integer>();
		attrs.put(attr, val);
		myEdges.put(edgeName,attrs);
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<String> getNodes() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		for(String nodename : myNodes.keySet()) result.add(nodename+ myNodes.get(nodename).toString());
		return result;
	}
	@Override
	public List<String> getEdges() {
		List<String> result = new ArrayList<String>();
		for(Tuple<String,String> edgename : myEdges.keySet()) result.add(edgename.toString() + myEdges.get(edgename).toString());
		return result;
	}
	@Override
	public List<String> getPred(String input) {
		// TODO Auto-generated method stub
		// O(m) time, iterate though all edges
		List<String> result = new ArrayList<String>(); 
		if(myNodes.containsKey(input)){
			for(Tuple<String,String> edge : myEdges.keySet()){
				if(edge.y == input) result.add(edge.x);
			}
			return result;
		}
		return null;
	}
	@Override
	public List<String> getSucc(String input) {
		// TODO Auto-generated method stub
		// O(m) time, iterate though all edges
		List<String> result = new ArrayList<String>(); 
		if(myNodes.containsKey(input)){
			for(Tuple<String,String> edge : myEdges.keySet()){
				if(edge.x == input) result.add(edge.y);
			}
			return result;
		}
		return null;
	}
	@Override
	public int getAttr(String node, String attr) {
		// TODO Auto-generated method stub
		//O(1) time
		return myNodes.get(node).get(attr);
	}
	@Override
	public int getAttr(String from, String to, String attr) {
		// TODO Auto-generated method stub
		//O(1) time
		Tuple<String,String> tmp = new Tuple<String,String>(from,to);
		return myEdges.get(tmp).get(attr);
	}
	@Override
	public void setAttr(String node, String attr, int val) {
		// TODO Auto-generated method stub
		//O(1) time
		if(myNodes.containsKey(node)) {
			myNodes.get(node).put(attr, val);
			return;
		}
		Map<String, Integer> tmp = new HashMap<String,Integer>();
		tmp.put(attr, val);
		myNodes.put(node, tmp);
		
	}
	@Override
	public void setAttr(String from, String to, String attr, int val) {
		// TODO Auto-generated method stub
		Tuple<String, String> tmp = new Tuple<String,String>(from,to);
		if(myEdges.containsKey(tmp)) myEdges.get(tmp).put(attr, val);
		Map<String, Integer> new_attr = new HashMap<String,Integer>();
		new_attr.put(attr, val);
		myEdges.put(tmp, new_attr);
	}
}
