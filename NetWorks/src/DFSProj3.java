
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
// The original DFS
public class DFSProj3 {
	Stack<String> process;
	Map<String,String> parents;
	RBLLword G;
	String start;
	String end;
	DFSProj3(RBLLword G, String start, String end){
		process = new Stack<String>();
		parents = new HashMap<String,String>();
		this.G = G;
		this.start = start;
		this.end = end;
	}
	
	public void doInference(){
		for(String node : G.getNodes()){
			G.setLabel(node, "w");
		}
		process.push(start);
		
		boolean found = false;
		
		bigWhile:
			while(!process.isEmpty()){
				String current = process.pop();
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
							process.push(n);
//							System.out.println(n + " is pushed to the stack");
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
			int netLength = returned.size()-2;
			System.out.println("a " + netLength + "-rung word ladder exists between " + start + " and " + end);
			for(String each : returned) System.out.println("	" + each);
			return;
		}
		System.out.println("no word ladder can be found between "+ start +" and " + end);
		
	}
	
}
