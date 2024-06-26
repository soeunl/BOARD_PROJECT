package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestLogin { // 양식에 있는 값과 동일하면 알아서 주입됨
    private String email;
    private String password;
    private boolean saveEmail;
    private String redirectUrl;
}
