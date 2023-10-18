package com.gfa.accounthandlerapp.controllers;

import com.gfa.accounthandlerapp.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
    private List<Account> accounts = new ArrayList<>();

    @GetMapping(path = "/index")
    public String displayIndex(){
        return "index";
    }

    @GetMapping(path = "/index-old")
    public String displayIndexOld(){
        return "index-old";
    }

    @ResponseBody
    @GetMapping (path="/accounts")
    public List<Account> getAccounts(){
        return accounts;
    }

    @ResponseBody
    @PostMapping(path = "/sign-up-old")
    public ResponseEntity<?> addNewAccountOld(@ModelAttribute Account newAccount){
        accounts.add(newAccount);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @ResponseBody
    @PostMapping(path = "/sign-up")
    public ResponseEntity<?> addNewAccount(@RequestBody Account newAccount){
        if(newAccount.getName() == null || newAccount.getEmail() == null || newAccount.getGender() == null || newAccount.getPhoneNumber() == null || newAccount.getPassword() == null ){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        accounts.add(newAccount);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
}

