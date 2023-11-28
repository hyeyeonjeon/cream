/**
 * The external Tree Node for Linked Trees
 * @author hyeyeon Jeon
 * @version 11/29/2023
 * @param <T> data type of TreeNode
 */
public class TreeNode<T> {
	private T data;
	protected TreeNode<T> left,
						right;
	/**
	 * Constructor for creating  a new TreeNode.
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		left = right = null;
	}
	/**
	 * Copy Constructor for being used for making deep copies.
	 * @param node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.getData();
		left = node.left;
		right = node.right;
	}
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}
	public void setData(T d) {
		data=d;
	}

	public void setLeft(TreeNode<T> leftNode) {
		left = leftNode;
	}
	public TreeNode<T> getLeft(){
		return left;
	}
	
	public void setRight(TreeNode<T> rightNode) {
		right = rightNode;
	}
	public TreeNode<T> getRight(){
		return right;
	}
}
