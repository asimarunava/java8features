package com.java8.Lambda.Example;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.functional.practice.Order;

public class ListRevisit {
private static List<Integer> num = Arrays.asList(1,2,3,4);
	public static void main(String[] args) {
		
		
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
