package stackCalculator;

import java.util.LinkedList;

public class StackLL implements StackIntrfc{
	
	public StackLL() {
		size = 0;
		stack = new LinkedList<Double>();
	}

	@Override
	public void push(double d) {
		size++;
		stack.addLast(d);
		
	}

	@Override
	public double pop() {
		size--;
		return stack.removeLast();
	}

	@Override
	public double peek() {
		
		return stack.peekLast();
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void clear() {
		stack = new LinkedList<Double>();
		
	}
	
	LinkedList<Double> stack;
	int size;

}
