package ua.lviv.lgs;

import java.util.*;
import java.util.stream.Stream;

public class Fraction extends verkhovnaRada {

	String name;

	Fraction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRandomValue(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public boolean getRandomValueBoolean() {
		Random r = new Random();
		return r.nextBoolean();
	}
	
	//hw23

	public List<Deputy> removeDeputy(List<Deputy> d) {
		System.out.println("Enter Deputy name(He will be removed): ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		Iterator<Deputy> deputyIterator = d.iterator();

		Deputy deputy = deputyIterator.next();

		d.removeIf(x -> x.getName().equals(name));
		return d;
	}
	
	//hw23

	public void allBribeTakersShow(List<Deputy> d) {
		Stream<Deputy> stream = d.stream();

		stream.filter(x -> x.isBribeTaker() == true).forEach(System.out::println);
	}
	
	// hw23

	public void showAllDeputies(List<Deputy> d) {

		System.out.println("Enter fraction name: ");

		Scanner sc = new Scanner(System.in);
		String fName = sc.next();
		
		Stream<Deputy> stream = d.stream();
		
		stream.filter(x -> x.getFraction().toString().equals(fName)).forEach(System.out::println);

	}

	public List<Deputy> removeAll(List<Deputy> d) {
		Stream<Deputy> deputy = d.stream();
		
		deputy.forEach(x -> d.remove(x));
		return d;
	}

	public String toString() {
		return "Fraction{" + "name='" + name + '\'' + '}';
	}
}