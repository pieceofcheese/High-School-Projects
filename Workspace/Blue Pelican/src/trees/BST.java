package trees;

public class BST {
	
	public BST (int i) {
		
		//Root is instantiated at time of creation
		rootNode = new BstNode(i);
	}
	
	public void addNode(int i) {
		
		BstNode currentNode = rootNode;
		boolean finished = false;
		do{
			BstNode curLeftNode = currentNode.leftNode;
			BstNode curRightNode = currentNode.rightNode;
			int curIntData = currentNode.intData;
			
			if(i>curIntData) {
				
				if(curRightNode==null) {
					
					currentNode.rightNode=new BstNode(i);
					finished = true;
					
				} else {
					
					currentNode = currentNode.rightNode;
					
				}
				
			} else {
				
				if(curLeftNode == null) {
					
					currentNode.leftNode=new BstNode(i);
					finished = true;
					
				} else {
					
					currentNode = currentNode.leftNode;
					
				}
			}
		} while (!finished);
		
	}
	
	public void traverseAndPrint(BstNode currentNode) {
		
		System.out.print("data = "+currentNode.intData);
		
		if(currentNode.leftNode==null) {
			System.out.print(" left = null");
		} else {
			System.out.print(" left = " + (currentNode.leftNode).intData);
		}
		
		if(currentNode.rightNode == null) {
			System.out.print(" right = null");
		} else {
			System.out.print(" right = " + (currentNode.rightNode).intData);
		}
		System.out.println("");
		
		if(currentNode.leftNode != null) {
			traverseAndPrint(currentNode.leftNode);
		}
		
		if(currentNode.rightNode != null) {
			traverseAndPrint(currentNode.rightNode);
		}
		
	}
	
	public boolean find(int i) {
		
		BstNode current = rootNode;
		boolean finished = false;
		
		do{
			BstNode curLeftNode = current.leftNode;
			BstNode curRightNode = current.rightNode;
			int curIntData = current.intData;
			
			if(curIntData==i) {
				
				return true;
				
			} else {
				
				if(i<curIntData) {
					
					if(curLeftNode!=null) {
						
						current = curLeftNode;
						
					} else {
						finished = true;
					}
					
				} else {
					
					if(curRightNode!=null) {
						
						current = curRightNode;
						
					}  else {
						finished = true;
					}
					
				}
				
			}
			
		} while(finished!=true);
		
		return false;
		
	}
	
	BstNode rootNode;

}
