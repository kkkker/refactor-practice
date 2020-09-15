package com.twu.refactoring;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		String headers = "======Printing Orders======\n";
		output.append(headers);

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
		addLineItem(output);

		return output.toString();
	}

	private void addLineItem(StringBuilder output) {
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');

			final double taxRate = .10;
            double salesTax = lineItem.totalAmount() * taxRate;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totSalesTx);

		output.append("Total Amount").append('\t').append(tot);
	}
}