package BSTree;

public class BinaryTree {
	    
	    Node root;
            
            public Node getRoot(){
                return root;
            }
	    
	    public void add(int isbn) {
	        
	        Node nodeToAdd = new Node(isbn);
	        
	        if (root == null) {
	            
	            root = nodeToAdd;
	            
	        }
	        
	        traverseAndAddNode(root, nodeToAdd);
	        
	    }
	    
	   
	    
	    private void traverseAndAddNode(Node node, Node nodeToAdd) {
	        
	        
	        if (nodeToAdd.isbn < node.isbn) {
	            
	            if (node.leftChild == null) {
	                
	                nodeToAdd.parent = node;
	                node.leftChild = nodeToAdd;
	                
	            } else {
	                
	                traverseAndAddNode(node.leftChild, nodeToAdd);
	                
	            }
	            
	        } else if (nodeToAdd.isbn > node.isbn) {
	            
	            if (node.rightChild == null) {
	                
	                nodeToAdd.parent = node;
	                node.rightChild = nodeToAdd;
	                
	            } else {
	                
	                traverseAndAddNode(node.rightChild, nodeToAdd);
	                
	            }
	            
	        }
	        
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    

		
	    
	   
	    
	    
	    
	   
	    
	    
	    
	
	   
	    
}
