package problem03;

public class MyStack {

	private String[] buffer;
	private int top;
	private int size;

	public MyStack( int size ) {
		top = -1;
		this.size=size;
		buffer= new String[size];
	}

	public void push(String item) {
		if(isFull()) {
			this.size = size()+1;
		}
		buffer[++top] = item;
	}

	public String pop() {
		if(isEmpty())return null;
		return buffer[top--];
	}

	public boolean isEmpty() {

		return (top == -1);
	}

	public boolean isFull(){
		return (top == size-1);
	}

	public int size() {
		// resizing
		String[] copy = new String[size+1];
		for (int i = 0; i < size; i ++){
			copy[i] = this.buffer[i];
		}

		this.buffer = copy;

		return size;
	}
}