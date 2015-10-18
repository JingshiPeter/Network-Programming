
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SearchAllPath {
	Stack<List<String>> process;
	Map<String,String> parents;
	NetWork G;
	String start;
	String terminate;
	SearchAllPath(NetWork G, String start, String terminate){
		process = new Stack<List<String>>();
		parents = new HashMap<String,String>();
		this.G = G;
		this.start = start;
		this.terminate = terminate;
	}
	public void doInference(){
		ArrayList<String> firstLabel = new ArrayList<String>();
		firstLabel.add(start);
		process.push(firstLabel);
		while(!process.isEmpty()){
			List<String> currentLabel = process.pop();
			String current = currentLabel.get(currentLabel.size()-1);
			Set<String> antiLoop = new HashSet<String>();
			for(String n : G.getSucc(current)){
				if (!(currentLabel.contains(n))){
					antiLoop.add(n);
				}
			}
			for(String n : antiLoop){
				if(n == terminate) {
					System.out.println(currentLabel);
				}else{
					List<String> nextLabel = new ArrayList<String>();
					for(String pre : currentLabel){
						nextLabel.add(pre);
					}
					nextLabel.add(n);
					process.push(nextLabel);
				}
				
			}
			
		}
		
	}
	
}

