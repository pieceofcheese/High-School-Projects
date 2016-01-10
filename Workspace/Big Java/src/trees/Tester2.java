package trees;

public class Tester2 {
	
	public static void main(String[] args) {
		BinarySearchTree treed = new BinarySearchTree();
		
		treed.add(8);
		treed.add(5);
		treed.add(1);
		treed.add(7);
		treed.add(74);
		treed.add(10);
		treed.printTree();
		treed.remove(5);
		treed.printTree();
	}
	
}
