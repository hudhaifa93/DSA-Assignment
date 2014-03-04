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
		
		public boolean delete(int val) {

	        //case1 node has no children
	        //case2 node has one child
	        //case3 node has two child
	        Node nodeToBeDeleted = find(val);
	        
	        
	        
	        if (nodeToBeDeleted != null) {
	        	
	        	if(root.isbn == nodeToBeDeleted.isbn){
	        		
		        	deleteCase4(nodeToBeDeleted);
		        	
		        	
		        }else{
		        	
		        	if (nodeToBeDeleted.leftChild == null && nodeToBeDeleted.rightChild == null) {

	                //case1
	                deleteCase1(nodeToBeDeleted);
	                
	            } 
	            if (nodeToBeDeleted.leftChild != null && nodeToBeDeleted.rightChild != null) {

	                //case2 left child should be deleted
	                deleteCase3(nodeToBeDeleted);
	                
	            } else if (nodeToBeDeleted.leftChild != null ) {

	                //case2 right child should be deleted
	                deleteCase2(nodeToBeDeleted);
	                
	            }else if( nodeToBeDeleted.rightChild != null) {
	            	
	            	deleteCase2(nodeToBeDeleted);
	            }
		        	
		        }
	            
	            
	            
	        }
	        
	        
	        
	        return false;
	    }
	    
	    
	    // case 4 if the nodeToBeDeleteed is the tree root
	    private void deleteCase4(Node nodeToBeDeleted) {
			
	    	Node minNode = minLeftTraversal(nodeToBeDeleted.rightChild);
	    	
	    	root.isbn = minNode.isbn;
	    	root.auther = minNode.auther;
	    	root.title = minNode.title;
	    	root.surname = minNode.surname;
	    	
	    	if(minNode.rightChild == null){
	    		
	    		deleteCase1(minNode);
	    		
	    	}else{
	    		
	    		deleteCase2(minNode);
	    	}
			
		}

		private void deleteCase1(Node nodeToBeDeleted) {

	        //check if node to be deleted is the left or right CHILD of the PARENT of the node 
			if(nodeToBeDeleted.parent != null){
				if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
	            
	            nodeToBeDeleted.parent.leftChild = null;
	            
	        } else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
	            
	            nodeToBeDeleted.parent.rightChild = null;
	            
	        }
			}
	        
	    }
	    
	    private void deleteCase2(Node nodeToBeDeleted) {
	        
	        if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
	            
	            if (nodeToBeDeleted.leftChild != null) {
	                
	                nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.leftChild;
	                
	            } else if (nodeToBeDeleted.rightChild != null) {
	                
	                nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.rightChild;
	                
	            }
	            
	        } else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
	            
	            if (nodeToBeDeleted.leftChild != null) {
	                
	                nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.leftChild;
	                
	            } else if (nodeToBeDeleted.rightChild != null) {
	                
	                nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.rightChild;
	                
	            }
	            
	        }
	        
	    }
	    
	    private void deleteCase3(Node nodeToBeDeleted) {
	        
	        Node minNode = minLeftTraversal(nodeToBeDeleted.rightChild);
	        
	        if(minNode.rightChild == null)
	        	deleteCase1(minNode);
	        else
	        	deleteCase2(minNode);
	        
	        minNode.parent = nodeToBeDeleted.parent;
	        
	        minNode.leftChild = nodeToBeDeleted.leftChild;
	        
	        minNode.rightChild = nodeToBeDeleted.rightChild;
	        
	        if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
	            
	            nodeToBeDeleted.parent.leftChild = minNode;
	            
	        } else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
	            
	            nodeToBeDeleted.parent.rightChild = minNode;
	            
	        }
	        
	    }
	    
	    private Node minLeftTraversal(Node node) {
	        
	        if (node.leftChild == null) {
	            
	            return node;
	            
	        }
	        
	        return minLeftTraversal(node.leftChild);
	        
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    

		
	    
	   
	    
	    
	    
	   
	    
	    
	    
	
	   
	    
}
