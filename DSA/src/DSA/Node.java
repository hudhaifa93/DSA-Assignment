package BSTree;

public class Node {

	
	 public Node parent;
	    public Node leftChild;
	    public Node rightChild;
	    public int isbn;
	    public String auther,title,surname;
	    
	    
	    public Node (){
	    
	    	isbn = 0;
	        
	        leftChild = null;
	        
	        rightChild = null;
	    	
	    }
	    
	    public Node(int isbn){
	        
	        this.isbn = isbn;
	        
	        leftChild = null;
	        
	        rightChild = null;
	        
	    }
	    
	    public Node(int isbn,String auther,String title, String surname ){
	        
	        this.auther = auther;
	        
	        this.title = title;
	        
	        this.surname = surname;
	        
	        this.isbn = isbn;
	        
	        leftChild = null;
	        
	        rightChild = null;
	        
	    }
	    
	    public void setLeft(Node left){     this.leftChild = left;}
	    
	    public void setRight(Node right){   this.rightChild = right;}
	    
	    public void setKey(int isbn){       this.isbn = isbn;   }
	    
	    public Node getLeft(){    return leftChild; }
	    
	    public Node getRight(){   return rightChild;  }
	    
	    public int getKey(){      return isbn;    }
	    
	
}
