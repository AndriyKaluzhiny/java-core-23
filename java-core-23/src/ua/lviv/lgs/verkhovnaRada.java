package ua.lviv.lgs;

import java.util.*;
import java.util.stream.Stream;

public class verkhovnaRada implements Randomable {

	public List<Fraction> addFraction(List<Fraction> fractionList) {
		System.out.println("Enter fraction name: ");
		Scanner sc = new Scanner(System.in);
		String fName = sc.next();

		Fraction f = new Fraction(fName);

		fractionList.add(f);

		return fractionList;
	}

	public List<Fraction> removeFraction(List<Fraction> fractionList) {
		System.out.println("Enter fraction name(it will be removed): ");
		Scanner sc = new Scanner(System.in);
		String fName = sc.next();

		fractionList.removeIf(f -> f.getName().equals(fName));
		return fractionList;
	}

	public void showAll(List<Fraction> f) {
		System.out.println(f.toString());
	}

	// hw 23

	public void showByName(List<Fraction> f) {
		Scanner sc = new Scanner(System.in);
		String fName = sc.next();

		Stream<Fraction> fraction = f.stream();

		fraction.filter(x -> x.getName().equals(fName)).forEach(System.out::println);
	}
	
	//hw 23

	public List<Deputy> AddDeputyToFraction(List<Deputy> deputyList, List<Fraction> f)
			throws alreadyExists, WrongInputException {
		System.out.println("Enter deputy name(He will be added to fraction): ");
		Scanner sc = new Scanner(System.in);
		String dName = sc.next();

		System.out.println("Enter deputy surname: ");
		Scanner sc2 = new Scanner(System.in);
		String dSurname = sc2.next();

		System.out.println("Choose your fraction: ");

		System.out.println(f);

		Scanner sc4 = new Scanner(System.in);
		String inputFraction = sc2.next();

		Stream<Deputy> d = deputyList.stream();

		d.filter(x -> x.getName().equals(dName) && x.getSurname().equals(dSurname))
				.forEach(x -> x.setFraction(inputFraction));

		return deputyList;

	}

	public List<Deputy> removeDeputy(List<Deputy> d) throws WrongInputException {
		System.out.println("Enter deputy name(He will be removed): ");
		Scanner sc = new Scanner(System.in);
		String dName = sc.next();

		System.out.println("Enter deputy surname: ");
		Scanner sc2 = new Scanner(System.in);
		String dSurname = sc.next();

		d.removeIf(next -> next.getName().equals(dName) && next.getSurname().equals(dSurname));
		return d;
	}

	public List<Deputy> addDeputy(List<Deputy> d) {
		Scanner scanner = new Scanner(System.in);
		String dName = scanner.next();

		Scanner sc2 = new Scanner(System.in);
		String dSurname = sc2.next();

		Scanner sc3 = new Scanner(System.in);
		int dAge = sc3.nextInt();

		Deputy newDeputy = new Deputy(getRandomValue(140, 200), getRandomValue(50, 100), dName, dSurname, null, dAge,
				getRandomValueBoolean(), 0);

		newDeputy.giveBribe(newDeputy);

		d.add(newDeputy);

		return d;
	}

	// reworked hw23

	public void showAllBribeTakers(List<Deputy> d) {
		Stream<Deputy> stream = d.stream();

		stream.filter(x -> x.bribeTaker == true).forEach(System.out::println);

	}

	// reworked hw23

	public void showAllDeputiesOfFraction(List<Deputy> deputyList) {
		Scanner sc = new Scanner(System.in);
		String nameOfFraction = sc.next();

		Stream<Deputy> d = deputyList.stream();

		d.filter(x -> x.fraction.equals(nameOfFraction)).forEach(System.out::println);
	}

	private boolean getRandomValueBoolean() {
		Random r = new Random();
		return r.nextBoolean();
	}

	@Override
	public int getRandomValue(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
}