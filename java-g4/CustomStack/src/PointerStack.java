
public class PointerStack<T> implements Stack<T>{
	
	private StackElement<T> top = null;

	@Override
	public void push(T obj) {
		if(top==null){
			top = new StackElement<T>(obj, null);
		} else {
			StackElement<T> newTop = new StackElement<T>(obj, top);
			top = newTop;
		}
	}

	@Override
	public T pop() {
		if(top==null){
			return null;
		} else {
			T value = top.getValue();
			top = top.getPrevious();
			return value;
		}
	}

	@Override
	public T peek() {
		return top ==null ? null : (T)top.getValue();
	}
	
	private class StackElement<S> {
		private S value;
		private StackElement<S> previous;
		
		public StackElement(S value, StackElement<S> previous) {
			super();
			this.value = value;
			this.previous = previous;
		}
		
		public StackElement<S> getPrevious() {
			return previous;
		}
		
		public S getValue() {
			return value;
		}
		
	
	}

}
