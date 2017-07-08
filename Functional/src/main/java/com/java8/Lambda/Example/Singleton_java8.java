package com.java8.Lambda.Example;

import java.util.function.Consumer;

public class Singleton_java8 {
public static void main(String[] args) {

		Resource.use(e->e.op1());
	}
}

//Creating Singleton Using Lambda
class Resource{
	
	private Resource() {System.out.println("Created....");}
		public Resource op1(){System.out.println("op1"); return this;}
		public Resource op2(){System.out.println("op2"); return this;}
		public static void use(Consumer<Resource> block){
			Resource reource = new Resource();
			block.accept(reource);
		}
	}
