package project.service;

import java.math.BigInteger;

import project.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, BigInteger>{

}
