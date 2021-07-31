public class AVLTreeDemo {

}

class AVLTree {

	private Node root;

	public addNode(Node node){
		if (root == null){
			root = node;
		} else {
			root.addNode(node);
		}
	}

}

class Node {

	private int value;
	
	private Node left;
	
	private Node right;

	public Node(int value){
		this.value = value;
	}

	public void addNode(Node node){
		if (this.value > node.value){
			if (this.left == null){
				this.left = node;
			} else {
				this.left.addNode(node);			
			}
		} else {
			if (this.right == null){
				this.right = node;			
			} else {
				this.right.addNode(node);
			}
		}

		if (this.rightHeight() - this.leftHeight() > 1){
			if (this.right.leftHeight() > this.right.rightHeight()){
				this.right.rightRotate();
			}
			this.leftRotate();
			return;
		}

		if (this.leftHeight() - this.rightHeight() > 1){
			if (this.left.rightHeight() > this.left.leftHeight()){
				this.left.leftRotate();
			}
			this.rightRotate();
		}
	}

	private void leftRotate(){
		Node temporaryNode = new Node(this.value);
		temporaryNode.left = this.left;
		temporaryNode.right = this.right.left;
		
		this.value = this.right.value;
		
		this.right = this.right.right;
	
		this.left = temporaryNode;
	}

	private void rightRotate(){
		Node temporaryNode = new Node(this.value);
		temporaryNode.right = this.right;
		temporaryNode.left = this.left.right;

		this.value = this.left.value;
		
		this.left = this.left.left;
	
		this.right = temporaryNode;
	}

	public int height(){
		return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
	}

	public int leftHeight(){
		return this.left == null ? 0 : this.left.height();
	}

	public int rightHeight(){
		return this.right == null ? 0 : this.right.height();
	}

	public Node searchTargetNode(int value){
		
	}

	public Node searchParentNode(int value){

	}
}
