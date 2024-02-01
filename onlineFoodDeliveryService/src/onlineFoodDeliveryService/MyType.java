package onlineFoodDeliveryService;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MyType {

	static Scanner scanner = new Scanner(System.in);
	private static int numberOfProducts;
	private static int Default_Capacity = 10;
	private String item;
	private int customerNumber;
	private double price;
	public static MyType[] myBag = new MyType[Default_Capacity];
	static DecimalFormat formatting = new DecimalFormat("##.00");

	public static void main(String[] args) {
		constructor();
		scanner.close();
	}

	public static void add() {
		String itemName;
		int customerNumber;
		double price;
		int x = 0;
		//Duplicates array and resizes it
		System.out.println("Enter the max capacity of your cart.");
		Default_Capacity = scanner.nextInt();
		myBag = new MyType[Default_Capacity];
		scanner.nextLine();
		//Gets user's input for database
		while (isFull(x) == 0) {
			System.out.println("Enter food number: " + (x + 1));
			itemName = scanner.nextLine();
			System.out.println("Enter customer number: " + (x + 1));
			customerNumber = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter price number: " + (x + 1));
			price = scanner.nextDouble();
			scanner.nextLine();
			toArray(x, itemName, customerNumber, price, myBag);
			x = x + 1;
		}

		displayBag(myBag);
	}
	//checks to see if you want to run as a test or not
	public static void constructor() {
		System.out.println("Enter '1' for a test run, otherwise type 0.");
		int testNum = scanner.nextInt();
		if (testNum == 1) {
			testAdd();
		}

		else if (testNum == 0) {
			add();
		}
	}
	//puts inputted values into array
	public static MyType[] toArray(int x, String itemName, int customerNumber, double price, MyType[] myBag) {
		MyType cartItem = new MyType();
		cartItem.item = itemName;
		cartItem.price = price;
		cartItem.customerNumber = customerNumber;
		myBag[x] = cartItem;
		return myBag;
	}
	//checks to see if the array is full
	public static int isFull(int x) {
		if (x < Default_Capacity) {
			return 0;
		}

		else {
			return -1;
		}
	}
	//test run of the program, runs the program without user intervention and inserts values into database
	public static void testAdd() {
		String testItemName;
		int testCustomerNumber;
		double testPrice;
		int x = 0;
		while (isFull(x) == 0) {
			testItemName = "Food example number: " + String.valueOf(Math.round((Math.random() * 10)));
			testCustomerNumber = (int) (Math.random() * 100);
			testPrice = Math.random() * 100;
			testPrice = Math.round(testPrice);
			toArray(x, testItemName, testCustomerNumber, testPrice, myBag);
			x = x + 1;
		}
		displayBag(myBag);
	}
	//prints out customer's data
	public static void displayBag(MyType[] myBag) {
		numberOfProducts = Default_Capacity;
		for (MyType item : myBag) {
			System.out.println(
					"Item: " + item.item + ". Price: $" + formatting.format(item.price) + ". Customer number: " + item.customerNumber);
		}
		System.out.println("Total size of bag: " + numberOfProducts);
	}

}