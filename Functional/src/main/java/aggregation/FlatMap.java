/// This is for FlatMap
package aggregation;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {
		/*
		 * Given two lists of numbers, how would you return all pairs of numbers? For
		 * example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3),
		 * (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
		 */
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		System.out.println(numbers1.stream()
				.flatMap(i -> numbers2.stream()
						.map(j -> "[" + i + "," + j + "]"))
				.collect(toList()));

		// ["Hello", "World"] youd like to return the list ["H", "e", "l", "o","W",
		// "r", "d"]
		String[] words = { "hello", "world" };
		System.out.println(Arrays.stream(words)
				.map(e -> e.split(""))
				.flatMap(Arrays::stream)
				.collect(toList()));

		// Having a 2 dimentional list of objects e.g. List<List<Integer>> create a
		// single stream
		List<List<Integer>> twoDimentionalList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
		System.out.println(twoDimentionalList.stream()
				.flatMap(Collection::stream)
				.collect(toList()));

		// Stream.of always gives a stream of whatever is passed as argument, e.g. below is a stream of arrays/lists
		List<String> x = Arrays.asList("hello", "world");
		System.out.println(Stream.of(x)
				.map(e -> e + "!")
				.collect(toList()));

		System.out.println(Stream.of("hello", "world")
				.map(e -> e + "!")
				.collect(toList()));

		System.out.println(x.stream()
				.map(e -> e + "!")
				.collect(toList()));

		List<Integer> y = Arrays.asList(1, 3);
		System.out.println(Stream.of(1, 2, 3)
				.collect(toList()));
		System.out.println(y.stream()
				.collect(toList()));

	}

}
