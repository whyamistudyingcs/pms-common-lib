package com.fdm.pmscommon.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdm.pmscommon.entities.Account;
import com.fdm.pmscommon.entities.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    List<Account> findByOwner(User curUser);
}
