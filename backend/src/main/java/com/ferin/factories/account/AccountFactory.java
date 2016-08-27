package com.ferin.factories.account;


import com.ferin.domain.account.Account;

import java.util.Map;

public interface AccountFactory {
    Account createAccount(Map<String, Object> accountDetails);
}
