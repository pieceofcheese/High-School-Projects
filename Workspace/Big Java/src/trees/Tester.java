package trees;

public class Tester {

	public static void main(String[] args) {
		BinarySearchTree treed = new BinarySearchTree();
		
		treed.add(8);
		treed.add(5);
		treed.add(1);
		treed.add(7);
		treed.add(74);
		treed.add(10);
		treed.print();
		treed.remove(5);
		treed.print();
	}
	
}
