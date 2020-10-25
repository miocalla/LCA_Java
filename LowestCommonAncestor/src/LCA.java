import java.util.ArrayList; 
import java.util.List; 

public class LCA <Key extends Comparable<Key>, Value>{

	Node root;

	// Method to find lowest common ancestor.
	class Node 
	{
		private Key key;
		private Value val; 
		private Node left, right;
		private int N;

		//constructor
		public Node(Key key, Value val, int N)
		{
			this.val = val;
			this.key = key;
			this.N = N;

		}

	}

	public boolean isEmpty()
	{
		return size()==0;
	}
	
	public int size()
	{
		return size(root);
		
	}

	private int size (Node x)
	{
		if ( x==null)
		{
			return 0; 
		}
		else return x.N;
		
	}

	public boolean contains(Key key)
	{
		return get (key)!=null;
		
	}
	
	public Value get(Key key) 
	{ 
		return get(root, key); 
	}

	private Value get(Node node, Key key) 
	{
		if (node == null) return null;
		int cmp = key.compareTo(node.key);
		if      (cmp < 0) return get(node.left, key);
		else if (cmp > 0) return get(node.right, key);
		else return node.val;
		
	}  

	/**
	 *  Insert key-value pair into BST.
	 *  If key already exists, update with new value.
	 */
	public void put(Key key, Value val) {
		if (val == null) { delete(key); return; }
		root = put(root, key, val);
	}

	private Node put(Node node, Key key, Value val) {
		if (node == null) return new Node(key, val, 1); //new bst
		int cmp = key.compareTo(node.key);
		if      (cmp < 0) node.left  = put(node.left,  key, val);
		else if (cmp > 0) node.right = put(node.right, key, val);
		else              node.val   = val; //updating value
		node.N = 1 + size(node.left) + size(node.right); // value child1 + value child2 + 1
		return node;
	}
	
	
	
	
} 