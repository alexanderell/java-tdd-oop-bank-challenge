package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void createAccountSavingAndCurrent() {

        Account account = new Account();

        Assertions.assertTrue(account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertTrue(account.addCustomerAccount("Savings", "2222-2222-2222", "Alexander Ellnestam", "ABC123"));

    }

    @Test
    public void invalidAccountSavingAndCurrent() {

        Account account = new Account();

        Assertions.assertTrue(account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertFalse(account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertFalse(account.addCustomerAccount("Current and Saving", "3222-2222-2222", "Alexander Ellnestam", "ABC123"));

    }

    @Test
    public void findAccountTest() {

        Account account = new Account();

        account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123");

        Assertions.assertEquals(account.customerAccounts.get(0), account.findCustomerAccount("1111-1111-1111"));

        Assertions.assertNull(account.findCustomerAccount("1111-1111"));


    }

    @Test
    public void successfulDepositTest(){

        Account account = new Account();

        account.addCustomerAccount("Savings", "1111-1111-1111", "Alexander Ellnestam", "ABC123");

        Assertions.assertTrue(account.deposit("1111-1111-1111", 50.25));
        Assertions.assertTrue(account.deposit("1111-1111-1111", 5000.25));

        Assertions.assertEquals(5050.50, account.customerAccounts.get(0).getBalance());

    }



}
