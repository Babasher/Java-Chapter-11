/* Reads points from a text file and computes
 * the total length of the path formed.
 * MCS 141
 * 5/3/16
 * */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;


public class PathLength {
  public static void main (String [] args) {
    Point [] points = new Point [100]; //Array is bigger than necessary
    
    try {
      Scanner file = new Scanner(new File ("input.csv") );
      int lastIndex = -1; //counter to hold the last used index of the array
      
      while (file.hasNext() ) { //while there is data in the file
        
        String inputString = file.nextLine();
        Scanner parse = new Scanner(inputString);//Scanner to parse the input
        parse.useDelimiter(",");// "," is the break between values
        
        try { //validates input
          double newX = parse.nextDouble();//read until we reach a comma
          double newY = parse.nextDouble();
          lastIndex++;
          points[lastIndex] = new Point (newX,newY);
        }//end of inner try
        
        catch (InputMismatchException ime) {
          System.out.println("Error in data.  Data entry " + inputString + " ignored.");
        }
        
      }//end of while loop
      
      double total=0;
      for (int i = 0; i<lastIndex; i++) {
        total = total + points[i].distanceTo(points[i+1]);
      }
      
      System.out.println("Total distance is " + total);
      
    }//end of outer try
    
    catch (FileNotFoundException fnfe) {
      System.out.println("File not found.");
    }
    
  }//end of main
}