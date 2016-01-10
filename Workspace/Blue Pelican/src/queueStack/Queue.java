package queueStack;

public interface Queue {

	boolean isEmpty();
	void enqueue(Object obj);
	Object dequeue();
	Object getFirst();
	
}
