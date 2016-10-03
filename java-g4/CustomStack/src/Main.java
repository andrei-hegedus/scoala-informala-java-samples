
public class Main {

	public static void main(String[] args) {

		Stack<String> stack = new PointerStack<String>();
		stack.push("apple");
		stack.push("lemon");
		System.out.println(stack.peek());
		stack.push("orange");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		Stack<Integer> istack;		
	}

}
