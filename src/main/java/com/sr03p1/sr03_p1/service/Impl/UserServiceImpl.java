package com.sr03p1.sr03_p1.service.Impl;

import com.sr03p1.sr03_p1.dao.UserRepo;
import com.sr03p1.sr03_p1.domain.User;
import com.sr03p1.sr03_p1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> findByMail(String mail) {
        List<User> user = UserRepo.findByMail(mail);

        return user;
    }
}