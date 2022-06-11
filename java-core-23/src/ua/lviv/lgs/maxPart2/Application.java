package ua.lviv.lgs.maxPart2;

import java.util.HashSet;
import java.util.Scanner;

public class Application {
    public static void menu() {
        System.out.println("Enter 1 for task 1");
        System.out.println("Enter 2 for task 2");
        System.out.println("Enter 3 for task 3");
        System.out.println("Enter 4 for task 4");
        System.out.println("Enter 5 for task 5");
        System.out.println("Enter 6 for task 6");
        System.out.println("Enter 7 for task 7");
        System.out.println("Enter 8 for task 8");
        System.out.println("Enter 9 to exit");
    }

    public static void main(String[] args) throws DoesntExistsException {

        HashSet<Commodity> hs = new HashSet<>();
        Commodity commodity = new Commodity(null, 0, 0, 0);

        while (true) {
            menu();

            System.out.println();

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    commodity.addProduct(hs);
                    for (Object o : hs) {
                        System.out.println(o);
                    }
                    break;
                }
                case 2: {
                    commodity.removeProduct(hs);
                    for (Object o : hs) {
                        System.out.println(o);
                    }
                    break;
                }
                case 3: {
                    commodity.ExchangeProduct(hs);
                    for (Object o : hs) {
                        System.out.println(o);
                    }
                    break;
                }
                case 4: {
                    commodity.sortByName(hs);
                    break;
                }
                case 5: {
                    commodity.sortByLength(hs);
                    break;
                }
                case 6: {
                    commodity.sortByWidth(hs);
                    break;
                }

                case 7: {
                    commodity.sortByWeight(hs);
                    break;
            }

                case 8: {
                    commodity.removeProductByCount(hs);
                    break;

                }

                case 9:
                    commodity.Exit();
            }
        }
    }
}