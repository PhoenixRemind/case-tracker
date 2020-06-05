package org.launchcode.casetracker.models.data;

import org.launchcode.casetracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
