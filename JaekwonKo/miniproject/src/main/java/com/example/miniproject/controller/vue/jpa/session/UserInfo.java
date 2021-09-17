package com.example.miniproject.controller.vue.jpa.session;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  userId;
}
