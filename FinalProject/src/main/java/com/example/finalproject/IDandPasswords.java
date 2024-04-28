package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class IDandPasswords {

    HashMap<String,String> loginInfo = new HashMap<>();
    private static IDandPasswords instance = null;
    private String loggedInUsername;

    IDandPasswords(){
        loginInfo.put("1234","1234");
        loginInfo.put("good","good");
        loginInfo.put("caden","caden");
    }

    public void addUsernameAndPassword(String user, String pass){
        loginInfo.put(user, pass);
    }

    public static IDandPasswords refresh(){
        if (instance == null){
            instance = new IDandPasswords();
        }
        return instance;
    }

    protected HashMap<String, String> getLoginInfo(){
        return loginInfo;
    }

    public void setUsername(String username){
        this.loggedInUsername = username;
    }

    public String getUsername(){
        return loggedInUsername;
    }

    public boolean checkCredentials(String user, String pass) throws IOException {

        IDandPasswords iDandPasswords = IDandPasswords.refresh();
        System.out.println("sign in page info: "+iDandPasswords.getLoginInfo());

        if(iDandPasswords.loginInfo.containsKey(user)){
            if(iDandPasswords.loginInfo.get(user).equals(pass)){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }
}
