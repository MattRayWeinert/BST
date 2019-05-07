import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
 
public class BST
{
    public static void main(String[] args)
    {
               
        File file = new File(args[0]);
       
        try {
        	
            Tree tree = new Tree();
           
            BufferedReader br = new BufferedReader(new FileReader(file));
           
            System.out.println("\nFile Opened Successfully.");
           
            Scanner scanner = new Scanner(file);
                       
            // Loops through file until EOF
            while(scanner.hasNext())
            {
                // Scans the line
                String data = scanner.nextLine();
               
                String[] line = data.split(" "); 
           
                if(line[0].equals("i"))
                {
                    int num = Integer.parseInt(line[1]);
                    tree.insert(num);
                }
               
                if(line[0].equals("d"))
                {
                    int delNum = Integer.parseInt(line[1]);
                    
                    if(tree.search(delNum) == true)
                    {
                        tree.delete(delNum);
                    }
                    
                    else
                    {
                    	System.out.println(delNum + ": NOT found");
                    }
                }
                
                if(line[0].equals("q"))
                {
                    System.out.println("Quit function");
                }
               
                if(line[0].contentEquals("p"))
                {
                    tree.inorder();
                }
                
                if(line[0].contentEquals("s"))
                {
                	int searchNum = Integer.parseInt(line[1]);
                    
                    if(tree.search(searchNum) == true)
                    {
                    	System.out.println(searchNum + ": Found");
                    }
                    
                    else
                    {
                    	System.out.println(searchNum + ": NOT found");
                    }
                }
 
            }
           
            // Closes text file
            br.close();
           
            // Closes the scanner
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
