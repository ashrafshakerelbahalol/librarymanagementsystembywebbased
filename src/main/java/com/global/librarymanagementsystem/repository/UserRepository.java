package com.global.librarymanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.global.librarymanagementsystem.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
