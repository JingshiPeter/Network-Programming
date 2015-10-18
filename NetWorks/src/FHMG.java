import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//This is a full hashmap graph
//The idea is simple fast;
public class FHMG implements NetWork {
	Map<String, Map<String, Integer>> nodeData;
	Map<String, Map<String, Integer>> fromList;
	Map<String, Map<String, Integer>> toList;
	
	FHMG(){
		this.toList = new HashMap<String, Map<String, Integer>>();
		this.fromList = new HashMap<String, Map<String, Integer>>();
		this.nodeData = new HashMap<String,Map<String, Integer>>();
	}
	@Override
	public void addNode(String name) {
		// TODO Auto-generated method stub
		Map<String,Integer> tmp = new HashMap<String, Integer>();
		fromList.put(name,tmp);
		Map<String,Integer> tmp2 = new HashMap<String, Integer>();
		toList.put(name,tmp2);
		nodeData.put(name,  new HashMap<String, Integer>());
	}

	@Override
	public void addNode(String name, String attr, int val) {
		// TODO Auto-generated method stub
		Map<String,Integer> tmp = new HashMap<String, Integer>();
		fromList.put(name,tmp);
		Map<String,Integer> tmp2 = new HashMap<String, Integer>();
		toList.put(name,tmp2);
		nodeData.put(name,  new HashMap<String, Integer>());
		nodeData.get(name).put(attr, val);

	}

	@Override
	public void addEdge(String from, String to, String attr, int val) {
		// TODO Auto-generated method stub
		toList.get(from).put(to,val);
		fromList.get(to).put(from,val);

	}

	@Override
	public List<String> getNodes() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		for(String nodename : nodeData.keySet()){
			result.add(nodename);
		}
		return result;
	}

	@Override
	public List<String> getEdges() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		for(String from : toList.keySet()){
			for(String to : toList.get(from).keySet()){
				result.add(from + "->" + to);
			}
		}
		return result;
	}

	@Override
	public List<String> getPred(String input) {
		// O(1) time;
		List<String> result = new ArrayList<String>();
		for(String pred : fromList.get(input).keySet()) result.add(pred);
		return result;
		// TODO Auto-generated method stub
	}

	@Override
	public List<String> getSucc(String input) {
		// O(1) time;
		List<String> result = new ArrayList<String>();
		for(String succ : toList.get(input).keySet()) result.add(succ);
		return result;
		// TODO Auto-generated method stub
	}

	@Override
	public int getAttr(String node, String attr) {
		// TODO Auto-generated method stub
		return nodeData.get(node).get(attr);
	}

	@Override
	public int getAttr(String from, String to, String attr) {
		// TODO Auto-generated method stub
		//O(1) time
		return toList.get(from).get(to);
	}

	@Override
	public void setAttr(String node, String attr, int val) {
		// TODO Auto-generated method stub
		nodeData.get(node).put(attr, val);

	}

	@Override
	public void setAttr(String from, String to, String attr, int val) {
		// TODO Auto-generated method stub
		System.out.println("setAttr for edges is not supported");
	}

}
