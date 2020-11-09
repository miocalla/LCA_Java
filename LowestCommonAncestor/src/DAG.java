
public class DAG <Value> {
	
	private class Node {
		
		private Value val;
		private Node[] successors;
		
		public Node(Value val) {
			this.val = val;
		}
		
	}
	
	private Node[] nodeList = new DAG.Node[0];
	
	private int size() {
		return nodeList.length;
	}
	
	public boolean isEmpty() {
		
		if (size()==0) {
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean contains(Value val)
	{
		boolean valueInList = false;
		for (int i = 0; i < nodeList.length; i++)
		{
			if(nodeList[i].val == val)
			{
				valueInList = true;
				break;
			}
		}
		return valueInList;
	}
}
