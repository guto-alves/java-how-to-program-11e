/*
 * Objetivo: 3.12 (Classe Invoice) Crie uma classe chamada Invoice para que 
 * uma loja de suprimentos de informática a utilize para representar uma 
 * fatura de um item vendido nela. Uma Invoice (fatura) deve incluir quatro 
 * partes das informações como variáveis de instância — o número 
 * (tipo String), a descrição (tipo String), a quantidade comprada de um 
 * item (tipo int) e o preço por item (double). Sua classe deve ter um 
 * construtor que inicializa as quatro variáveis de instância. Forneça um
 * método set e um get para cada variável de instância. Além disso, forneça 
 * um método chamado getInvoiceAmount que calcula o valor de fatura (isto é, 
 * multiplica a quantidade pelo preço por item) e depois retorna esse valor 
 * como double. Se a quantidade não for positiva, ela deve ser configurada 
 * como 0. Se o preço por item não for positivo, ele deve ser configurado 
 * como 0.0. Escreva um aplicativo de teste chamado InvoiceTest que 
 * demonstra as capacidades da classe Invoice.
 * 
 * Autor: Gustavo Alves
 */

package ch03.ex03_12;

public class Invoice {
	private String number;
	private String description;
	private int quantityPurchased;
	private double pricePerItem;

	public Invoice(String number, String description, int quantityPurchased, double pricePerItem) {
		this.setNumber(number);
		this.setDescription(description);
		this.setQuantityPurchased(quantityPurchased);
		this.setPricePerItem(pricePerItem);
	}

	public double getInvoiceAmount() {
		return quantityPurchased * pricePerItem;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased < 0 ? 0 : quantityPurchased;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem < 0 ? 0.0 : pricePerItem;
	}
}
