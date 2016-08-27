package com.ferin.domain.account;

import com.ferin.domain.client.Client;

import javax.persistence.*;

@javax.persistence.Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Client client;
    private String accountNumber;
    private String accountType;
    private double balance;
    private double limit;
    private String pin;


    private Account(){}

    private Account(Builder builder)
    {
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.client = builder.client;
        this.limit = builder.limit;
        this.pin = builder.pin;
        this.id = builder.id;
    }

    public Client getClient() {
        return client;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getLimit() {
        return limit;
    }

    public String getPin() {
        return pin;
    }

    public Long getId() {
        return id;
    }


    public static class Builder
    {
        private Client client;
        private String accountNumber;
        private String accountType;
        private double balance;
        private double limit;
        private String pin;
        private Long id;

        public Builder client(Client client){
            this.client = client;
            return this;
        }

        public Builder accountType(String accountType)
        {
            this.accountType = accountType;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return  this;
        }

        public Builder balance(double balance)
        {
            this.balance = balance;
            return this;
        }

        public Builder limit(double limit)
        {
            this.limit = limit;
            return  this;
        }

        public Builder pin(String pin)
        {
            this.pin = pin;
            return this;
        }

        public Builder accountNumber(String accountNumber)
        {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder copy(Account account)
        {
            this.id = account.id;
            this.accountNumber = account.accountNumber;
            this.accountType = account.accountType;
            this.balance = account.balance;
            this.limit = account.limit;
            this.pin = account.pin;
            this.client = account.client;

            return this;
        }

        public Account build()
        {
            return  new Account(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (Double.compare(account.limit, limit) != 0) return false;
        if (accountNumber != null ? !accountNumber.equals(account.accountNumber) : account.accountNumber != null)
            return false;
        if (accountType != null ? !accountType.equals(account.accountType) : account.accountType != null) return false;
        if (pin != null ? !pin.equals(account.pin) : account.pin != null) return false;
        return id != null ? id.equals(account.id) : account.id == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNumber != null ? accountNumber.hashCode() : 0;
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(limit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
