package com.ferin.repository.login;

import com.ferin.domain.login.Login;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2016/09/01.
 */
public interface LoginRepository extends CrudRepository<Login, Long> {
}
