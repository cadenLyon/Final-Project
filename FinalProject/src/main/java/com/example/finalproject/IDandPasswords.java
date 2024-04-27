package com.example.finalproject;

import java.util.HashMap;

public class IDandPasswords {

    HashMap<String,String> loginInfo = new HashMap<>();

    IDandPasswords(){
        loginInfo.put("1234","1234");
        loginInfo.put("good","good");
        loginInfo.put("caden","caden");
    }

    protected HashMap<String, String> getLoginInfo(){
        return loginInfo;
    }
}
