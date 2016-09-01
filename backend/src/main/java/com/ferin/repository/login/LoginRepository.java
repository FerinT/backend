package com.ferin.repository.login;

import com.ferin.domain.login.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
}
