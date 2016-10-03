
public class TreeSort implements SortAlgorithm{
	
	private int index;

	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		BinaryTree<T> tree = new BinaryTree<>();
		for (T val : unsorted) {
			insert(tree, val);
		}
		toArray(tree, unsorted);
		return unsorted;
	}

	private <T extends Comparable<T>> void toArray(BinaryTree<T> tree, T[] dest) {
		if(tree.getValue()==null){
			return;
		}
		toArray(tree.getLeftTree(), dest);
		dest[index++]=tree.getValue();
		toArray(tree.getRightTree(), dest);
	}

	private <T extends Comparable<T>> void insert(BinaryTree<T> tree, T val) {
		if (tree.getValue() == null) {
			tree.setValue(val);
			return;
		} else if (val.compareTo(tree.getValue()) <= 0) {
			insert(tree.getLeftTree(), val);
		} else {
			insert(tree.getRightTree(), val);
		}
	}

}
