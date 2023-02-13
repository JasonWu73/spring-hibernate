package org.example.springhibernate.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.springhibernate.dto.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDao {

    private String name;

    private String serviceCode;

    public List<Account> findAccounts(final boolean tripWire) {
        if (tripWire) throw new RuntimeException("Trip Wire Exception");

        final ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John", "Silver"));
        accounts.add(new Account("Madhu", "Platinum"));
        accounts.add(new Account("Luca", "Gold"));

        return accounts;
    }

    public void addAccount(final Account account, final boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(final String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(final String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
