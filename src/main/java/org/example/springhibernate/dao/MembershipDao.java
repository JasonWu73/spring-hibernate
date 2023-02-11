package org.example.springhibernate.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDao {

    public void addSillyMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }
}
