package com.java8.Lambda.Example;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import com.functional.practice.Order;

public class ListRevisit {
private static List<Integer> num = Arrays.asList(1,2,3,4);
	public static void main(String[] args) {
		
		//replacing traditional for loops
		IntStream.of(1,2,3).forEach(System.out::println);//1 2 3
		
		IntStream.range(1, 3).forEach(System.out::println);//1 2
		
		IntStream.rangeClosed(1, 3).forEach(System.out::println);//1 2 3
		
		//What if we just want every even number?
		IntStream.iterate(0, i -> i + 2).limit(3).forEach(System.out::println); //0 2 4
		
		
		IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).limit(3).forEach(System.out::println); // 
		// > 4, 1, 7
		
		
		
		
		
		num.stream()
			.filter(ListRevisit::check)
			.map(Color::new);
		
		Supplier orderSupplier = Order::new;
		System.out.println(orderSupplier.get());
	}
	
	
	public static Boolean check(int i)
	{
		if(i>5)
		return true;
		else
		return false;
	}
	
	
	
	
}
