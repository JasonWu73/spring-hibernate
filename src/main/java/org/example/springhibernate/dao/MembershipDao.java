package org.example.springhibernate.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDao {

    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }
}
