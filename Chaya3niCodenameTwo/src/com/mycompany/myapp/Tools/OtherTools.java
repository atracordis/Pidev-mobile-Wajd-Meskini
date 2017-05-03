/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Tools;

import com.mycompany.myapp.Forms.MenuForm;
import com.mycompany.myapp.MyApplication;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;

import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.events.ActionListener;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class OtherTools {
    
    
    public static void setLabelStyle(Label l){
        l.getUnselectedStyle().setFgColor(-16777216);
        l.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_MEDIUM));
    }
     
     public static Button createBackBtn(){
         Button b=new Button("Back");
         b.getUnselectedStyle().setFgColor(5542241);
         b.addActionListener((ActionListener) (ActionEvent evt) -> {
             new MenuForm().show();
             
         });
         return b;
     }    
          public static Button createBackBtnRegister(){
         Button b=new Button("Back");
         b.getUnselectedStyle().setFgColor(5542241);
         b.addActionListener((ActionListener) (ActionEvent evt) -> {
             new MyApplication().generateMenu();
             
         });
         return b;
     }    
     
 public static String getCurrentTimeStamp(){
            
      
     long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    
        Date resultdate = new Date(yourmilliseconds);


        return sdf.format(resultdate);
       
    }
}
