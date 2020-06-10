// Fig. 24.31: PersonQueries.java
// PreparedStatements used by the Address Book application.

package ch24.ex24_08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries {
	private static final String URL = "jdbc:derby:./src/ch24/ex24_08/AddressBook";
	private static final String USERNAME = "deitel";
	private static final String PASSWORD = "deitel";

	private Connection connection; // manages connection
	private PreparedStatement selectAllPeople;
	private PreparedStatement selectPeopleByLastName;
	private PreparedStatement insertNewPerson;
	private PreparedStatement updatePerson;
	private PreparedStatement deletePerson;

	// constructor
	public PersonQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// create query that selects all entries in the AddressBook
			selectAllPeople = connection.prepareStatement(
					"SELECT * FROM Addresses "
					+ "ORDER BY LastName, FirstName");

			// create query that selects entries with last names
			// that begin with the specified characters
			selectPeopleByLastName = connection.prepareStatement(
					"SELECT * FROM Addresses WHERE LastName LIKE ? " + 
					"ORDER BY LastName, FirstName");

			// create insert that adds a new entry into the database
			insertNewPerson = connection.prepareStatement(
					"INSERT INTO Addresses " + 
					"(FirstName, LastName, Email, PhoneNumber) " +
					"VALUES (?, ?, ?, ?)");

			updatePerson = connection.prepareStatement(
					"UPDATE Addresses " + 
					"SET FirstName = ?, LastName = ?, Email = ?, PhoneNumber = ? " +
					"WHERE AddressId = ?");
			
			deletePerson = connection.prepareStatement(
					"DELETE FROM Addresses WHERE AddressId = ?");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}

	// select all of the addresses in the database
	public List<Person> getAllPeople() {
		// executeQuery returns ResultSet containing matching entries
		try (ResultSet resultSet = selectAllPeople.executeQuery()) {
			List<Person> results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("AddressID"), resultSet.getString("FirstName"),
						resultSet.getString("LastName"), resultSet.getString("Email"),
						resultSet.getString("PhoneNumber")));
			}

			return results;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return null;
	}

	// select person by last name
	public List<Person> getPeopleByLastName(String lastName) {
		try {
			selectPeopleByLastName.setString(1, lastName); // set last name
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}

		// executeQuery returns ResultSet containing matching entries
		try (ResultSet resultSet = selectPeopleByLastName.executeQuery()) {
			List<Person> results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("FirstName"),
						resultSet.getString("LastName"), resultSet.getString("Email"),
						resultSet.getString("PhoneNumber")));
			}

			return results;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}

	// add an entry
	public int addPerson(String firstName, String lastName, String email, 
			String phoneNumber) {

		// insert the new entry; returns # of rows updated
		try {
			// set parameters
			insertNewPerson.setString(1, firstName);
			insertNewPerson.setString(2, lastName);
			insertNewPerson.setString(3, email);
			insertNewPerson.setString(4, phoneNumber);

			return insertNewPerson.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}

	public int updatePerson(int addressId, String firstName, String lastName, 
			String email, String phoneNumber) {
		try {
			updatePerson.setString(1, firstName);
			updatePerson.setString(2, lastName);
			updatePerson.setString(3, email);
			updatePerson.setString(4, phoneNumber);
			updatePerson.setInt(5, addressId);

			return updatePerson.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deletePerson(int addressId) {
		try {
			deletePerson.setInt(1, addressId);
			
			return deletePerson.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// close the database connection
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
