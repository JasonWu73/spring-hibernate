package org.example.springhibernate.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
