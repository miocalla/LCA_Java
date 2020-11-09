
public class DAG <Value> {
	
	private class Node {
		
		private Value val;
		private Node[] successors;
		
		public Node(Value val) {
			this.val = val;
		}
		
	}
	
	private Node[] nodeList = new DAG.Node[0];
}
