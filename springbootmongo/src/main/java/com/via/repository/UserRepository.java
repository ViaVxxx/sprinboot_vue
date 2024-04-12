package com.via.repository;

import com.via.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<Users, Integer> {

    // admin查询
    @Query("{'name': {$regex: ?0}}")
    List<Users> findByNameLike(String name);

    @Query("{'number': {$regex: ?0}}")
    List<Users> findByNumberLike(String number);

    @Query("{'gender': {$regex: ?0}}")
    List<Users> findByGenderLike(String gender);

    @Query("{'$or' : [{'name': {$regex: ?0}}, {'number': {$regex: ?1}}, {'gender': {$regex: ?2}}]}")
    List<Users> findByNameOrNumberOrGenderLike(String name, String number, String gender);

    @Query("{'$or' : [{'name': {$regex: ?0}}, {'gender': {$regex: ?1}}]}")
    List<Users> findByNameOrGenderLike(String name, String gender);

    @Query("{'$or' : [{'number': {$regex: ?0}}, {'gender': {$regex: ?1}}]}")
    List<Users> findByNumberOrGenderLike(String number, String gender);


    // 分页查询
    Page<Users> findAll(Pageable pageable);


}