/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import models.User;

/**
 *
 * @author 854276
 */
public class UserService {

    public User getByEmail(String email) {
        UserDB userDB = new UserDB();
        User user = userDB.getUserByEmail(email);
        return user;

    }
}
