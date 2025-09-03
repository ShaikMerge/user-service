package com.oms.user_service.repository;

import com.oms.user_service.entity.OMSUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegisterRepository extends JpaRepository<OMSUser, String> {

    Optional<OMSUser>  findByUsername(String username);

}
