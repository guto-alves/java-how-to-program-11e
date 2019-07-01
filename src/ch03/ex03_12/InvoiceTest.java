package ch03.ex03_12;

public class InvoiceTest {

	public static void main(String[] args) {
		Invoice invoice1 = new Invoice("321-56", "Mouse", 2, 7.50);
		Invoice invoice2 = new Invoice("321-57", "Computer", 1, 33999);

		System.out.printf(
				"INVOICE 1%nNumber: %s%nDescription: %s%nQuantity: %d%nPrice per item: $ %,.2f%nInvoice amount: $ %,.2f%n%n",
				invoice1.getNumber(), invoice1.getDescription(), invoice1.getQuantityPurchased(),
				invoice1.getPricePerItem(), invoice1.getInvoiceAmount());

		System.out.printf(
				"INVOICE 2%nNumber: %s%nDescription: %s%nQuantity: %d%nPrice per item: $ %,.2f%nInvoice amount: $ %,.2f",
				invoice2.getNumber(), invoice2.getDescription(), invoice2.getQuantityPurchased(),
				invoice2.getPricePerItem(), invoice2.getInvoiceAmount());
	}
}
