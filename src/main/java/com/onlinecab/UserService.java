public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User registerUser(String name, String email, String password) {
        User user = new User(name, email, password);
        return userDAO.saveUser(user);
    }

    public User loginUser(String email, String password) {
        User user = userDAO.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
