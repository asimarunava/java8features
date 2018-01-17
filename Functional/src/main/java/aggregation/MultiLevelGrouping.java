/// Grouping Version 2 Multi Level
package aggregation;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Dress {
	String size;
	String color;
	String name;
	int price;

	public Dress(String size, String color, String name, int price) {
		super();
		this.size = size;
		this.color = color;
		this.name = name;
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dress [size=" + size + ", color=" + color + ", name=" + name + ", price=" + price + "]";
	}
}

public class MultiLevelGrouping {

	public static void main(String[] args) {
		List<Dress> dresses = Arrays.asList(new Dress("S", "RED", "Shirt", 10), new Dress("S", "RED", "Pant", 20),
				new Dress("M", "RED", "Shirt", 30), new Dress("L", "BLUE", "Shirt", 40),
				new Dress("XL", "BLUE", "Shirt", 50), new Dress("XL", "BLUE", "Pant", 60),
				new Dress("XXL", "GREEN", "Sweater", 70));

		// Second argument in any grouping can be any collector e.g. mapping, counting,
		// additional grouping. It could also be a toList()/toSet() like
		// groupingBy(Dress::getColor) means groupingBy(Dress::getColor, toList())

		// Below will generate a two dimensional grid color vs size
		System.out.println(dresses.stream()
				.collect(groupingBy(Dress::getColor, groupingBy(Dress::getSize))));

		// Using mapping to get only a particular attribute
		System.out.println(dresses.stream()
				.collect(groupingBy(Dress::getColor, groupingBy(Dress::getSize, mapping(Dress::getSize, toList())))));

		// Counting works too
		System.out.println(dresses.stream()
				.collect(groupingBy(Dress::getColor, groupingBy(Dress::getSize, counting()))));

		// Summation of price for each colored dress
		System.out.println(dresses.stream()
				.collect(groupingBy(Dress::getColor, summingInt(Dress::getPrice))));

		// Summarize attributes for each colored dress
		System.out.println(dresses.stream()
				.collect(groupingBy(Dress::getColor, summarizingInt(Dress::getPrice))));

		// find maximum priced dress in each color, but below gives optional
		System.out.println(dresses.stream()
				.collect(groupingBy(Dress::getColor, maxBy(Comparator.comparing(Dress::getPrice)))));

		// As above we will get Optional value, lets try to get actual values
		// ****************collectingAndThen*****************
		// is used to wrap another collector and apply transformation function to its
		// result as below Optional::get is the transformation function
		System.out.println(dresses.stream()
				.collect(groupingBy(Dress::getColor,
						collectingAndThen(maxBy(Comparator.comparing(Dress::getPrice)), Optional::get))));
	}

}
