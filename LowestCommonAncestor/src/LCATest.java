import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testLCA() {
		
		LCA<Integer, Integer> bst = new LCA<Integer, Integer>();
		
		assertSame("Testing LCA for null root", null, bst.lowestCommonAncestor(bst.root, 1, 2));
		
		bst.put(7, 7);
		bst.put(8, 8);   
		bst.put(3, 3);   
		bst.put(1, 1);   
		bst.put(2, 2);  
		bst.put(6, 6);   
		bst.put(4, 4); 
		bst.put(5, 5);  		 	
		assertSame("Testing LCA left side", 3, bst.lowestCommonAncestor(bst.root, 2,6));
		assertSame("Testing LCA right side", 7, bst.lowestCommonAncestor(bst.root, 8,3));
		assertSame("Testing LCA where LCA is one of the nodes", 7, bst.lowestCommonAncestor(bst.root, 7,8));
		assertSame("Testing LCA where LCA is one of the nodes", 7, bst.lowestCommonAncestor(bst.root, 3,7));
	}

}
