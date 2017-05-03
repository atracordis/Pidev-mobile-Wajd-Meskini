package com.mycompany.myapp.Forms;

import com.codename1.components.FileTree;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ShareButton;
import com.codename1.facebook.FaceBookAccess;
import com.codename1.facebook.User;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.social.FacebookConnect;
import com.codename1.social.LoginCallback;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.mycompany.myapp.Forms.FriendsRenderer;
import com.mycompany.myapp.Forms.WallRenderer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class FacebookMain extends Form{

    private Form main;
    private static Resources theme;
    private Command back = new Command("Back") {

        public void actionPerformed(ActionEvent evt) {
            killNetworkAccess();
            main.showBack();
        }
    };

    

    public void start() {
        System.out.println("started");
//                try {
//      //      theme = Resources.openLayered("/themebis");
//        //    UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        main = new Form("Register via Facebook");
        main.setScrollable(false);
        main.setLayout(new BorderLayout());
        main.addCommand(new Command("Exit") {

            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().exitApplication();
            }
        });
        main.addCommand(new Command("Logout") {

            public void actionPerformed(ActionEvent evt) {
                if(FacebookConnect.getInstance().isFacebookSDKSupported()) {
                    FacebookConnect.getInstance().logout();
                } else {
                    FaceBookAccess.getInstance().logOut();
                    LoginMain.login(main);
                }
            }
        });
        main.show();
        
        if(FacebookConnect.getInstance().isFacebookSDKSupported()) {
            if(!FacebookConnect.getInstance().isLoggedIn()) {
                FacebookConnect.getInstance().setCallback(new LoginCallback() {
                    public void loginSuccessful() {

                    }
                });
                FacebookConnect.getInstance().login();
            }
        } else {
            LoginMain.login(main);

        }
    }

    
    static Resources getTheme() {
        return theme;
    }

    private Container getPairContainer(String key, String val, int padding) {
        Label keyLabel = new Label(key);
        keyLabel.setUIID("Header");
        keyLabel.setPreferredW(padding);
        keyLabel.getStyle().setAlignment(Component.RIGHT);
        Label valLabel = new Label(val);
        valLabel.getStyle().setAlignment(Component.LEFT);
        Container cnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        cnt.addComponent(keyLabel);
        cnt.addComponent(valLabel);
        return cnt;
    }

    private void killNetworkAccess() {
        Enumeration e = NetworkManager.getInstance().enumurateQueue();
        while (e.hasMoreElements()) {
            ConnectionRequest r = (ConnectionRequest) e.nextElement();
            r.kill();
        }

    }
}
