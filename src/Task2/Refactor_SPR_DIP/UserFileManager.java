package Task2.Refactor_SPR_DIP;

import Task2.User;

import java.io.*;

public class UserFileManager implements UserSaveRead {
    private final String fileName = "user.txt";

    @Override
    public void saveUser(User user) {
        try (FileWriter writer = new FileWriter(fileName)) {
            String writeData = user.getName() + "," + user.getLogin() + "," + user.getPassword();
            writer.write(writeData);
            System.out.println("Запись завершена.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User loadUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String readLine = reader.readLine();
            String[] readData = readLine.split(",");
            if (readData.length == 3) {
                User user = new User(readData[0], readData[1], readData[2]);
                System.out.println("Считывание завершено");
                return user;
            } else {
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл отсутствует");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
