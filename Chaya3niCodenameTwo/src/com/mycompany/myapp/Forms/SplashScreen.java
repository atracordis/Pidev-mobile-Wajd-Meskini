/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Forms;

import com.codename1.ui.Form;
import com.codename1.ui.Image;
import java.io.IOException;

/**
 *
 * @author Admin
 */

public class SplashScreen extends Form{
    
    
    public SplashScreen() throws IOException{
        this.getUnselectedStyle().setBgImage(Image.createImage("/splash.png"));
           
 } 
    
}