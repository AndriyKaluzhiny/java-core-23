package ua.lviv.lgs.maxPart2;

import java.util.*;
import java.util.stream.Stream;

public class Commodity {
    String name;
    double length;
    double width;
    double weight;
    int num;

    public Commodity(String name, double length, double width, double weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.weight = weight;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Double.compare(commodity.length, length) == 0 && Double.compare(commodity.width, width) == 0 && Double.compare(commodity.weight, weight) == 0 && num == commodity.num && name.equals(commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, width, weight, num);
    }

    public HashSet<Commodity> addProduct(HashSet<Commodity> c) {
        System.out.println("Enter product name: ");
        Scanner scName = new Scanner(System.in);
        String pName = scName.next();

        System.out.println();

        System.out.println("Enter product length: ");
        Scanner scLength = new Scanner(System.in);
        Double pLength = scLength.nextDouble();

        System.out.println();

        System.out.println("Enter product width: ");

        Scanner scWidth = new Scanner(System.in);
        Double pWidth = scWidth.nextDouble();

        System.out.println();

        System.out.println("Enter product weight: ");
        Scanner scWeight = new Scanner(System.in);
        Double pWeight = scWeight.nextDouble();

        Commodity commodity = new Commodity(pName, pLength, pWidth, pWeight);

        c.add(commodity);

        return c;
    }

    public HashSet<Commodity> removeProduct(HashSet<Commodity> c) throws DoesntExistsException {
        for (Object o : c) {
            System.out.println(o);
        }

        System.out.println();
        System.out.println("What product do you want to delete: ");
        System.out.println();
        System.out.println("Enter product name: ");
        Scanner scName = new Scanner(System.in);
        String pName = scName.next();
        
        Stream<Commodity> s = c.stream();
        
        s.filter(x -> x.getName().equals(name)).forEach(c::remove);
        
        return c;
    }

    public HashSet<Commodity> ExchangeProduct(HashSet<Commodity> c) throws DoesntExistsException {
        System.out.println("Enter product name: ");
        Scanner scName = new Scanner(System.in);
        String pName = scName.next();

        System.out.println();

        System.out.println("Enter product length: ");
        Scanner scLength = new Scanner(System.in);
        Double pLength = scLength.nextDouble();

        System.out.println();

        System.out.println("Enter product width: ");

        Scanner scWidth = new Scanner(System.in);
        Double pWidth = scWidth.nextDouble();

        System.out.println();

        System.out.println("Enter product weight: ");
        Scanner scWeight = new Scanner(System.in);
        Double pWeight = scWeight.nextDouble();

        Commodity commodity = new Commodity(pName, pLength, pWidth, pWeight);

        System.out.println("Enter product name: ");
        Scanner scNameE = new Scanner(System.in);
        String pNameE = scName.next();

        System.out.println();

        System.out.println("Enter product length: ");
        Scanner scLengthE = new Scanner(System.in);
        Double pLengthE = scLength.nextDouble();

        System.out.println();

        System.out.println("Enter product width: ");

        Scanner scWidthE = new Scanner(System.in);
        Double pWidthE = scWidth.nextDouble();

        System.out.println();

        System.out.println("Enter product weight: ");
        Scanner scWeightE = new Scanner(System.in);
        Double pWeightE = scWeight.nextDouble();

        Commodity commodityExchanged = new Commodity(pNameE, pLengthE, pWidthE, pWeightE);

        if (c.contains(commodity)) {
            c.remove(commodity);
            c.add(commodityExchanged);
        } else
            System.out.println("Nydadadada");
        return c;
    }

    public void sortByName(HashSet<Commodity> c) {
        c.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);
    }

    public void sortByLength(HashSet<Commodity> c) {
    	c.stream().sorted(Comparator.comparing(Commodity::getLength)).forEach(System.out::println);
    }

    public void sortByWidth(HashSet<Commodity> c) {
    	c.stream().sorted(Comparator.comparing(Commodity::getWidth)).forEach(System.out::println);
    }

    public void sortByWeight(HashSet<Commodity> c) {
    	c.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);
    }

    public void removeProductByCount(HashSet<Commodity> c) throws DoesntExistsException {
        for (Object o : c) {
            System.out.println(o);
        }

        System.out.println("Enter number of product: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Commodity> l = new ArrayList<>(c);

        System.out.println(l.get(num - 1));
    }

    public void Exit() {
        System.exit(1);
    }
        public static int getRandomValue(int max, int min) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}