package com.functional.practice;

import java.awt.Color;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Order {
private String orderNo="dsd";
	
	
public static void main(String[] args) {
	IntStream.of(1, 2, 3); 
	IntStream.range(0,10).forEach(System.out::println);
	Stream<Color> stream = IntStream.range(1, 5).mapToObj(i -> new Color(i));
}

@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return orderNo.length();
	}
}
