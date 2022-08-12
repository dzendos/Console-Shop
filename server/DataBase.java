package server;

import pages.PageFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the database.
 */
public class DataBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public int orderNo;
    public static DataBase dataBase;
    private PageFactory factory;
    private final List<User> users;

    public List<OrderInformation> orders;

    /**
     * Creates the new database.
     */
    private DataBase() {
        factory = PageFactory.getFactory();
        users = new ArrayList<>();
        orders = new ArrayList<>();
        orderNo = 1;
    }

    /**
     * Initializes the database.
     */
    public static void initialize() {
        dataBase = restoreDataBase();

        if (dataBase == null)
            dataBase = new DataBase();

        if (dataBase.factory == null) {
            PageFactory.initialize();
            dataBase.factory = PageFactory.getFactory();
        } else {
            PageFactory.setFactory(dataBase.factory);
        }
    }

    /**
     * Checks if the user is in database.
     * @param login the login of the searched user
     * @return true if the user is in database and false otherwise
     */
    public static boolean containsUser(String login) {
        boolean contains = false;

        for (User user : dataBase.users) {
            if (user.login.equals(login)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    /**
     * Adds new user to database.
     * @param user the user to be added.
     */
    public static void addUser(User user) {
        dataBase.users.add(user);
    }

    /**
     * Gets the reference to user by its information.
     * @param login the login of the user.
     * @param password the password of the user
     * @return the searched user
     */
    public static User getUserByData(String login, String password) {
        for (User user : dataBase.users) {
            if (user.login.equals(login) && user.password.equals(password))
                return user;
        }

        return null;
    }

    /**
     * Returns the list of all users.
     *
     * @return the list of all users
     */
    public static List<User> getUsers() {
        return  dataBase.users;
    }

    /**
     * Saves the database.
     */
    public static void save() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("database.db");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(dataBase);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert outputStream != null;
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Restores the database.
     * @return the restored database
     */
    public static DataBase restoreDataBase() {
        DataBase restoredDB = null;

        try {
            FileInputStream fileInputStream     = new FileInputStream("database.db");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            restoredDB = (DataBase) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return restoredDB;
    }
}
