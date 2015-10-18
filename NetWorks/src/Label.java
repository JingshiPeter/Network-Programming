import java.util.HashSet;
import java.util.Set;

public class Label implements Comparable<Label> {
		Set<String> visited;
		String name;
		int val;
		
		Label(String name, int val){
			this.name = name;
			this.val = val;
		}
		
		Label(String name){
			this.visited = new HashSet<String>();
			visited.add(name);
		}
		
		@Override
		public int compareTo(Label o) {
			if(this.val == Integer.MAX_VALUE && o.val == Integer.MAX_VALUE) return 0;
			if(this.val == Integer.MAX_VALUE) return 1;
			if(o.val == Integer.MAX_VALUE) return -1;
			if(o.val == this.val) return 0;
			if(this.val - o.val > 0) return 1;
			return -1;
		}
		
}
