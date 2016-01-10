package queueStack;

import java.util.LinkedList;

public class LinkedListQueue implements Queue {

	public LinkedListQueue() {
		
		lst = new LinkedList();
		
	}
	
	@Override
	public boolean isEmpty() {
		return lst.isEmpty();
	}

	@Override
	public void enqueue(Object obj) {
		lst.addLast(obj);
		
	}

	@Override
	public Object dequeue() {
		
		return lst.removeFirst();
	}

	@Override
	public Object getFirst() {
		return lst.getFirst();
	}

	LinkedList lst;
	

}
