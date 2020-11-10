import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {
	
	@Test
	public void testForDirectedGraph(){
		DAG test = new DAG(10);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
		
		assertEquals("", 1, test.indegree(4));
		assertEquals("", 2, test.outdegree(4));
		assertEquals("", 5, test.edge());
		assertEquals("", 10, test.vertex());
		String answer = "[5, 6]";
		assertEquals("",answer, test.adj(4).toString());
	}

	@Test
	public void testsForCycle(){
		DAG cyclic = new DAG(20);
		cyclic.addEdge(0, 1);
		cyclic.addEdge(1, 2);
		cyclic.addEdge(2, 0);
		
		cyclic.findCycle(0);
		
		assertTrue(cyclic.hasCycle());
		
		DAG acyclic = new DAG(20);
		acyclic.addEdge(0, 1);
		acyclic.addEdge(1, 3);
		acyclic.addEdge(2, 4);
		acyclic.findCycle(0);
		assertFalse(acyclic.hasCycle());
	}

}
