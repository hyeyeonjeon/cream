import java.util.ArrayList;
/**
 * This is specifically used for the conversion of morse code to English.
 * @author hyeyeon Jeon
 * @version 11/29/2023
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	protected TreeNode<String> root;
	
	/**
	 * Constructor to call the buildTree method
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<String> getRoot(){
		return root;
	}
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	 public void insert(String code, String result) {
		 addNode(root, code, result);
	 }
	 
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		//base case
		if(code.length() == 1) {
			if(code.charAt(0) == '.')
				root.setLeft (new TreeNode<String>(letter));
			else if (code.charAt(0) == '-')
				root.setRight(new TreeNode<String>(letter));
		}else { //recursive
			if(code.charAt(0) == '.')
				addNode(root.getLeft(), code.substring(1), letter);
			else if (code.charAt(0) == '-')
				addNode(root.getRight(), code.substring(1), letter);
		}
	}
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		TreeNode<String> temp = root;
		//base case
		if(code.length() == 1) {
			if(code.charAt(0)=='.') 
				return root.getLeft().getData();
			else if (code.charAt(0) == '-') 
				return root.getRight().getData();
		}else {//recursive
			if(code.charAt(0) == '.') 
				temp = root.getLeft();
			else if (code.charAt(0) == '-')
				temp = root.getRight();
		}
		return fetchNode(temp, code.substring(1));
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
		
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	public void buildTree() {
		//level 1
		insert(".","e"); 
		insert("-","t"); 
		//level 2
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		//level 3
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		//level 4
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList(){
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(getRoot(),list);
		return list;
	}
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		//base case
		if(root.getLeft() == null) {
			list.add(root.getData());
			return;
		}
			LNRoutputTraversal(root.getLeft(), list);
			list.add(root.getData());
		
		if(root.getLeft() != null) {
			LNRoutputTraversal(root.getRight(), list);
		}
		
	}
}
