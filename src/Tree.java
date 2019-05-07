public class Tree {
 
    class Node
    {
        int key;
        Node left;
        Node right;
       
        public Node(int item)
        {
            key = item;
            right = null;
            left = null;
        }
    }
   
    Node root;
   
    public Tree()
    {
        root = null;
    }
    
    public void insert(int key)
    {
        root = ins(key, root);
    }
    
    public void inorder()
    {
        print(root);
    }
    
    public int min(Node root) 
    { 
    	if(root.left == null)
    	{
    		return root.key;
    	}
    	
    	else
    	{
    		return root.right.key;
    	}
    }
   
    public Node ins(int key, Node root)
    {
        if (root == null)
        {
            root = new Node(key);
           
            return root;
        }
       
        if (key < root.key)
        {
            root.left = ins(key, root.left);
        }
       
        else
        {
            root.right = ins(key, root.right);
        }
       
        return root;
    }

    public void print(Node root)
    {
        if (root != null)
        {
            print(root.left);
           
            System.out.print(" " + root.key + " ");
           
            print(root.right);
        }      
    }
    
    public void delete(int key)
    {
    	del(key, root);
    }
    
    public Node del(int key, Node root)
    {
    	// Null acceptance statement to prevent a null root
    	if(root == null)
    	{
    		return root;
    	}
    	
    	// Searches for the key's root in the tree
    	else if(key < root.key)
    	{
    		root.left = del(key, root.left);
    	}
    	
    	// Searches for the key's root in the tree
    	else if(key > root.key)
    	{
    		root.right = del(key, root.right);
    	}
		
		// Satisfies if there are two children
		else
		{
	    	// Returns the only left child
			if(root.right == null)
			{
				return root.left;
			}
			
			// Returns the only right child
			if(root.left == null)
			{
				return root.right;
			}
			
			// Finds the minimum value to replace the targeted node for deletion
            root.key = min(root.right);

            // Deletes the targeted node
            root.right = del(root.key, root.right); 		
		}

    	return root;
    }
    
    public boolean search(int key)
    {
    	return searchKey(key, root);
    }
    
    public boolean searchKey(int key, Node root)
    {
    	if(root == null)
    	{
    		return false;
    	}
    	
    	else if(root.key == key)
    	{
    		return true;
    	}
    	
    	else if(key < root.key)
    	{
    		return searchKey(key, root.left);
    	}
    	
    	else if(key > root.key)
    	{
    		return searchKey(key, root.right);
    	}
    	
    	return false;
    }
}
