
public class Main {

	public static void main(String[] args) {

		Stack stack = new PointerStack();
		stack.push("apple");
		stack.push("lemon");
		System.out.println(stack.peek());
		stack.push("orange");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}
