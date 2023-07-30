package Task2.Refactor_LSP;

import Task2.User;

public class UserVip extends User implements UserGetVip {
    String status;
    public UserVip(String name, String login, String password) {
        super(name, login, password);
        this.status = "VIP";
    }

    @Override
    public String getVipStatus() {
        return status;
    }
}
