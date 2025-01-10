import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = mock(UserDAO.class); // Mock the DAO
    }

    @Test
    void testSaveUser() {
        User user = new User("John Doe", "john@example.com", "password123");
        
        when(userDAO.saveUser(user)).thenReturn(user); // Simulate the DAO save operation

        User savedUser = userDAO.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("John Doe", savedUser.getName());
        assertEquals("john@example.com", savedUser.getEmail());
        assertEquals("password123", savedUser.getPassword());
    }

    @Test
    void testFindUserByEmail() {
        String email = "test@example.com";
        User expectedUser = new User("Test User", email, "password123");

        when(userDAO.findUserByEmail(email)).thenReturn(expectedUser);

        User foundUser = userDAO.findUserByEmail(email);

        assertNotNull(foundUser);
        assertEquals("Test User", foundUser.getName());
        assertEquals("test@example.com", foundUser.getEmail());
    }

    @Test
    void testFindUserByEmailNotFound() {
        when(userDAO.findUserByEmail("nonexistent@example.com")).thenReturn(null);

        User foundUser = userDAO.findUserByEmail("nonexistent@example.com");

        assertNull(foundUser);
    }
}
