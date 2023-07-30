package Task2;

import Task2.Refactor_LSP.UserVip;
import Task2.Refactor_SPR_DIP.UserFileManager;

public class UserManagementApp {
    public static void main(String[] args) {
        UserFileManager userFileManager = new UserFileManager();
        UserModel model = new UserModel(userFileManager);
        UserView view = new UserView();

        UserVip userVip = new UserVip("Alex", "Uneld", "12345");

        model.setUser(userVip);

        UserPresenter presenter = new UserPresenter(model, view);

        view.showUserData(model.getUser());
        presenter.registerUser();
        presenter.loginUser();
        view.showUserData(model.getUser());
        presenter.changePassword();
        view.showUserData(model.getUser());


    }
}
