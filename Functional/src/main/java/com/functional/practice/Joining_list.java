package com.functional.practice;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Joining_list {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		String s = list
					   .stream()
					   .map(Object::toString)
					   .collect(Collectors.joining("?"));
		System.out.println(s);
		
		 File dir = new File("C:");
		    
		    File[] children = dir.listFiles();
		    System.out.println(
		    	      Stream.of(children)
		    	            .map(File::getName)
		    	            .collect(Collectors.joining(", ")));
		    
		    //Do null check before start
/*		    return Optional.ofNullable(userList)
	                .orElseGet(Collections::emptyList)
	                .stream()
	                .map(user -> user.getName())
	                .collect(Collectors.toList());*/	  
	}
}
