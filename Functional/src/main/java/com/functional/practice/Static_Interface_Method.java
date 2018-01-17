/// Interface Changesin Java 8
package com.functional.practice;


// You can Public static methods to Interface.
interface Util {
	  public static int numberOfCores() {
	    return Runtime.getRuntime().availableProcessors();
	  }
	}

	public class Static_Interface_Method {
	  public static void main(String[] args) {
	    System.out.println(Util.numberOfCores());
	  }

	
	}