/// Java 8 Optional with example
package com.java8.Lambda.Example;

import java.util.Optional;
import java.util.function.Function;

public class Features {

	
	public static void main(String[] args) {
		Function<String, String> getSecondWord
		= (String s) -> {return s.split(" ").length > 1 ? s.split(" ")[1]:null;};
		
		Function<String, Integer> getcount = t->t.length();
		
		int ch = getSecondWord
				.andThen(getcount)
				.apply("more");
		
		//hey i added this
		
		//getSecondWord.apply("Asim Arunava");
		//System.out.println(getSecondWord.compose(before));
	}
}
