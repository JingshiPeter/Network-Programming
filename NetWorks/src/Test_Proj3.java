import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test_Proj3 {
	public static Set<String> hashDictionary(){
		Set<String> HashSet = new HashSet<String>();
		BufferedReader bufferedReader = null;
		
		try{
	    File file = new File("assn3words.dat");
	    bufferedReader = new BufferedReader(new FileReader(file));
	    		    
	    String line = bufferedReader.readLine();
	    while(line != null){
	    	//line = line.replaceAll("\\*.*", ""); for different sizes words
	    	if(line.charAt(0) == '*'){
		    	line = bufferedReader.readLine();	
	    		continue;
	    	}else{
	    		line = line.substring(0,5);
	    	}
	    	HashSet.add(line);
	    	line = bufferedReader.readLine();		    	
	    }
		bufferedReader.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		return HashSet;
	}

	public static void constructGraph(RBLLword G){
		List<String> process = new ArrayList<String>();
		Set<String> nodes = hashDictionary();
		for(String node : nodes){
			G.addNode(node);
		}
		for(String node : G.nodes){
			process.add(node);
		}
		System.out.println(G.getNodes());
		System.out.println("Finished adding nodes");
		for(int j = 0; j < process.size(); j++){
			String current = process.get(j);
			for(String node : process){
				int count = 0;
				for(int i = 0; i<5; i++){
					if(node.charAt(i) != current.charAt(i)) count++;
				}
				if (count == 1) {
					G.addEdge(current,node);
//					System.out.println(current + "->" + node);
//					System.out.println(current + G.toSet.get(current));
				}
			}
		}
		System.out.println("Finished adding edges");
		for(String node : G.nodes){
			System.out.println(node + " " + G.toSet.get(node));
		}
		System.out.println(G.getNodes().size());
		System.out.println(G.nodes.size());
		System.out.println(G.toSet.size());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RBLLword G = new RBLLword();
		constructGraph(G);
		System.out.println(G.toSet.get("zooks"));
		
		DFSProj3 solution = new DFSProj3(G,"pocks","doser");
		solution.doInference();
		solution = new DFSProj3(G,"pocks","cites");
		solution.doInference();
		solution = new DFSProj3(G,"bolls","qualm");
		solution.doInference();
		solution = new DFSProj3(G,"tells","sixty");
		solution.doInference();
//		DFSProj3 solution = new DFSProj3(G,"tells","kerns");
//		DFSProj3 solution = new DFSProj3(G,"dowse","banns");
//		DFSProj3 solution = new DFSProj3(G,"dowse","raspy");
//		DFSProj3 solution = new DFSProj3(G,"scuse","sully");
//		DFSProj3 solution = new DFSProj3(G,"scuse","ticks");
//		DFSProj3 solution = new DFSProj3(G,"pouch","snoop");
		solution = new DFSProj3(G,"pouch","sandy");
		solution.doInference();
		
	}

}
