package trees;


import javax.swing.*;

public class BinarySearchTree {
	
	//constructs empty tree
	public BinarySearchTree() {
		
		root = null;
		
	}
	
	//insert a new node
	public void add (Comparable obj) {
		
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		if(root==null) root = newNode;
		else root.addNode(newNode);
	}
	
	//tries to find object in a tree
	public boolean find(Comparable obj) {
		
		Node current = root;
		while (current!=null) {
			int d = current.data.compareTo(obj);
			if(d==0) return true;
			else if(d>0) current = current.left;
			else current = current.right;
		}
		return false;
	}
	
	//tries to remove an object from a tree
	public void remove(Comparable obj) {
		
		//find node to be removed
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		
		while(!found && toBeRemoved != null) {
			int d = toBeRemoved.data.compareTo(obj);
			if(d==0) found = true;
			else {
				
				parent = toBeRemoved;
				if(d>0) toBeRemoved = toBeRemoved.left;
				else toBeRemoved = toBeRemoved.right;
			}
		}
		
		if(!found) return;
		
		//to be removed contains obj
		//if a child is empty use the other
		
		if(toBeRemoved.left==null || toBeRemoved.right == null) {
			
			Node newChild;
			if(toBeRemoved.left == null) {
				newChild=toBeRemoved.right;
			} else {
				newChild = toBeRemoved.left;
			}
			
			if(parent==null) //found in root
				root = newChild;
			else if (parent.left != toBeRemoved) {
				parent.left = newChild;
				
			}else parent.right = newChild;
			
			return;
		}
		
		//neither subtree is empty
		//find the smallest element of the right subtree
		
		Node smallestParent = toBeRemoved;
		Node smallest = toBeRemoved.left;
		while(smallest.right != null) {
			smallestParent = smallest;
			smallest = smallest.right;
		}
		
		//smallest contains smallest child in right subtree
		//move contents, unlink child
		
		toBeRemoved.data = smallest.data;
		smallestParent.left = smallest.right;
	}
	
	//prints the contents of the tree in sorted order
	public void print() {
		
		if(root!=null) {
			
			  root.printNodes();
			
		}
			
	}
	
	public void printTree() {
		
		root.printNode(0);
		
	}

	private Node root;
	
	//a node of a tree stores a data item and references to the child nodes to the left and to the right
	
	private class Node {
		
		//inserts a new node as a descendant of this noed
		public void addNode(Node newNode) {
			if(newNode.data.compareTo(data)<0) {
				if(left==null) left = newNode;
				else left.addNode(newNode);
				
			} else {
				
				if(right == null)right = newNode;
				else right.addNode(newNode);
				
			}
		}
		
		public void printNode(int tab) {
			
			//print left node first
			if(left!=null) {
				left.printNode(tab+1);
				
				/*for(int x = 0; x<tab; x++) {
					
					System.out.print("\t");
					
				}

				System.out.print("    >\n");*/
			}
			
			//print middle value
			for(int x = 0; x<tab; x++) {
				
				//tab as far as necessary
				System.out.print("\t");
				
			}
			
			//print data
			System.out.print(data);
			
			//decide what branches exist then add to end
			if(right!=null&&left!=null) {
				
				//both
				System.out.print("<\n");
				
			} else {
				if(left!=null) {
					//left only
					System.out.print("/\n");
				}else {
					if(right!=null) {
						//right only
						System.out.print("\\ \n");
					} else {
						//none
						System.out.print("\n");
					}
				}
			}
			
			//print right node
			if(right!=null) {
				/*for(int x = 0; x<tab; x++) {
					
					System.out.print("\t");
					
				}

				System.out.print("    >\n");*/
				right.printNode(tab+1);
			}
			
		}
		
		public void printNodes(){
			if (left!=null)
				left.printNodes();
			System.out.println(data);
			if(right!=null)
				right.printNodes();
			
			/*if(left!=null) {
				
				try {
					JLabel label = new JLabel((String) data);
					layout.addLayoutComponent("n", arg1);
					
				} catch(RuntimeException e) {
					
					System.out.println("I only take strings");
					
				}
				
				
			}*/
	      
		}
		
		public Comparable data;
		public Node left;
		public Node right;
	}

}
