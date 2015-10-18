import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test_Networks {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node("A");
		a.setAttr("wegiht", 3);
		a.setAttr("cost", 5);
		System.out.println(a);
		Edge ac = new Edge("a","c");
		System.out.println(ac);
		NetWork mynw = new DOK();
		mynw.addEdge("start", "middle", "cost", 5);
		mynw.addEdge("middle", "end", "cost", 6);
		mynw.addEdge("middle2", "middle", "cost", 6);
		mynw.setAttr("start","time", 8);
		mynw.setAttr("end","time", 17);
//		System.out.println(mynw.getAttr("start", "time"));
//		System.out.println(mynw.getAttr("start", "middle", "cost"));
		System.out.println(mynw.getEdges().toString());
		System.out.println(mynw.getNodes().toString());
		System.out.println(mynw.getPred("middle"));
		String s = "This is a";
		String t = "This is a";
		
		
		Tuple<Integer,Integer> i = new Tuple<Integer, Integer>(2,2);
		Tuple<Integer,Integer> j = new Tuple<Integer, Integer>(2,2);
		
		Map<Tuple<Integer,Integer>,String> myMap = new HashMap<Tuple<Integer,Integer>,String>();
		Tuple<Integer,Integer> tmp = new Tuple<Integer,Integer>(2,3);
		myMap.put(tmp, "You will not retrieve this anymore");
		
		
		
		
		
		
		System.out.println(s.hashCode());
		System.out.println(t.hashCode());
		System.out.println(i.hashCode());
		System.out.println(j.hashCode());
		
		NetWork rbll = new FHMG();
		rbll.addNode("A");
		rbll.addNode("B");
		rbll.addNode("C");
		rbll.addNode("D");
		rbll.addNode("E");
		rbll.addNode("F");
		rbll.addNode("S");
		rbll.addNode("T");
		rbll.addEdge("S", "A", "cost", 8);
		rbll.addEdge("S", "B", "cost", 9);
		rbll.addEdge("S", "C", "cost", 12);
		rbll.addEdge("S", "D", "cost", 9);
		rbll.addEdge("C", "D", "cost", 9);
		rbll.addEdge("C", "B", "cost", 9);
		rbll.addEdge("B", "C", "cost", 9);
		rbll.addEdge("C", "E", "cost", 9);
		rbll.addEdge("D", "T", "cost", 9);
		rbll.addEdge("B", "E", "cost", 9);
		rbll.addEdge("E", "B", "cost", 9);
		rbll.addEdge("B", "T", "cost", 9);
		rbll.addEdge("A", "B", "cost", 9);
		rbll.addEdge("B", "A", "cost", 9);
		rbll.addEdge("A", "T", "cost", 9);
		rbll.addEdge("A", "F", "cost", 9);
//		System.out.println(rbll.getNodes());
//		System.out.println(rbll.getEdges());
//		System.out.println(rbll.getAttr("A","B","WTF"));
//		System.out.println(rbll.getSucc("A"));
//		System.out.println(rbll.getPred("A"));
		
		SearchAllPath solution = new SearchAllPath(rbll,"S","T");
		solution.doInference(); 
		Label nl = new Label("dog", Integer.MAX_VALUE);
		Label ol = new Label("cat", 88);
		
//		Scanner myScanner = new Scanner(System.in);
//		System.out.println("What is your name");
//		String name = myScanner.next();
//		String last = myScanner.next();
//		int age = myScanner.nextInt();
//		System.out.println("What is your name" + name + " " + last);
//		System.out.println(age);
		
		
		
		
		
		
	}

}
