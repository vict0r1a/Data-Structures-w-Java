import java.io.PrintStream;
import java.util.NoSuchElementException;



public class StringStackImpl implements StringStack {

	protected  Node top; //o prwtos komvos ths listas
	private int size;
	 class Node{ //gia ton kathe komvo
		String data; //ta dedomena pou theloume na exoume k einai tupou string
		Node next; //to Node next anaferetai ston epomeno komvo
		public Node(String data) { //constructor ths eswterikhs klashs Node me parametro ta dedomena 
			this.data = data;
			this.next = null; //auto arxika einai NULL
		}
	}
	
	
	
	/* h methodos push pairnei tis times ths stack dld ta data
	 *  kai ta vazei sthn lista
	 *   ola einai String!*/
	public void push(String data) { 
		
		Node currNode = new Node(data); //dhmiourghsame ena kainourgio node(komvo) 
		currNode.next = top; //eisagoume ton current node 
		top = currNode; //meta ton top
		size++; // to megethos auksanetai kata 1 meta apo thn eisagwgh kathe komvou
	}
	
	/* h methodos pop afairei kai epistrefei to item apo to panw meros ths stack
	 * an h lista einai adeia tote petaei to exception*/
	public String pop() { 
		if (isEmpty()) { // prwta ginetai elegxos gia to an einai h lista adeia
			throw new NoSuchElementException();
		}
		
		String deletedData = top.data; // panta painroume to item pou vrisketai top ths listas
		top = top.next; //metakinw ton pointer ston epomeno komvo
		size--; //to megethos meiwnetai kata 1 afou afairoume item
		return deletedData;
	}
	
	/*epistrefei to item pou einai sthn korufh ths listas
	 * xwris na to diagrafei
	 * an einai kenh h lista vgainei to exception*/
	public String peek() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return top.data; //epistrefetai auto pou einai 1o
	}
	
	
	
	public int size() { 
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	
	public void printStack(PrintStream stream) {
		Node current = top;
		
		while(current!=null) {
			//System.out.println("\n");
			System.out.print(current.data);
			current = current.next;
		}
	}
	

	
	
	
	//MAIN
	
	/*public static void main(String[] args) {
		StringStackImpl stack = new StringStackImpl();
		stack.push("</html>"); //to 1o stoixeio pou einai bottom element ki thav vgei teleutaio
		stack.push("20!");
		stack.push("30!");
		stack.push("40!");
		stack.push("thanks");
		// to top element ths stack einai to thanks ara auto tha diagrafei
		
		stack.printStack(System.out);
		System.out.println("\n");
	
	}*/
	
	
	
}