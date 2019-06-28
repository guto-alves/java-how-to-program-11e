/*
 * Objetivo: 3.14 (Classe Date) Crie uma classe chamada Date que inclua 
 * três variáveis de instância — mês (tipo int), dia (tipo int) e ano 
 * (tipo int). Forneça um construtor que inicializa as três variáveis 
 * de instância supondo que os valores fornecidos estejam corretos. 
 * Ofereça um método set e um get para cada variável de instância. 
 * Apresente um método displayDate que exiba mês, dia e ano separados 
 * por barras normais (/). Escreva um aplicativo de teste chamado
 * DateTest que demonstre as capacidades da classe Date.
 * 
 * Autor: Gustavo Alves
 */

package ch03.ex03_14;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date(3, 27, 2000);

		date.displayDate();

		date.setMonth(06);
		date.setDay(28);
		date.setYear(2019);

		date.displayDate();
	}
}
