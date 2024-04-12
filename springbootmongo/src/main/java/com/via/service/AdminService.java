package com.via.service;

import com.via.entity.Params;
import com.via.entity.Users;
import com.via.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getUser() {
        return userRepository.findAll();
    }

    // 根据name和number查询用户
    public List<Users> findBy(Params params) {
        String name = params.getName();
        String number = params.getNumber();
        String gender = params.getGender();

        if (name != null && number != null && gender != null) {
            return userRepository.findByNameOrNumberOrGenderLike(name, number, gender);
        } else if (name != null && gender != null) {
            return userRepository.findByNameOrGenderLike(name, gender);
        } else if (number != null && gender != null) {
            return userRepository.findByNumberOrGenderLike(number, gender);
        } else if (name != null) {
            return userRepository.findByNameLike(name);
        } else if (number != null) {
            return userRepository.findByNumberLike(number);
        } else if (gender != null) {
            return userRepository.findByGenderLike(gender);
        } else {
            return new ArrayList<>();
        }
    }

    // 分页查询
    public Page<Users> getUserPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}