package Task2;

import Task2.Refactor_SPR_DIP.UserFileManager;

import java.io.*;

public class UserModel {
    private final String defaultString = "Default";
    private User user;

    UserFileManager userFileManager;

    private boolean flagSuccessRead = false;

    public UserModel(UserFileManager userFileManager) {
        this.user = new User(defaultString, defaultString, defaultString);
        this.userFileManager = userFileManager;
        loadUserData();
    }

    public boolean isFlagSuccessRead() {
        return flagSuccessRead;
    }

    public String getName() {
        return user.getName();
    }

    public String getLogin() {
        return user.getLogin();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public boolean checkUser(DataUserView dataUserView) {
        return this.user.getName().equals(dataUserView.getName()) && this.user.getLogin().equals(dataUserView.getLogin());
    }

    public boolean validateUserDefaultInModel() {
        String name = user.getName();
        String login = user.getLogin();
        String password = user.getPassword();
        return !(name.equals(defaultString) || login.equals(defaultString) || password.equals(defaultString));
    }

    public DataUserView getDataUserView() {
        DataUserView data = new DataUserView();
        data.setName(user.getName());
        data.setLogin(user.getLogin());
        data.setPassword(user.getPassword());

        return data;
    }

    boolean validateLogPass(DataUserView dataUserView) {
        return this.user.getLogin().equals(dataUserView.getLogin()) && this.user.getPassword().equals(dataUserView.getPassword());
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setPassword(String password) {
        this.user.setPassword(password);
    }

    // Методы сохранения и загрузки данных пользователя
    public void saveUserData() {
        if (validateUserDefaultInModel()) {
            userFileManager.saveUser(user);
        } else {
            System.out.println("Не верные данные пользователя");
        }
    }

    public void loadUserData() {
        User temp =  userFileManager.loadUser();
        if (temp != null){
            user.setName(temp.getName());
            user.setLogin(temp.getLogin());
            user.setPassword(temp.getPassword());
            flagSuccessRead = true;
        } else {
            flagSuccessRead = false;
            System.out.println("Ошибка считывания");
        }
    }
}
