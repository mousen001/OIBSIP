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

        users.add(new User("101", "1111", "SOURAV", "DEY", 100000.0));
        users.add(new User("102", "2222", "SUCHISMITA", "SEN", 100000.0));
        users.add(new User("103", "3333", "SAUMYO", "DAS", 100000.0));
        users.add(new User("104", "4444", "TWINKEL", "MANNA", 100000.0));
        users.add(new User("105", "5555", "SOURAYAN", "KUNDU", 100000.0));
        users.add(new User("106", "6666", "SILKY", "SINGH", 100000.0));
        users.add(new User("107", "7777", "SAYAN", "DUTTA ROY", 100000.0));

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
