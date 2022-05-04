import java.io.PrintStream;
import java.util.NoSuchElementException;



public class IntQueueImpl implements IntQueue {
	private int size;
	private class Node{ 
		int key;
		Node next;
		public Node(int key) {
			this.key = key;
			this.next = null;
		}
	}
	protected Node front;
	protected Node rear;
	
	
		
	
	public void put(int key) { //inserting item
		Node temp = new Node(key);
		if(this.rear == null) {
			this.front = this.rear = temp;
			size++;
			return ;
		}
		this.rear.next = temp;
		this.rear = temp;
		size++;
	}
	

	
	public int get() { //afairw to pio palio item
		if (isEmpty()) { // prwta ginetai elegxos gia to an einai h lista adeia
			throw new NoSuchElementException();
		}
		Node temp = this.front;
		if(this.front == null) {
			this.rear = null;
		}
		size--;
		int deleted = this.front.key;
		this.front = this.front.next;
		return deleted;
	}
	
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}
	
	
	
	public int peek() { //epistrefw to pio palio item
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return front.key;
		
	}
	
	public void printQueue(PrintStream stream) {
		Node current = front;
		
		while(current!=null) {
			System.out.print(current.key + " ");
			current = current.next;
		}
	}
	/*public static void main(String[] args) {
		IntQueueImpl queue = new IntQueueImpl();
		/* afou to queue perigrafei thn arxh FIFO to 1o stoixeio 10
		 * thewritika tha vgei 1o ara den einai to pio palio 
		 * to pio palio stoixeio einai to 50 pou mphke teleutaio 		 
		 
		
		queue.put(10); //oldest item 
		queue.put(20);
		queue.put(30);
		queue.put(40);
		queue.put(50); 
		
		queue.printQueue(System.out);
		
		System.out.println("\n" + queue.size());
		
		System.out.println(queue.get());
		
		System.out.println("\n" + queue.peek());
		
		queue.printQueue(System.out);
		
		System.out.println("\n" + queue.size());
		
		System.out.println("\n" + queue.isEmpty());
	}*/

}
