
public class BinaryTree <T>{
	
	private T value;
	private BinaryTree<T> leftTree;
	private BinaryTree<T> rightTree;
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
		leftTree = new BinaryTree<T>();
		rightTree = new BinaryTree<T>();
	}
	public BinaryTree<T> getLeftTree() {
		return leftTree;
	}
	public void setLeftTree(BinaryTree<T> leftTree) {
		this.leftTree = leftTree;
	}
	public BinaryTree<T> getRightTree() {
		return rightTree;
	}
	public void setRightTree(BinaryTree<T> rightTree) {
		this.rightTree = rightTree;
	}
	@Override
	public String toString() {
		return "BinaryTree [value=" + value + ", leftTree=" + leftTree + ", rightTree=" + rightTree + "]";
	}
	
	

}
