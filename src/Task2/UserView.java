package Task2;

import Task2.Refactor_LSP.UserGetVip;

import java.util.Scanner;

public class UserView {
    private Scanner scanner;
    private DataUserView dataUserView;

    public UserView() {
        scanner = new Scanner(System.in);
        dataUserView = new DataUserView();
    }

    public void showUserData(UserModel model) {
        if (model.validateUserDefaultInModel()) {
            dataUserView = model.getDataUserView();

            String userData = dataUserView.getName() + ", " + dataUserView.getLogin() + ", " + dataUserView.getPassword();
            System.out.println("Данные пользователя: " + userData);
        } else {
            System.out.println("Пользователь не задан");
        }
    }

    public void showUserData(User user) {
        String userData = user.getName() + ", " + user.getLogin() + ", " + user.getPassword();
        if (user instanceof UserGetVip){
            userData += ", " + ((UserGetVip) user).getVipStatus();
        }
        System.out.println("Данные пользователя: " + userData);
    }

    public void showRegistrationForm() {
        System.out.println("Форма регистрации");
        System.out.print("Введите Ваше имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите Ваш логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите Ваш пароль: ");
        String password = scanner.nextLine();

        dataUserView.setName(name);
        dataUserView.setLogin(login);
        dataUserView.setPassword(password);
    }

    public void showLoginForm() {
        System.out.println("Форма входа");
        System.out.print("Введите Ваш логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите Ваш пароль: ");
        String password = scanner.nextLine();

        dataUserView.setLogin(login);
        dataUserView.setPassword(password);
    }

    public void showChangePasswordForm() {
        System.out.println("Форма смены пароля");
        System.out.print("Введите Ваш логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите Ваш текущий пароль: ");
        String password = scanner.nextLine();
        System.out.print("Введите новый пароль: ");
        String newPassword = scanner.nextLine();

        dataUserView.setLogin(login);
        dataUserView.setPassword(password);
        dataUserView.setNewPassword(newPassword);
    }

    public DataUserView getEnteredData() {
        // Получить введенные пользователем данные
        return dataUserView;
    }

    public void showRegistrationSuccess() {
        System.out.println("Регистрация прошла успешно!");
    }

    public void showEnterSuccess() {
        System.out.println("Вход выполнен!");
    }

    public void showEnterDenied() {
        System.out.println("Вход запрещен!");
    }

    public void showSetPasswordSuccess() {
        System.out.println("Пароль успешно изменен!");
    }

    public void showSetPasswordDenied() {
        System.out.println("Смена пароля запрещена!");
    }

    public void showUserPresent() {
        System.out.println("Пользователь уже зарегистрирован!");
    }
}