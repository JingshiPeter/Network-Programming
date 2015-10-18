public final class Tuple<X,Y> {
		public final X x;
		public final Y y;
		public Tuple(X x, Y y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return("edge " + x.toString() + "->" + y.toString());
		}
		
		public boolean equals(Tuple<X,Y> input){
			if (input.x == this.x && input.y == this.y) return true;
			return false;
		}
		
		public int hashCode(){
			if(x instanceof Integer && y instanceof Integer){
				return (int)x<<16 + (int)y;
			}
			return x.hashCode() + y.hashCode();
		}
}
