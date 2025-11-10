package com.robertoapi.login_and_authentication_api.repository;

import com.robertoapi.login_and_authentication_api.model.TB_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TB_User, Long> {
}
