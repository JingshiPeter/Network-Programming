
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
// The original DFS
public class DFSProj3SingleDirected {
	Stack<String> process;
	Map<String,String> parents;
	RBLLword G;
	String start;
	String end;
	DFSProj3SingleDirected(RBLLword G, String start, String end){
		process = new Stack<String>();
		parents = new HashMap<String,String>();
		this.G = G;
		this.start = start;
		this.end = end;
	}
	public int wordDistanceInverse(String a, String b){
		int dist = 0;
		for(int i=0; i < 5; i++){
			if(a.charAt(i) == b.charAt(i)) dist++;
		}
		return dist;
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
				Queue<Label> tmp = new PriorityQueue<Label>();
				for(String n : G.getSucc(current)){
					if(n == end) {
						parents.put(end,current);
						found = true;
						break bigWhile;
					}else{
						if(G.getLabel(n) == "w"){
							G.setLabel(n, "g");
							parents.put(n,current);
							tmp.add(new Label(n,wordDistanceInverse(n,end)));
							System.out.println(n + " is pushed to the stack");
						}
						}
					}
				while(!tmp.isEmpty()){
					process.add(tmp.poll().name);
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
			System.out.println(returned);
		}
		
	}
	
}
