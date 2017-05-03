/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Controllers;

import com.mycompany.myapp.Entities.Complaint;
import com.mycompany.myapp.Entities.SimpleUser;
import com.mycompany.myapp.Forms.*;
import com.mycompany.myapp.Tools.OtherTools;
import com.codename1.components.InteractionDialog;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
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
 * @author Amal
 */
public class ComplaintController {

    private ConnectionRequest connectionRequest;
    public static Form listOfBooks;

    public void addBook(Complaint book) {
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
                try {
                    InteractionDialog d = new InteractionDialog("Success");
                    TextArea popupBody = new TextArea("Complaint successfully sent");
                    popupBody.setUIID("PopupBody");
                    popupBody.setEditable(false);
                    d.setLayout(new BorderLayout());
                    d.add(BorderLayout.CENTER, popupBody);
                    Button ok = new Button("OK");
                    ok.addActionListener((ee) -> d.dispose());
                    d.addComponent(BorderLayout.SOUTH, ok);
                    d.show(0, 0, 0, 0);
                    String phone="+21650441120";
                    String data = "There is a new complaint!";

                    
                    
                    switch(Display.getInstance().getSMSSupport()) {
                        case Display.SMS_NOT_SUPPORTED:
                            return;
                        case Display.SMS_SEAMLESS:
                            Display.getInstance().sendSMS(phone, data);
                            return;
                        default:
                            Display.getInstance().sendSMS(phone, data);
                            return;
                    }               } catch (IOException ex) {

                    }
                new MenuForm().show();

            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/insert.php?type=" + book.getType() + "&content=" + book.getContent() + "&datetime=" + book.getDateTime() + "&iduser=" + SimpleUser.getCurrentId());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void loginTest(Complaint book) {
        connectionRequest = new ConnectionRequest() {
            List<Complaint> books = new ArrayList<>();
            @Override
            protected void readResponse(InputStream in) throws IOException {
                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    books.clear();
                    for (Map<String, Object> obj : content) {
                        books.add(new Complaint((String) obj.get("Name"), (String) obj.get("Author"), (String) obj.get("Category"), (String) obj.get("ISBN")));
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            @Override
            protected void postResponse() {
                for (Complaint obj : books) {
                    if (book.getType().equals(obj.getType()) && book.getIdUser().equals(obj.getIdUser())) {  
                      new ComplaintController().findAllComplaints();     
                    }
                }

            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/login.php");
        NetworkManager.getInstance().addToQueue(connectionRequest);

    }

    public void removeBook(Complaint b) {   // remove book by title
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
                InteractionDialog d = new InteractionDialog("Remove book from database");
                TextArea popupBody = new TextArea("Book successfully removed");
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
        connectionRequest.setUrl("http://localhost/pidevnameone/remove.php?title=" + b.getIdUser());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void findAllComplaints() {
        connectionRequest = new ConnectionRequest() {
            List<Complaint> complaints = new ArrayList<>();

            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    complaints.clear();

                    for (Map<String, Object> obj : content) {
                        complaints.add(new Complaint((String) obj.get("Name"), (String) obj.get("Author"), (String) obj.get("Category"), (String) obj.get("ISBN")));
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
                for (Complaint l : complaints) {
                    libsNoms.add(l.getType());
                }
                DefaultListModel<String> listModel = new DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Complaint currentBook = complaints.get(uiLibsList.getCurrentSelected());
                        new DisplayComplaint(currentBook.getType(), currentBook.getContent(), currentBook.getDateTime(), currentBook.getIdUser()).show();
                    }
                });
                listOfBooks.setLayout(new BorderLayout());
                listOfBooks.add(BorderLayout.NORTH, uiLibsList);
                listOfBooks.add(BorderLayout.SOUTH, OtherTools.createBackBtn());
                listOfBooks.show();
            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/getbooks.php?id="+SimpleUser.getCurrentId());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void updateBook(Complaint b) {
        connectionRequest = new ConnectionRequest() {

            @Override
            protected void postResponse() {
                Dialog d = new Dialog("Popup Title");
                TextArea popupBody = new TextArea("Book updated");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                d.show();
            }
        };
        connectionRequest.setUrl("http://localhost/pidevnameone/update.php?title=" + b.getType() + "&author=" + b.getContent()
                + "&category=" + b.getDateTime() + "&isbn=" + b.getIdUser() + "&id=3");
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
  
    public Complaint findBookById(int id){
         connectionRequest = new ConnectionRequest() {
            List<Complaint> books = new ArrayList<>();
             @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    books.clear();
                    for (Map<String, Object> obj : content) {
                        books.add(new Complaint((String) obj.get("title"),(String) obj.get("author"),(String) obj.get("category"),(String) obj.get("isbn")));
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }
                   @Override
            protected void postResponse() {
                       System.out.println(books.get(0).getType());
            }
         };
        connectionRequest.setUrl("http://localhost/shelfie/getBook.php?id="+id);
        NetworkManager.getInstance().addToQueue(connectionRequest);
        return null;
    }
}
