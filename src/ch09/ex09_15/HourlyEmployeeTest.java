/*
 * Objetivo: 9.15 (Criando uma nova subclasse de Employee) Outros tipos de 
 * Employees podem incluir SalariedEmployees, que recebem um salário 
 * semanal fixo; PieceWorkers, que são pagos pelo número de peças que 
 * produzem; ou HourlyEmployees, que recebem um valor 50% maior para as 
 * horas extras. Crie uma classe HourlyEmployee, que é herdada da classe
 * Employee (Exercício 9.14), e tem variáveis de instância hours 
 * (um double), que representa as horas trabalhadas, e wage (um double), 
 * que representa os salários por hora, além de um construtor que recebe 
 * como argumentos primeiro nome, sobrenome, número de seguro social, 
 * salário por hora e número de horas trabalhadas, métodos set e get  para 
 * manipular hours e wage, um método earnings para calcular os rendimentos 
 * de um HourlyEmployee com base nas horas trabalhadas e um método toString 
 * que retorna a representação String de HourlyEmployee. O método setWage
 * deve assegurar que wage não seja negativo, e setHours, que o valor das 
 * horas esteja entre 0 e 168 (o número total de horas em uma semana). Use 
 * a classe HourlyEmployee em um programa de teste, semelhante ao da 
 * Figura 9.5.
 * 
 * Autor: Gustavo Alves
 */

package ch09.ex09_15;

public class HourlyEmployeeTest {

	public static void main(String[] args) {
		HourlyEmployee employee = new HourlyEmployee("Sue", "Jones", "222-22-2222", 100, 20);

		System.out.println("Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
		System.out.printf("%s %s%n", "Last name is", employee.getLastName());
		System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
		System.out.printf("%s %s%n", "Hours is", employee.getHours());
		System.out.printf("%s %,.2f%n", "Wage is", employee.getWage());

		System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee);
	}
}
