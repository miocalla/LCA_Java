import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.LinkedList;
import java.util.Queue;

public class DAG {

	private int numberOfVertices;           
	private int numberOfEdges;              
	private ArrayList<Integer>[] adj;    
	private int[] indegree;        
	private boolean marked[];		
	private boolean hasCycle;		
	private boolean stack[];		


	public DAG(int numberOfVertices)
	{
		if (numberOfVertices < 0) throw new IllegalArgumentException("Number of vertices in digraph must be nonnegative");
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		indegree = new int[numberOfVertices];
		marked = new boolean[numberOfVertices];
		stack = new boolean[numberOfVertices];
		adj = (ArrayList<Integer>[]) new ArrayList[numberOfVertices];
		for (int v = 0; v < numberOfVertices; v++) 
		{
			adj[v] = new ArrayList<Integer>();
		}              
	}

	public int vertex() {
		return numberOfVertices;	
	}

	public int edge() {
		return numberOfEdges;
	}

	public void addEdge(int v, int w)
	{
		if((validateVertex(v)>0) && (validateVertex(w)>0))
		{
			adj[v].add(w);
			indegree[w]++;
			numberOfEdges++;
		}
		else
		{
			System.out.println("Please enter vertices between 0 & n-1");
		}

	}

	private int validateVertex(int v) {
		if (v < 0 || v >= numberOfVertices)
			return -1;
		else
			return 1;
	}

	public int indegree(int v) {
		
		if(validateVertex(v)<0)
		{
			return -1;
		}
		else
		{
			return indegree[v];
		}
	}

	//Returns amount of directed edges from vertex v
	public int outdegree(int v) {
		
		if(validateVertex(v)<0)
		{
			return -1;
		}
		else{
			return adj[v].size();
		}
	}


	//Returns the adjacent vertices to v
	public Iterable<Integer> adj(int v)
	{ 
		return adj[v]; 
	}

	public boolean hasCycle() {

		return hasCycle;
	}

	public void findCycle(int v) {

		marked[v] = true;
		stack[v] = true;

		for (int w : adj(v)) {
			if(!marked[w]) 
			{
				findCycle(w);
			} 
			else if (stack[w]) 
			{
				hasCycle = true;
				return;
			}
		}

		stack[v] = false;
	}

	public ArrayList<Integer> BFS(int s)
	{
		boolean visited[] = new boolean[numberOfVertices];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> order= new ArrayList<Integer>();

		visited[s]=true;
		queue.add(s);

		while (queue.size() != 0)
		{
			s = queue.poll();           
			
			order.add(s);
			
			// Find adjacent vertices of the dequeued vertex s. If it has not been visited, mark it visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
			{
				int n = i.next();
				if (!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return order;

	}

	public DAG reverse() {
		
        DAG reverse = new DAG(numberOfVertices); 
        
        for (int v = 0; v < numberOfVertices; v++) 
        {
            for (int w : adj(v)) 
            {
                reverse.addEdge(w, v); //reverse the direction of the edges
            }
        }
        
        return reverse;
    }
	
	public int findLCA(int v, int w){
		
		findCycle(0);
		
		if(hasCycle)
		{
			return -1;
		}
		
		DAG backwards = reverse();
		
		ArrayList<Integer> vPath = backwards.BFS(v);
		ArrayList<Integer> wPath = backwards.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
		
		boolean isFound = false;
		
		for(int i = 0; i < vPath.size(); i++)
		{
			for(int t = 0; t< wPath.size(); t++)
			{		
				if(vPath.get(i)==wPath.get(t))
				{
					commonAncestors.add(vPath.get(i));
					isFound = true;
				}
			}
		}

		if(isFound)
		{
			return commonAncestors.get(0);

		}
		else
		{
			return -1;
		}
	}
	
	



}
