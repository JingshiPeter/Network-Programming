import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// RBLL is immutable after creation

public class RBLL implements NetWork {
	Map<String, Integer> nodeData;
	Map<String, List<String>> toList;
	Map<String,List<Integer>> dataList;
	
	RBLL(){
		this.toList = new HashMap<String, List<String>>();
		this.dataList = new HashMap<String, List<Integer>>();
		this.nodeData = new HashMap<String,Integer>();
	}
	
	@Override
	public void addNode(String name) {
		// TODO Auto-generated method stub
		List<String> tmp = new ArrayList<String>();
		toList.put(name,tmp);
		List<Integer> tmp2 = new ArrayList<Integer>();
		dataList.put(name,tmp2);
		nodeData.put(name, 0);
	}

	@Override
	public void addNode(String name, String attr, int val) {
		// TODO Auto-generated method stub
		List<String> tmp = new ArrayList<String>();
		toList.put(name,tmp);
		List<Integer> tmp2 = new ArrayList<Integer>();
		dataList.put(name,tmp2);
		nodeData.put(name, val);

	}

	@Override
	public void addEdge(String from, String to, String attr, int val) {
		// TODO Auto-generated method stub
		toList.get(from).add(to);
		dataList.get(from).add(val);

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
			for(String to : toList.get(from)){
				result.add(from + "->" + to);
			}
		}
		return result;
	}

	@Override
	public List<String> getPred(String input) {
		// TODO Auto-generated method stub
		//O(m*n)
		List<String> result = new ArrayList<String>();
		for(String from : toList.keySet()){
			for(String to : toList.get(from)){
				if(to == input) result.add(from);
			}
		}
		return result;
	}

	@Override
	public List<String> getSucc(String input) {
		// O(1) time;
		return toList.get(input);
		// TODO Auto-generated method stub
	}

	@Override
	public int getAttr(String node, String attr) {
		// TODO Auto-generated method stub
		return nodeData.get(node);
	}

	@Override
	public int getAttr(String from, String to, String attr) {
		// TODO Auto-generated method stub
		//O(n) time
		return dataList.get(from).get(toList.get(from).indexOf(to));
	}

	@Override
	public void setAttr(String node, String attr, int val) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttr(String from, String to, String attr, int val) {
		// TODO Auto-generated method stub

	}
}
