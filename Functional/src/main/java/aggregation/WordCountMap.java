/// Word Count Without Split
package aggregation;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.regex.Pattern;

public class WordCountMap {

	public static void main(String[] args) {
		String x = "the best of the best of the best of the";

		System.out.println(Pattern.compile("\\s")
				.splitAsStream(x)
				.filter(e -> e.equals("two"))
				.findFirst()
				.orElse("nothing"));

		System.out.println(Pattern.compile("\\s")
				.splitAsStream(x)
				.parallel()
				.collect(groupingBy(String::toString, counting())));
		
		//BTW string.split is faster if the delimiter is a simple character
	}

}
