package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import models.User;

public class AccountService {

    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();

        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);

//                
//                String body = "Successful login by " + user.getFirstName() + " on " + (new java.util.Date()).toString();
//                GmailService.sendMail(email, "Successful Login", body, false);
//                
                /*
                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);
                 */
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public boolean forgotPassword(String email, String path) {
        UserService us = new UserService();

        User user = us.getByEmail(email);
        String body = "Successful login by " + user.getFirstName() + " on " + (new java.util.Date()).toString();
        try {
            
          
            String to = user.getEmail();
            String subject = "Notes App Login";
            String template = path + "\\emailtemplates\\login.html";

            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", user.getFirstName());
            tags.put("lastname", user.getLastName());
            tags.put("username", user.getEmail());
            tags.put("password", user.getPassword());
            GmailService.sendMail(to, subject, template, tags);
            

        } catch (MessagingException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
//                
        return true;
    }
}
