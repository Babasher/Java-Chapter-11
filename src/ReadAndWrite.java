/* Input-output demo with error handling
 * Read input from a text file
 * Write output with the text reversed
 * MCS 141
 * 12/6/16
 * */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
// could have done import java.io.*;

public class ReadAndWrite {
  public static void main (String [] args) {
    StringBuilder input;
    StringBuilder output = new StringBuilder();
    
    try { // try to read a file called input.txt
      Scanner file = new Scanner( new File("input.txt") );
      while ( file.hasNext() ) {
        input = new StringBuilder( file.nextLine() );
        output.append( input.reverse() + "\r\n" );
      }
      file.close(); // closes Scanner (and therefore the file as well)
    }// end of try block
    catch (FileNotFoundException fnfe) {
      System.out.println("Cannot find input.txt");
    }
    catch (Exception e) { // catch any other exception
      e.printStackTrace(); // print error to console
    }
    
    try { // output
      FileOutputStream fos = new FileOutputStream("output.txt", false);
      //false means we are writing, not appending
      PrintWriter pw = new PrintWriter( fos );
      //System.out.println(output);
      pw.println( output );
      pw.close(); // close PrintWriter to force any waiting data to be written to the file
    }
    catch (FileNotFoundException fnfe) {
      System.out.println("Cannot write to output.txt");
    }
  }//end main
}//end class
