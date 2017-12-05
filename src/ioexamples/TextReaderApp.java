package ioexamples;

import java.io.*;
/**
 * TextReaderApp.java	1.00 Nov 25, 2003
 *
 * A class that reads data from a text file, with buffering. Uses
 * the file "test.txt" which is in this project. Try reading your
 * own text file stored in a different directory.
 */
public class TextReaderApp{
    
     private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public TextReaderApp(String filename) {
        this.filename = filename;
    }
    
    
    
    
    
    public final void outputLastNameAndZip() {
        File data = new File("src" + File.separatorChar + getFilename());
        
              BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
           int counter =0;
	   while(line != null){
               if (counter >= 3) {
                   counter = 0;
                   
               }
                  counter++;
                  if (counter == 1) {
                      String[] name = line.split("\\s");
                      System.out.println(name[1]);
                  }
                  if (counter == 3) {
                      String[] address = line.split("\\s");
                      String zip = address[2];

                      
                      System.out.println(zip);
                  }
		  
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        
    }
	
//   public static void main(String[] args) {
//	/* This uses System properties to extract the correct
//	 * file path separator character.
//	 * 
//	 * Examples:
//	 *    On Windows:  (absolute paths)
//	 *                 C:\\temp\\FileName.txt ( \ = escape char in Java!)
//	 *                 c:/temp/FileName.txt  (alternate)
//	 * 
//	 * 				   (relative path)
//	 *                 resources/FileName.txt (path relative to class location)
//	 * 
//	 *    On Unix:     /usr/temp/filename.txt (always relative)
//	 */
//	 
//	/* 
//	 * Preferred way to reference a file path ... platform neutral. Line 30
//	 * shows how to use a system dependent separator char in a portable way.
//	 * Line 32 shows how to reference a file in the current classpath.
//	 */
//	File data = new File("src" + File.separatorChar + "ContactList.txt");
////	File data = new File(File.separatorChar + "temp" + File.separatorChar 
////                        + "ContactList.txt");
////                + "test.txt");
//	  		
//	/* Here are Windows/Unix examples that tries to read a file
//	 * in the temp directory. Notice that the path begins with a forward
//	 * slash. This is an example of relative path syntax. In this case,
//	 * the path begins with a slash, which means it is relative to 
//	 * the root of the startup drive.
//	 */
////	File data = new File("/temp/example.txt");  // Windows or Unix/Linux
////	File data = new File("C:\\temp\\example.txt");  // Windows only
//	
////	System.out.println("Absolute Path: " + data.getAbsolutePath());
////	System.out.println("Canonical Path: " + data.getCanonicalPath()); // what's the difference?
//////	
//////	// This references the working directory
////	System.out.println("Working directory is: " + System.getProperty("user.home")); // set/get working directory
//
//	// check if file exists, and if so, loop through and read each line of text
////    if (data.exists()){
//        BufferedReader in = null;
//        try {
//	   in = new BufferedReader(new FileReader(data));
//	   String line = in.readLine();
//	   while(line != null){
//		  System.out.println(line);
//		  line = in.readLine();  // strips out any carriage return chars
//	   }
//	 
//        } catch(IOException ioe) {
//            System.out.println("Houston, we have a problem! reading this file");
//        } finally {
//            try {
//                in.close();
//            } catch(Exception e) {
//                
//            }
//        }
//    } else
//	     System.out.println("File not found: test.txt");
//    }// end main
} // end classd
