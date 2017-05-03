/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Forms;

import com.mycompany.myapp.Controllers.UserController;
import com.mycompany.myapp.Entities.SimpleUser;
import com.mycompany.myapp.Tools.OtherTools;

import com.codename1.io.Log;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import java.io.IOException;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.UIBuilder;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class RegisterForm extends com.codename1.ui.Form {

    private final Label nameLabel, surnameLabel, genderLabel, dateBirthLabel, emailLabel,
            usernameLabel, passLabel, telephoneLabel, address1Label, address2Label,
            codePostalLabel, secretQuestionLabel, secretAnswerLabel;
    private final TextField name, surname, email, username, pass, telephone, address1, address2,
            codePostal, secretQuestion, secretAnswer;
    private final Picker gender;
    private final Container mainContainer;
    private final Button addBtn, backBtn;

    public RegisterForm() {
        //initialize textfields

        name = new TextField("");
        surname = new TextField("");
        email = new TextField("");
        email.setConstraint(com.codename1.ui.TextArea.EMAILADDR);
        username = new TextField("");
        pass = new TextField("");
        pass.setConstraint(com.codename1.ui.TextArea.PASSWORD);
        telephone = new TextField("");
        telephone.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        address1 = new TextField("");
        address2 = new TextField("");
        codePostal = new TextField("");
        codePostal.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        secretQuestion = new TextField("");
        secretAnswer = new TextField("");

        this.setLayout(new BorderLayout());
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8, 2));

        mainContainer.setScrollableY(true);
        mainContainer.setScrollVisible(true);

        //l1.getUnselectedStyle().setAlignment(Component.CENTER);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        nameLabel = new Label("Name: ");
        nameLabel.getUnselectedStyle().setFont(l1_font);
        nameLabel.setAlignment(CENTER);
        nameLabel.getUnselectedStyle().setFgColor(-16777216);
        surnameLabel = new Label("Surname: ");
        surnameLabel.getUnselectedStyle().setFont(l1_font);
        surnameLabel.setAlignment(CENTER);
        surnameLabel.getUnselectedStyle().setFgColor(-16777216);
        genderLabel = new Label("Gender: ");
        genderLabel.getUnselectedStyle().setFont(l1_font);
        genderLabel.setAlignment(CENTER);
        genderLabel.getUnselectedStyle().setFgColor(-16777216);
        dateBirthLabel = new Label("Birthdate: ");
        dateBirthLabel.getUnselectedStyle().setFont(l1_font);
        dateBirthLabel.setAlignment(CENTER);
        dateBirthLabel.getUnselectedStyle().setFgColor(-16777216);
        emailLabel = new Label("Email: ");
        emailLabel.getUnselectedStyle().setFont(l1_font);
        emailLabel.setAlignment(CENTER);
        emailLabel.getUnselectedStyle().setFgColor(-16777216);
        usernameLabel = new Label("Username: ");
        usernameLabel.getUnselectedStyle().setFont(l1_font);
        usernameLabel.setAlignment(CENTER);
        usernameLabel.getUnselectedStyle().setFgColor(-16777216);
        passLabel = new Label("Password: ");
        passLabel.getUnselectedStyle().setFont(l1_font);
        passLabel.setAlignment(CENTER);
        passLabel.getUnselectedStyle().setFgColor(-16777216);
        telephoneLabel = new Label("Telephone: ");
        telephoneLabel.getUnselectedStyle().setFont(l1_font);
        telephoneLabel.setAlignment(CENTER);
        telephoneLabel.getUnselectedStyle().setFgColor(-16777216);
        address1Label = new Label("Address (1): ");
        address1Label.getUnselectedStyle().setFont(l1_font);
        address1Label.setAlignment(CENTER);
        address1Label.getUnselectedStyle().setFgColor(-16777216);
        address2Label = new Label("Address (2): ");
        address2Label.getUnselectedStyle().setFont(l1_font);
        address2Label.setAlignment(CENTER);
        address2Label.getUnselectedStyle().setFgColor(-16777216);
        codePostalLabel = new Label("Postal code: ");
        codePostalLabel.getUnselectedStyle().setFont(l1_font);
        codePostalLabel.setAlignment(CENTER);
        codePostalLabel.getUnselectedStyle().setFgColor(-16777216);
        secretQuestionLabel = new Label("Secret question: ");
        secretQuestionLabel.getUnselectedStyle().setFont(l1_font);
        secretQuestionLabel.setAlignment(CENTER);
        secretQuestionLabel.getUnselectedStyle().setFgColor(-16777216);
        secretAnswerLabel = new Label("Secret answer: ");
        secretAnswerLabel.getUnselectedStyle().setFont(l1_font);
        secretAnswerLabel.setAlignment(CENTER);
        secretAnswerLabel.getUnselectedStyle().setFgColor(-16777216);

        gender = new Picker();
        gender.setType(Display.PICKER_TYPE_STRINGS);
        gender.setStrings("Female", "Male");
        gender.setSelectedString("Male");
        Picker dateBirth = new Picker();
        dateBirth.setType(Display.PICKER_TYPE_DATE);
        dateBirth.setDate(new Date(0));

        addBtn = new Button("Add");
        addBtn.getUnselectedStyle().setFgColor(5542241);

        String phoneConstraint = "^[0-9]";
        Validator v = new Validator();
        v.addConstraint(name, new LengthConstraint(4)).
        addConstraint(surname, new LengthConstraint(4)).
        addConstraint(username, new LengthConstraint(4)).
        addConstraint(pass, new LengthConstraint(4)).
        addConstraint(address1, new LengthConstraint(4)).
        addConstraint(address2, new LengthConstraint(4)).
        addConstraint(secretQuestion, new LengthConstraint(4)).
        addConstraint(secretAnswer, new LengthConstraint(4)).
        addConstraint(email, RegexConstraint.validEmail()).
        addConstraint(telephone, new RegexConstraint(phoneConstraint, "Please enter a valid phone number")).
        addConstraint(codePostal, new RegexConstraint(phoneConstraint, "Please enter a valid postal code"));

        v.addSubmitButtons(addBtn);

        mainContainer.add(nameLabel);
        mainContainer.add(name);
        mainContainer.add(surnameLabel);
        mainContainer.add(surname);
        mainContainer.add(genderLabel);
        mainContainer.add(gender);
        mainContainer.add(dateBirthLabel);
        mainContainer.add(dateBirth);
        mainContainer.add(emailLabel);
        mainContainer.add(email);
        mainContainer.add(usernameLabel);
        mainContainer.add(username);
        mainContainer.add(passLabel);
        mainContainer.add(pass);
        mainContainer.add(telephoneLabel);
        mainContainer.add(telephone);
        mainContainer.add(address1Label);
        mainContainer.add(address1);
        mainContainer.add(address2Label);
        mainContainer.add(address2);
        mainContainer.add(codePostalLabel);
        mainContainer.add(codePostal);
        mainContainer.add(secretQuestionLabel);
        mainContainer.add(secretQuestion);
        mainContainer.add(secretAnswerLabel);
        mainContainer.add(secretAnswer);
        mainContainer.add(addBtn);
        backBtn = OtherTools.createBackBtnRegister();
        mainContainer.add(backBtn);

        addBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
            String localDate = OtherTools.getCurrentTimeStamp();
            SimpleUser typedUser;
            String genre;
            if (gender.getText().equals("Male")) {
                genre = "homme";
            } else {
                genre = "femme";
            }
            String date;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String testString = "";
            int testInt = Integer.parseInt(dateBirth.getText().substring(6, 8));
            if ((testInt > 0) && (testInt < 18)) {
                testString = "20" + dateBirth.getText().substring(6, 8);
            } else {
                testString = "19" + dateBirth.getText().substring(6, 8);
            }

            String dateString = "-" + dateBirth.getText().substring(0, 2) + "-" + dateBirth.getText().substring(3, 5);
            dateString = testString + dateString;
            System.out.println(dateString);

            typedUser = new SimpleUser(name.getText(), surname.getText(), genre, dateString, email.getText(),
                    username.getText(), pass.getText(), telephone.getText(), address1.getText(), address2.getText(),
                    codePostal.getText(), "", localDate, "0", "0",
                    "", "", secretQuestion.getText(), secretAnswer.getText());

            new UserController().addUser(typedUser);
        });
        this.add(BorderLayout.NORTH, mainContainer);

    }

    private void automoveToNext(final TextField current, final TextField next) {
        current.addDataChangeListener(new DataChangedListener() {
            public void dataChanged(int type, int index) {
                if (current.getText().length() == 5) {
                    Display.getInstance().stopEditing(current);
                    String val = current.getText();
                    current.setText(val.substring(0, 4));
                    next.setText(val.substring(4));
                    Display.getInstance().editString(next, 5, current.getConstraint(), next.getText());
                }
            }
        });
    }
//-- DON'T EDIT BELOW THIS LINE!!!

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
    }
//-- DON'T EDIT ABOVE THIS LINE!!!
}
