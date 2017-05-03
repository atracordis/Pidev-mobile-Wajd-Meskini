/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Forms;

import com.mycompany.myapp.Controllers.ComplaintController;
import com.mycompany.myapp.Controllers.UserController;
import com.mycompany.myapp.Entities.SimpleUser;
import com.mycompany.myapp.Forms.*;

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
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.UIBuilder;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class MenuForm extends com.codename1.ui.Form {
        private Button addBookBtn,listBooksBtn,exitBtn;
            private Container mainContainer;
                private Resources theme;


            public MenuForm (){
 
                        mainContainer = new Container();
         
        TableLayout tl;
if(Display.getInstance().isTablet()) {
    tl = new TableLayout(7, 2);
} else {
    tl = new TableLayout(14, 1);
}
tl.setGrowHorizontally(true);
mainContainer.setLayout(tl);

exitBtn = new Button("Exit");
            addBookBtn = new Button("Add new complaint");
        addBookBtn.getUnselectedStyle().setFgColor(5542241);
        listBooksBtn = new Button("My complaints");
        listBooksBtn.getUnselectedStyle().setFgColor(5542241);
        this.setLayout(new BorderLayout());

//
//        mainContainer.setScrollableY(true);
//        mainContainer.setScrollVisible(true);

        
        listBooksBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new ComplaintController().findAllComplaints();     
            }
        });
        addBookBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new AddComplaintForm().show();
            }
        });
        exitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                        Display.getInstance().exitApplication();
            }
        });
        
        mainContainer.add(addBookBtn).add(listBooksBtn).add(exitBtn);
                this.add(BorderLayout.NORTH, mainContainer);

            }

//-- DON'T EDIT BELOW THIS LINE!!!
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
    }
//-- DON'T EDIT ABOVE THIS LINE!!!
}
