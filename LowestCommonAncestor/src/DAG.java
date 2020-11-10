import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.LinkedList;
import java.util.Queue;

public class DAG {

	private int V;           
	private int E;              
	private ArrayList<Integer>[] adj;    
	private int[] indegree;        
	private boolean marked[];		
	private boolean hasCycle;		
	private boolean stack[];		
	private int[] distanceTo;      
	private int[] edgeTo;     


	public DAG(int V)
	{
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		marked = new boolean[V];
		stack = new boolean[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}              
	}

	//Returns current vertex
	public int vertex() {
		return V;	
	}

	public int edge() {
		return E;
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

}
