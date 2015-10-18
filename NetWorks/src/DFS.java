import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DFS {
	Stack<String> process;
	Map<String,String> parents;
	NetWork G;
	String start;
	DFS(NetWork G, String start){
		process = new Stack<String>();
		parents = new HashMap<String,String>();
		this.G = G;
		this.start = start;
	}
	public void doInference(){
		for(String node : G.getNodes()){
			G.setAttr(node, "distance", Integer.MAX_VALUE);
			G.setAttr(node, "parent", 0);
		}
		G.setAttr(start,"distance", 0);
		process.push(start);
		while(!process.isEmpty()){
			String current = process.pop();
			for(String n : G.getSucc(current)){
				if (G.getAttr(n, "distance") == Integer.MAX_VALUE){
					G.setAttr(n, "distance", G.getAttr(current,"distance")+1);
					System.out.println(n + " search parent is " + current);
					System.out.println(n + " distance is " + G.getAttr(n,"distance"));
					G.setAttr(n, "parent", current.hashCode());
					process.push(n);
				}
			}
			
		}
		
	}
	
}
