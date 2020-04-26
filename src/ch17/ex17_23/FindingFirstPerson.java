/* 17.23 (Finding the First Person with a Specified Last Name) Create a
collection of Person objects in which each Person has a firstName
and a lastName. Use streams to locate the first Person object
containing the last name Jones. Ensure that several Person objects in
your collection have that last name. */

package ch17.ex17_23;

import java.util.List;
import java.util.function.Predicate;

public class FindingFirstPerson {

	public static void main(String[] args) {
		List<Person> persons = List.of(
				new Person("Albert", "Einstein"),
				new Person("Gustavo", "Alves"),
				new Person("William", "Jones"),
				new Person("Peter", "Jones"), 
				new Person("Larissa", ""),
				new Person("Thomas", "Jones."));
		
		Predicate<Person> lastName = 
				person -> person.getLastName().equals("Jones");
		
		System.out.println(persons.stream()
				.filter(lastName)
				.findFirst()
				.get());
	}

}
