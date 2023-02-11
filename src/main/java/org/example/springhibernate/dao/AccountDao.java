package org.example.springhibernate.dao;

import org.example.springhibernate.dto.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    public void addAccount(final Account account, final boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
