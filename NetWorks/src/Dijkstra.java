
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
	Queue<Label> process;
	Map<String,String> parents;
	NetWork G;
	String start;
	Dijkstra(NetWork G, String start){
		process = new PriorityQueue<Label>();
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
		process.add(new Label(start,0));
		while(!process.isEmpty()){
			String current = process.remove().name;
			int predLabel = G.getAttr(current, "distance");
			for(String n : G.getSucc(current)){
				int label = G.getAttr(n,"distance");
				int newLabel = predLabel + G.getAttr(current, n,"cost");
				if (label == Integer.MAX_VALUE || newLabel < label){
					G.setAttr(n, "distance", newLabel);
					System.out.println(n + " search parent is " + current);
					System.out.println(n + " distance is " + G.getAttr(n,"distance"));
					G.setAttr(n, "parent", current.hashCode());
					process.add(new Label(n,newLabel));
				}
			}
			
		}
		
	}
	
}
