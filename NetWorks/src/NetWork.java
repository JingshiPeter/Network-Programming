import java.util.List;

public interface NetWork {
	
	void addNode(String name);
	void addNode(String name, String attr, int val);
	void addEdge(String from, String to, String attr, int val);
	
	List<String> getNodes();
	List<String> getEdges();
	List<String> getPred(String input);
	List<String> getSucc(String input);
	
	int getAttr(String node, String attr);
	int getAttr(String from, String to, String attr);
	void setAttr(String node, String attr, int val);
	void setAttr(String from, String to, String attr, int val);
	
}
