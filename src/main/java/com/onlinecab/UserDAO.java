public class UserDAO {

    public User saveUser(User user) {
        // Simulate saving user to the database
        // In real implementation, you would use JDBC, JPA, or Hibernate
        return user; // Just returns the user object for simplicity
    }

    public User findUserByEmail(String email) {
        // Simulate retrieving a user by email from the database
        if ("test@example.com".equals(email)) {
            return new User("Test User", email, "password123");
        }
        return null;
    }
}
