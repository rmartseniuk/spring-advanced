package com.epam.martseniuk.repository;

import com.epam.martseniuk.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Roman_Martseniuk
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findUserByUsernameAndSerialNumber(String username, String serialNumber);
}
