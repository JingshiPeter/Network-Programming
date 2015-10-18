//name: Yiqian Zhang and Jingshi Sun
//EID: yz6834 and js79735

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class Main {
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
			
		} catch(IOException e){
			
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
		for(int j = 0; j < process.size(); j++){
			String current = process.get(j);
			for(String node : process){
				int count = 0;
				for(int i = 0; i<5; i++){
					if(node.charAt(i) != current.charAt(i)) count++;
				}
				if (count == 1) {
					G.addEdge(current,node);
				}
			}
		}
	}
	public static void main(String[] args) {
		RBLLword G = new RBLLword();
		constructGraph(G);
		boolean quit = false;
		

		Scanner scanner = new Scanner(System.in);
		BFSProj3 solution = null;
		
/*		BFSProj3 solution = new BFSProj3(G,"pocks","doser");
		solution.doInference();
		solution = new BFSProj3(G,"pocks","cites");
		solution.doInference();
		solution = new BFSProj3(G,"bolls","qualm");
		solution.doInference();
		solution = new BFSProj3(G,"tells","sixty");
		solution.doInference();
//		BFSProj3 solution = new BFSProj3(G,"tells","kerns");
//		BFSProj3 solution = new BFSProj3(G,"dowse","banns");
//		BFSProj3 solution = new BFSProj3(G,"dowse","raspy");
//		BFSProj3 solution = new BFSProj3(G,"scuse","sully");
//		BFSProj3 solution = new BFSProj3(G,"scuse","ticks");
//		BFSProj3 solution = new BFSProj3(G,"pouch","snoop");
		solution = new BFSProj3(G,"pouch","sandy");
		solution.doInference();*/
		
		while(!quit){
			String text= scanner.nextLine();
			text = text.replaceAll("^\\s+","");
			if(text.charAt(0) == '/'){
				text = text.replaceAll("\\s+","");
				if(text.equals("/quit")){
					quit = true;
				}else{
					System.out.println("invalid command " + text);
				}
				
			}else{
				text.trim();
				String[] words = text.split("[\\s]");
				solution = new BFSProj3(G,words[0],words[words.length-1]);
				solution.doInference();
			}
			
			
		} 
		scanner.close();	
	}

}
