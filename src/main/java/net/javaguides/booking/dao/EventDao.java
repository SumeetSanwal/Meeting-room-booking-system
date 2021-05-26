package net.javaguides.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.booking.model.Event;

public class EventDao {
	public int registerEvent(Event event) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO booking" +
            "  (room, e_from, e_to, dt, path,description) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/wtproj?useSSL=false", "root", "sansanwal");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, event.getRoom());
            preparedStatement.setString(2, event.getFrom());
            preparedStatement.setString(3, event.getTo());
            preparedStatement.setString(4, event.getDt());
            preparedStatement.setString(5, event.getPath());
            preparedStatement.setString(6, event.getDescription());
            

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	
	public static List<Event> selectAllEvents() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Event> events = new ArrayList<>();
		// Step 1: Establishing a Connection
//		Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/wtproj?useSSL=false", "root", "sansanwal");

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from booking;");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String room = rs.getString("room");
				String e_from = rs.getString("e_from");
				String e_to = rs.getString("e_to");
				String dt = rs.getString("dt");
				String description = rs.getString("description");
				
				events.add(new Event(id, room, e_from, e_to, dt, description));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return events;
	}

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

