
public class PointerStack implements Stack{
	
	private StackElement top = null;

	@Override
	public void push(Object obj) {
		if(top==null){
			top = new StackElement(obj, null);
		} else {
			StackElement newTop = new StackElement(obj, top);
			top = newTop;
		}
	}

	@Override
	public Object pop() {
		if(top==null){
			return null;
		} else {
			Object value = top.getValue();
			top = top.getPrevious();
			return value;
		}
	}

	@Override
	public Object peek() {
		return top ==null ? null : top.getValue();
	}
	
	private class StackElement {
		private Object value;
		private StackElement previous;
		
		public StackElement(Object value, StackElement previous) {
			super();
			this.value = value;
			this.previous = previous;
		}
		
		public StackElement getPrevious() {
			return previous;
		}
		
		public Object getValue() {
			return value;
		}
		
	
	}

}
