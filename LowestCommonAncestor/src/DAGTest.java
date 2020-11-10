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

	@Test
	public void testLCAforEmpty() {
		DAG testEmpty = new DAG(10);
		assertEquals("Testing LCA is -1", -1, testEmpty.findLCA(1, 2));
	}


	@Test
	public void testAddEdge(){

		DAG dagTestEdge = new DAG(5);
		dagTestEdge.addEdge(0, 1);
		dagTestEdge.addEdge(-2, -5);

		assertEquals("Testing edge count is 1", 1, dagTestEdge.edge());

		dagTestEdge.addEdge(1, 2);

		assertEquals("Testing edge count is 2", 2, dagTestEdge.edge());
	}

	@Test
	public void testInDegree(){

		DAG dag = new DAG(5);
		assertEquals("", -1, dag.indegree(-3));

	}

	@Test
	public void testOutDegree(){

		DAG dag = new DAG(5);
		assertEquals("", -1, dag.outdegree(8));	

	}

	@Test
	public void testLCA(){

		DAG lca = new DAG(10);

		lca.addEdge(0, 1);
		lca.addEdge(1, 2);
		lca.addEdge(1, 3);
		lca.addEdge(2, 5);
		lca.addEdge(3, 4);
		lca.addEdge(4, 6);
		lca.addEdge(5, 6);
		lca.addEdge(6, 8);
		lca.addEdge(5, 7);
		lca.addEdge(7, 8);
		lca.addEdge(8, 9);

		assertEquals("4 and 5", 1, lca.findLCA(5, 4));
		assertEquals("7 and 8", 7, lca.findLCA(8, 7));
		assertEquals("6 and 8", 6, lca.findLCA(6, 8));
		assertEquals("Special case where both parameters are same vertex", 2, lca.findLCA(2,2));
	}

	@Test
	public void testLCAForNoCommonAncestors(){
		DAG lca2 = new DAG(11);

		lca2.addEdge(0, 1);
		lca2.addEdge(0, 2);
		lca2.addEdge(1, 2);
		lca2.addEdge(2, 3);
		lca2.addEdge(3, 4);
		lca2.addEdge(1, 5);
		lca2.addEdge(3, 5);

		assertEquals("when there is no LCA", 0, lca2.findLCA(3, 1));
		assertEquals("", 2, lca2.findLCA(3, 2));
		assertEquals("", 3, lca2.findLCA(4, 5));

		//Check for no common ancestors
		assertEquals("when one node doesn't exist", -1, lca2.findLCA(7, 3));
	}

	//unique case where graph is just a digraph but not acyclic
	@Test
	public void testLCAForNonDAG(){
		DAG lca3 = new DAG(11);

		lca3.addEdge(0, 1);
		lca3.addEdge(0, 2);
		lca3.addEdge(2, 3);
		lca3.addEdge(3, 0);
		lca3.addEdge(3, 4);

		//Should return -1 if graph is not a DAG
		assertEquals("", -1, lca3.findLCA(2, 3));
		assertEquals("", -1, lca3.findLCA(3, 4));
		assertEquals("", -1, lca3.findLCA(1, 2));
		assertEquals("", -1, lca3.findLCA(0, 3));
		assertEquals("", -1, lca3.findLCA(1, 3));

	}
	
	@Test(expected=Exception.class)
	public void exceptionTest()
	{
		//Not possible to make directed graph with less than 0 vertices
		DAG test = new DAG(-5);
	}

}
