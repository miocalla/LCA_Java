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

	class Node 
	{ 
		int data; 
		Node left, right; 

		public Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	} 


	Node root; 

	Node findLCA(int number1, int number2) 
	{ 
		return findLCA(root, number1, number2); 
	} 

	// Returns pointer to LCA of two given values number1 and number2, assuming they are present in Binary Tree
	Node findLCA(Node node, int number1, int number2) 
	{ 
		if (node == null) 
		{
			return null; 
		} 

		// If  number1 or number2 matches with root's key, return root 
		if (node.data == number1 || node.data == number2) 
		{
			return node; 
		}  
		// Look for keys in left and right subtrees 
		Node left_lca = findLCA(node.left, number1, number2); 
		Node right_lca = findLCA(node.right, number1, number2); 

		// If both of the above calls return Non-NULL, then one key is present in once subtree and other is present in other, meaning node is LCA
		if (left_lca!=null && right_lca!=null) 
		{
			return node; 
		}
		// Otherwise check if left subtree or right subtree is LCA 
		return (left_lca != null) ? left_lca : right_lca; 
	} 


	public static void main(String args[])  
	{ 
		LCA tree = new LCA(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data); 
		System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data); 
		System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data); 
		System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data); 
	} 
} 