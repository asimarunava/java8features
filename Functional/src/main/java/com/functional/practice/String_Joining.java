/// Java8 String Joining
package com.functional.practice;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class String_Joining {

	  public static void main(String[] args) throws IOException {
	    File dir = new File("C:");
	    
	    File[] children = dir.listFiles();
   
	    System.out.println(
	      Stream.of(children)
	            .map(File::getName)
	            .collect(Collectors.joining(", ")));
	  }

}
