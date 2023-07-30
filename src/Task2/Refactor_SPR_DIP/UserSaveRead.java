package Task2.Refactor_SPR_DIP;

import Task2.User;

public interface UserSaveRead {
    void saveUser(User user);
    User loadUser();
}
