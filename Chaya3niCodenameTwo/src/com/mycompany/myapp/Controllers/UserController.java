/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Controllers;

import static com.mycompany.myapp.Controllers.ComplaintController.listOfBooks;
import com.mycompany.myapp.Entities.SimpleUser;
import com.mycompany.myapp.Forms.*;
import com.mycompany.myapp.Tools.OtherTools;
import com.codename1.components.InteractionDialog;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class UserController {

    private ConnectionRequest connectionRequest;
    public static Form listOfBooks;

    
        public void addUserFacebook(SimpleUser user) {  
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
                InteractionDialog d = new InteractionDialog("Registration");
                TextArea popupBody = new TextArea("Registration successful");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                Button ok = new Button("OK");
                ok.addActionListener((ee) -> d.dispose());
                d.addComponent(BorderLayout.SOUTH, ok);
                d.show(0, 0, 0, 0);
                new MenuForm().show();
            }
        };
        String url = "http://localhost/pidevnameone/insertuser.php?name="
                + user.getName() + "&surname=" + user.getSurname() + "&username=" + user.getUsername() + "&email=" + user.getEmail()
                + "&password=" + user.getPass() + "&telephone=" + user.getTelephone() + "&datebirth=" + user.getDateBirth()
                + "&dateinscription=" + user.getDateInscription() + "&address1=" + user.getAddress1() + "&address2="
                + user.getAddress2() + "&codepostal=" + user.getCodePostal() + "&gender=" + user.getGender()
                + "&newsletter=" + user.getNewsletter() + "&secretquestion=" + user.getSecretQuestion()
                + "&secretanswer=" + user.getSecretAnswer()
                + "&photo=" + user.getPhoto();
        System.err.println(url);
        connectionRequest.setUrl(url);
        NetworkManager.getInstance().addToQueue(connectionRequest);
        getUser(user.getUsername(),user.getPass());
      
        
}

    
    public void addUser(SimpleUser user) {
        
        notexist(user);
        System.out.println("*******************************");
        System.out.println(SimpleUser.isStatus());
        if (SimpleUser.isStatus())
        {
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
                InteractionDialog d = new InteractionDialog("Registration");
                TextArea popupBody = new TextArea("Registration successful");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                Button ok = new Button("OK");
                ok.addActionListener((ee) -> d.dispose());
                d.addComponent(BorderLayout.SOUTH, ok);
                d.show(0, 0, 0, 0);
                new MenuForm().show();

            }
        };
        String url = "http://localhost/pidevnameone/insertuser.php?name="
                + user.getName() + "&surname=" + user.getSurname() + "&username=" + user.getUsername() + "&email=" + user.getEmail()
                + "&password=" + user.getPass() + "&telephone=" + user.getTelephone() + "&datebirth=" + user.getDateBirth()
                + "&dateinscription=" + user.getDateInscription() + "&address1=" + user.getAddress1() + "&address2="
                + user.getAddress2() + "&codepostal=" + user.getCodePostal() + "&gender=" + user.getGender()
                + "&newsletter=" + user.getNewsletter() + "&secretquestion=" + user.getSecretQuestion()
                + "&secretanswer=" + user.getSecretAnswer()
                + "&photo=" + user.getPhoto();
        System.err.println(url);
        connectionRequest.setUrl(url);
        NetworkManager.getInstance().addToQueue(connectionRequest);
        getUser(user.getUsername(),user.getPass());
        }
        else 
        {
                InteractionDialog d = new InteractionDialog("Email or username already exist");
                TextArea popupBody = new TextArea("Please choose another email or username");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                Button ok = new Button("OK");
                ok.addActionListener((ee) -> d.dispose());
                d.addComponent(BorderLayout.SOUTH, ok);
                d.show(0, 0, 0, 0);            
        }
}

    public void getUser(String username, String password) {

        connectionRequest = new ConnectionRequest() {
            List<SimpleUser> books = new ArrayList<>();
            SimpleUser userkh = new SimpleUser();
            SimpleUser usercurrent = new SimpleUser();

            @Override
            protected void readResponse(InputStream in) throws IOException {
                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    books.clear();
                    for (Map<String, Object> obj : content) {
                        System.out.println((String) obj.get("username"));
                        userkh = new SimpleUser((String) obj.get("id"), (String) obj.get("name"), (String) obj.get("surname"), (String) obj.get("gender"), (String) obj.get("dateBirth"), (String) obj.get("email"),
                                (String) obj.get("username"), (String) obj.get("pass"), (String) obj.get("telephone"), (String) obj.get("address1"), (String) obj.get("address2"),
                                (String) obj.get("codePostal"), (String) obj.get("photo"), (String) obj.get("dateInscription"), (String) obj.get("newsletter"), (String) obj.get("idCompany"),
                                (String) obj.get("latitude"), (String) obj.get("longitude"), (String) obj.get("secretQuestion"), (String) obj.get("secretAnswer"));
                        books.add(userkh);
                        System.out.print(userkh.getUsername());
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            @Override
            protected void postResponse() {
                for (SimpleUser obj : books) {
                    if (username.equals(obj.getUsername()) && password.equals(obj.getPass())) {
                        System.out.println(obj.getId());
                        SimpleUser.setCurrentId(obj.getId());
                        SimpleUser.setCurrentuser(obj);
                    }
                }
            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/login.php?username=" + username + "&password=" + password);
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void login(SimpleUser user) {
        connectionRequest = new ConnectionRequest() {
            List<SimpleUser> books = new ArrayList<>();
            SimpleUser userkh = new SimpleUser();

            @Override
            protected void readResponse(InputStream in) throws IOException {
                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    books.clear();
                    for (Map<String, Object> obj : content) {
                        System.out.println((String) obj.get("username"));
                        userkh = new SimpleUser((String) obj.get("id"), (String) obj.get("name"), (String) obj.get("surname"), (String) obj.get("gender"), (String) obj.get("dateBirth"), (String) obj.get("email"),
                                (String) obj.get("username"), (String) obj.get("pass"), (String) obj.get("telephone"), (String) obj.get("address1"), (String) obj.get("address2"),
                                (String) obj.get("codePostal"), (String) obj.get("photo"), (String) obj.get("dateInscription"), (String) obj.get("newsletter"), (String) obj.get("idCompany"),
                                (String) obj.get("latitude"), (String) obj.get("longitude"), (String) obj.get("secretQuestion"), (String) obj.get("secretAnswer"));
                        books.add(userkh);
                        System.out.print(userkh.getUsername());
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            @Override
            protected void postResponse() {
                System.out.println(user.getUsername());
                if (books.isEmpty()) {
                    InteractionDialog d = new InteractionDialog("Login");
                    TextArea popupBody = new TextArea("Wrong username or password. Try again!");
                    popupBody.setUIID("PopupBody");
                    popupBody.setEditable(false);
                    d.setLayout(new BorderLayout());
                    d.add(BorderLayout.CENTER, popupBody);
                    Button ok = new Button("OK");
                    ok.addActionListener((ee) -> d.dispose());
                    d.addComponent(BorderLayout.SOUTH, ok);
                    d.show(0, 0, 0, 0);
                } else {
                    for (SimpleUser obj : books) {
                        if (user.getUsername().equals(obj.getUsername()) && user.getPass().equals(obj.getPass())) {
                            System.out.println(obj.getId());
                            SimpleUser.setCurrentId(obj.getId());
                            LocalNotification n = new LocalNotification();
                            n.setAlertBody("Welcome! Come ride anytime");
                            n.setAlertTitle("Login successful");
                            n.setId("0");
                            n.setBadgeNumber(0);
                            int repeatType = LocalNotification.REPEAT_NONE;
                            Display.getInstance().scheduleLocalNotification(n, System.currentTimeMillis() + 10 * 1000, repeatType);
                            new MenuForm().show();
                        }
                    }

                }
            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/login.php?username=" + user.getUsername() + "&password=" + user.getPass());
        NetworkManager.getInstance().addToQueue(connectionRequest);

    }

    public void notexist(SimpleUser user) {
        connectionRequest = new ConnectionRequest() {
            List<SimpleUser> books = new ArrayList<>();
            SimpleUser userkh = new SimpleUser();

            @Override
            protected void readResponse(InputStream in) throws IOException {
                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    books.clear();
                    for (Map<String, Object> obj : content) {
                        System.out.println((String) obj.get("username"));
                        userkh = new SimpleUser((String) obj.get("id"), (String) obj.get("name"), (String) obj.get("surname"), (String) obj.get("gender"), (String) obj.get("dateBirth"), (String) obj.get("email"),
                                (String) obj.get("username"), (String) obj.get("pass"), (String) obj.get("telephone"), (String) obj.get("address1"), (String) obj.get("address2"),
                                (String) obj.get("codePostal"), (String) obj.get("photo"), (String) obj.get("dateInscription"), (String) obj.get("newsletter"), (String) obj.get("idCompany"),
                                (String) obj.get("latitude"), (String) obj.get("longitude"), (String) obj.get("secretQuestion"), (String) obj.get("secretAnswer"));
                        books.add(userkh);
                        System.out.print(userkh.getUsername());
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            @Override
            protected void postResponse() {
                System.out.println(user.getUsername());
                if (books.isEmpty()) {
                    System.out.println("the email is unique");
                    SimpleUser.setStatus(true);
                    System.out.println(SimpleUser.isStatus());
                    
                } else {
                    System.out.println("the email is not unique");
                    SimpleUser.setStatus(false);
                    System.out.println(SimpleUser.isStatus());
                }
            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/exists.php?username=" + user.getUsername() + "&password=" + user.getEmail());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void deactivateAccount(SimpleUser b) {   // remove book by title
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
                InteractionDialog d = new InteractionDialog("Disabling account");
                TextArea popupBody = new TextArea("User account successfully disabled");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                Button ok = new Button("OK");
                ok.addActionListener((ee) -> d.dispose());
                d.addComponent(BorderLayout.SOUTH, ok);
                d.show(0, 0, 0, 0);
            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/remove.php?username=" + b.getUsername());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void findAllUsers() {
        connectionRequest = new ConnectionRequest() {
            List<SimpleUser> users = new ArrayList<>();

            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    users.clear();

                    for (Map<String, Object> obj : content) {
                        users.add(new SimpleUser((String) obj.get("name"), (String) obj.get("surname"), (String) obj.get("gender"), (String) obj.get("dateBirth"), (String) obj.get("email"),
                                (String) obj.get("username"), (String) obj.get("pass"), (String) obj.get("telephone"), (String) obj.get("address1"), (String) obj.get("address2"),
                                (String) obj.get("codePostal"), (String) obj.get("photo"), (String) obj.get("dateInscription"), (String) obj.get("newsletter"), (String) obj.get("idCompany"),
                                (String) obj.get("latitude"), (String) obj.get("longitude"), (String) obj.get("secretQuestion"), (String) obj.get("secretAnswer"))
                        );
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            @Override
            protected void postResponse() {
                //System.out.println(libs.size());
                listOfBooks = new Form();
                com.codename1.ui.List uiLibsList = new com.codename1.ui.List();
                ArrayList<String> libsNoms = new ArrayList<>();
                for (SimpleUser l : users) {
                    libsNoms.add(l.getName());
                }
                DefaultListModel<String> listModel = new DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        SimpleUser currentBook = users.get(uiLibsList.getCurrentSelected());
                        //   new Abook(currentBook.getName(), currentBook.getAuthor(), currentBook.getCategory(), currentBook.getISBN()).show();
                    }
                });
                listOfBooks.setLayout(new BorderLayout());
                listOfBooks.add(BorderLayout.NORTH, uiLibsList);
                listOfBooks.add(BorderLayout.SOUTH, OtherTools.createBackBtn());
                listOfBooks.show();
            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/getusers.php");
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

}
