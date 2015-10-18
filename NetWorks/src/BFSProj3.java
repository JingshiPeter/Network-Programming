//name: Yiqian Zhang and Jingshi Sun
//EID: yz6834 and js79735

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
// The original BFS
public class BFSProj3 {
	LinkedList<String> process;
	Map<String,String> parents;
	RBLLword G;
	String start;
	String end;
	BFSProj3(RBLLword G, String start, String end){
		process = new LinkedList<String>();
		parents = new HashMap<String,String>();
		this.G = G;
		this.start = start;
		this.end = end;
	}

	public boolean nodeNotFound(RBLLword G){
		try{
			boolean startNotFound = !G.nodeExist(start);
			boolean endNotFound = !G.nodeExist(end);
			boolean sameWords = end.equals(start);
		
			if(startNotFound || endNotFound || sameWords){
				System.out.println(String.format("no word ladder can be found between %s and %s",start,end ));
				return true;
			}
		} catch (NullPointerException e){
			return true;
		}
		return false;
	}
	
	
	public void doInference(){
		
		if(nodeNotFound(G)){return;}
		for(String node : G.getNodes()){
			G.setLabel(node, "w");
		}
		process.add(start);
		
		boolean found = false;
		
		bigWhile:
			while(!process.isEmpty()){
				String current = process.remove();
				G.setLabel(current, "b");
				for(String n : G.toSet.get(current)){
					if(n.equals(end)) {
						parents.put(end,current);
						found = true;
						break bigWhile;
					}else{
						if(G.getLabel(n) == "w"){
							G.setLabel(n, "g");
							parents.put(n,current);
							process.add(n);
						}
						}
					}
				
			}
		if(found){
			Stack<String> result = new Stack<String>();
			
			String current = end;
			result.push(end);
			while(current != start){
				current = parents.get(current);
				result.push(current);
			}
			
			List<String> returned = new ArrayList<String>();
			while(!result.isEmpty()){
				returned.add(result.pop());
			}
			
			System.out.println(String.format("a %d-rung word ladder exists between %s and %s"
					,returned.size()-2,start,end));
			for (int i=0; i<returned.size(); i++){
				System.out.println("\t"+returned.get(i));
			}
			return;
		}
		System.out.println(String.format("no word ladder can be found between %s and %s",start,end ));
		
	}
	
}
