/*
 * 8.14 (Classe Data) Crie uma classe Date com as seguintes capacidades:
 * a) Gerar saída da data em múltiplos formatos, como
 * 
 * 	MM/DD/YYYY 
 * 	June 14, 1992 
 * 	DDD YYYY
 * 
 * b) Utilizar construtores sobrecarregados para criar objetos Date 
 * 	inicializados com datas dos formatos na parte (a). No primeiro caso, 
 * 	o construtor deve receber três valores inteiros. No segundo caso, 
 * 	deve receber uma String e dois valores inteiros. No terceiro caso, 
 * 	deve receber dois valores inteiros, o primeiro representando o número
 * 	de dias no ano. [Dica: para converter a representação de String do mês 
 * 	em um valor numérico, compare as Strings utilizando o método equals. 
 * 	Por exemplo, se s1 e s2 forem strings, a chamada de método 
 * 	s1.equals(s2) retornará true se as strings forem idênticas, caso 
 * 	contrário retornará false.]
 */

package ch08.ex08_14;

public class Date {
	public final static int MM_DD_YYYY = 1;
	public final static int Month_DD_YYYY = 2;
	public final static int DDD_YYYY = 3;

	private final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	private int day;
	private int year;
	private int month;
	private int numberOfDaysPerYear;

	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		numberOfDaysPerYear = calculateNumberOfDaysPerYear();
	}

	public Date(String month, int day, int year) {
		for (int i = 1; i < months.length; i++) {
			if (months[i].equals(month))
				this.month = i;
		}

		this.day = day;
		this.year = year;
		numberOfDaysPerYear = calculateNumberOfDaysPerYear();
	}

	public Date(int numberOfDaysPerYear, int year) {
		this.numberOfDaysPerYear = numberOfDaysPerYear;
		this.year = year;
		month = 1;

		for (int i = 1; i < daysPerMonth.length; i++) {
			if (numberOfDaysPerYear - daysPerMonth[i] > 0) {
				numberOfDaysPerYear -= daysPerMonth[i];
				month++;
			} else
				break;
		}

		day = numberOfDaysPerYear;
	}

	public void display(int format) {
		switch (format) {
		case MM_DD_YYYY:
			System.out.printf("%02d/%02d/%d%n", month, day, year);
			break;
		case Month_DD_YYYY:
			System.out.printf("%s %02d, %d%n", months[month], day, year);
			break;
		case DDD_YYYY:
			System.out.printf("%03d %d%n", numberOfDaysPerYear, year);
			break;
		default:
			break;
		}
	}

	private int calculateNumberOfDaysPerYear() {
		int numberOfDaysPerYear = day;

		for (int i = 1; i < daysPerMonth.length; i++) {
			if (i < month)
				numberOfDaysPerYear += daysPerMonth[i];
			else
				break;
		}
		return numberOfDaysPerYear;
	}
}
