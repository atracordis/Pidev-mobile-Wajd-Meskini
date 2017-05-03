/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Forms;

/**
 *
 * @author Admin
 */
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.mycompany.myapp.Controllers.ComplaintController;
import com.mycompany.myapp.Entities.Complaint;
import com.mycompany.myapp.Tools.OtherTools;
import com.codename1.ui.Display;
import com.codename1.ui.table.TableLayout;

/**
 *
 * @author Amal
 */
public class DisplayComplaint extends Form {
    
    private final Label l1,l2,l3,l4,l5;
    private final Label titleTf,categoryTf,isbnTf;
    private final SpanLabel authorTf;
    private final Container mainContainer;
    private final Button /* editBtn,removeBtn,*/backBtn;
    private Complaint currentBook;
    
    public DisplayComplaint(String title,String author,String category,String isbn){
                         mainContainer = new Container();

        TableLayout tl;
if(Display.getInstance().isTablet()) {
    tl = new TableLayout(7, 2);
} else {
    tl = new TableLayout(14, 1);
}
tl.setGrowHorizontally(true);
mainContainer.setLayout(tl);
        mainContainer.setScrollableY(true);
        mainContainer.setScrollVisible(true);

        this.setLayout(new BorderLayout());
        l1 = new Label("Status:  "+isbn);
        //l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(-16777216);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        l2 = new Label("Type:");
        titleTf = new Label(title); 
        l3 = new Label("Content:");
        authorTf = new SpanLabel(author);
        l4 = new Label("DateTime:");
        categoryTf= new Label(category);
        l5 = new Label("Status:");
        isbnTf= new Label(isbn);
      //  editBtn= new Button("Edit");
      //  editBtn.getUnselectedStyle().setFgColor(5542241);
     //   removeBtn= new Button("Remove");
     //   removeBtn.getUnselectedStyle().setFgColor(5542241);
        OtherTools.setLabelStyle(l2);
        OtherTools.setLabelStyle(l3);
        OtherTools.setLabelStyle(l4);
        OtherTools.setLabelStyle(l5);
        mainContainer.add(l1).add(l2).add(titleTf).add(l3)
                .add(authorTf).add(l4).add(categoryTf).add(l5).add(isbnTf);
   //     mainContainer.add(editBtn);
  //      mainContainer.add(removeBtn);
        backBtn = OtherTools.createBackBtn(); 
        mainContainer.add(backBtn);
        currentBook = new Complaint(title, author, category, isbn);
      /*  editBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
            new ComplaintDAO().updateBook(currentBook);
            });
        removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new ComplaintDAO().removeBook(currentBook);
            }
        });*/
        this.add(BorderLayout.NORTH, mainContainer);
    }
}
