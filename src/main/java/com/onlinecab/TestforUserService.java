import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserService userService;
    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = mock(UserDAO.class);
        userService = new UserService(userDAO);
    }

    @Test
    void testRegisterUser() {
        User user = new User("John Doe", "john@example.com", "password123");

        when(userDAO.saveUser(user)).thenReturn(user);

        User registeredUser = userService.registerUser("John Doe", "john@example.com", "password123");

        assertNotNull(registeredUser);
        assertEquals("John Doe", registeredUser.getName());
    }

    @Test
    void testLoginUserSuccess() {
        User user = new User("Test User", "test@example.com", "password123");

        when(userDAO.findUserByEmail("test@example.com")).thenReturn(user);

        User loggedInUser = userService.loginUser("test@example.com", "password123");

        assertNotNull(loggedInUser);
        assertEquals("Test User", loggedInUser.getName());
    }

    @Test
    void testLoginUserFail() {
        when(userDAO.findUserByEmail("test@example.com")).thenReturn(null);

        User loggedInUser = userService.loginUser("test@example.com", "wrongpassword");

        assertNull(loggedInUser);
    }
}
