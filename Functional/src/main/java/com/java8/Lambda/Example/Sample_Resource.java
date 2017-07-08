package com.java8.Lambda.Example;

import java.util.function.Consumer;

public class Sample_Resource {
public static void main(String[] args) {

		Resource.use(e->{});
	}
}


class Resource{
	
	private Resource() {System.out.println("Created....");}
		public Resource op1(){System.out.println("op1"); return this;}
		public Resource op2(){System.out.println("op1"); return this;}
		public static void use(Consumer<Resource> block){
			Resource reource = new Resource();
			block.accept(reource);
		}
	}
