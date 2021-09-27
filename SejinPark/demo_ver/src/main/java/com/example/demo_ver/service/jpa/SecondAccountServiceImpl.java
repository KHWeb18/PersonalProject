package com.example.demo_ver.service.jpa;

import com.example.demo_ver.controller.vue.jpa.request.SignInForm;
import com.example.demo_ver.entity.jpa.SecondAccount;
import com.example.demo_ver.repository.jpa.JpaSecondAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecondAccountServiceImpl implements SecondAccountService {

    @Autowired
    private JpaSecondAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(SignInForm form) throws Exception {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        form.setPassword(encodedPassword);

        SecondAccount accountEntity = new SecondAccount(form.getEmail(), form.getPassword());

        accountRepository.save(accountEntity);
    }
}