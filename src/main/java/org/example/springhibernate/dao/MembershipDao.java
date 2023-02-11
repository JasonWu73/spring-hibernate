package org.example.springhibernate.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDao {

    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": goToSleep()");
    }
}
