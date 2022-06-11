package ua.lviv.lgs.max;

import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Application {
	public static void main(String[] args) {
		HashSet<Car> hs = new HashSet<>();
		hs.add(new Car("Audi", 1));
		hs.add(new Car("Mercedes", 2));
		hs.add(new Car("Mazda", 3));
		hs.add(new Car("Lamborghini", 4));

		System.out.println("Before sorting(Power): ");

		hs.stream().forEach(System.out::println);

		System.out.println();

		System.out.println("After sorting(Power): ");

		hs.stream().sorted(Comparator.comparingInt(Car::getPower)).collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println();

		System.out.println("Before sorting(Name): ");

		hs.stream().forEach(System.out::println);

		System.out.println();

		System.out.println("After sorting(Name): ");

		hs.stream().sorted(Comparator.comparing(Car::getName)).collect(Collectors.toList())
				.forEach(System.out::println);

	}
}