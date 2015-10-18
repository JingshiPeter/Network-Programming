import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFS {
	LinkedList<String> process;
	Map<String,String> parents;
	NetWork G;
	String start;
	BFS(NetWork G, String start){
		process = new LinkedList<String>();
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
		process.add(start);
		while(!process.isEmpty()){
			String current = process.remove();
			for(String n : G.getSucc(current)){
				if (G.getAttr(n, "distance") == Integer.MAX_VALUE){
					G.setAttr(n, "distance", G.getAttr(current,"distance")+1);
					System.out.println(n + " search parent is " + current);
					System.out.println(n + " distance is " + G.getAttr(n,"distance"));
					G.setAttr(n, "parent", current.hashCode());
					process.add(n);
				}
			}
			
		}
		
	}
	
}
