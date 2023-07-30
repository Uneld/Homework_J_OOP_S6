package Task2;

public class UserPresenter {
    private UserModel model;
    private UserView view;

    public UserPresenter(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void registerUser() {
        view.showRegistrationForm();
        DataUserView data = view.getEnteredData();

        if (model.checkUser(data)) {
            view.showUserPresent();
        } else {
            model.setUser(new User(data.getName(), data.getLogin(), data.getPassword()));
            model.saveUserData();
            view.showRegistrationSuccess();
        }
    }

    public void loginUser() {
        view.showLoginForm();
        DataUserView data = view.getEnteredData();
        if (model.validateLogPass(data)) {
            view.showEnterSuccess();
        } else {
            view.showEnterDenied();
        }
    }

    public void changePassword() {
        view.showChangePasswordForm();
        DataUserView data = view.getEnteredData();
        if (model.validateLogPass(data)) {
            model.setPassword(data.getNewPassword());
            view.showSetPasswordSuccess();
            model.saveUserData();
        } else {
            view.showSetPasswordDenied();
        }
    }
}
