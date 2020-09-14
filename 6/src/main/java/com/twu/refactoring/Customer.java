package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		while (rentals.hasNext()) {
			Rental each = rentals.next();

			double thisAmount = getAmount(each);

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			result.append(addFigures(each, thisAmount));
			totalAmount += thisAmount;

		}
		// add footer lines
		result.append(addFooterLines(totalAmount, frequentRenterPoints));
		return result.toString();
	}

	private double getAmount(Rental rental) {
		double amount =0;
		switch (rental.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				amount += 2;
				if (rental.getDaysRented() > 2)
					amount += (rental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				amount += rental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				amount += 1.5;
				if (rental.getDaysRented() > 3)
					amount += (rental.getDaysRented() - 3) * 1.5;
				break;
		}
		return amount;
	}

	private String addFigures(Rental rental, double amount) {
		return "\t" + rental.getMovie().getTitle() + "\t"
				+ amount + "\n";
	}

	private String addFooterLines(double totalAmount, int frequentRenterPoints) {
		String result = "";
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

}
