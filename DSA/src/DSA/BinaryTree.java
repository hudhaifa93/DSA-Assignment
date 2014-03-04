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
		
		public Node find(int val) {
	    	
	    	Node node = new Node();
	        
	        if (root != null) {
	        	
	             node =  findNode(root, new Node(val));
	             
	             return node;
	             
	           // System.out.println(node.isbn);
	            
	        }
	        
	        return null;
	    }
	    
	    private Node findNode(Node search, Node node) {
	        
	        if (search == null) {
	            
	            return null;
	        }
	        
	        if (search.isbn == node.isbn) {
	            
	            return search;
	            
	        } else {
	            
	            Node returnNode = findNode(search.leftChild, node);
	            
	            if (returnNode == null) {
	                
	                returnNode = findNode(search.rightChild, node);
	                
	            }
	            
	            return returnNode;
	        }
	    }
		
		
	    
	    
	    
	    
	    
	    
	    
	    
	    

		
	    
	   
	    
	    
	    
	   
	    
	    
	    
	
	   
	    
}
