package com.oasis.infobyte;

import java.util.ArrayList;

public class Bank 
{

    private ArrayList<User> users;
    private User currentUser;

    public Bank() 
    {
        this.users = new ArrayList<>();
        this.currentUser = null;

        users.add(new User("1001", "1111", "Mou", "Sen", 100000.0));
        users.add(new User("1002", "2222", "Rose", "Manna", 100000.0));
        users.add(new User("1003", "3333", "Bittu", "Das", 100000.0));
        users.add(new User("1004", "4444", "Rayan", "Kundu", 100000.0));
        users.add(new User("1005", "5555", "Nil", "Dey", 100000.0));
        users.add(new User("1006", "6666", "Silky", "Singh", 100000.0));
        users.add(new User("1007", "7777", "S.D.", "Roy", 100000.0));

    }

    public boolean authenticateUser(String userID, String userPIN) 
    {
        for (User user : users) 
        {
            if (user.getUserID().equals(userID) && user.authenticate(userPIN)) 
            {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() 
    {
        return currentUser;
    }

    public User getUserByID(String userID) 
    {
        for (User user : users) 
        {
            if (user.getUserID().equals(userID)) 
            {
                return user;
            }
        }
        return null;
    }
}
