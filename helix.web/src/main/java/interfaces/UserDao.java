package interfaces;

import model.User;

public interface UserDao {
    void persistUser(User user);
    User uploadUser(String login,String password);
    public void modifyUser(User user);
    public void removeUser(User user);
}