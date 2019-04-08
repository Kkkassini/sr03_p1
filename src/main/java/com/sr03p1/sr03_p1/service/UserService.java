package com.sr03p1.sr03_p1.service;

import com.sr03p1.sr03_p1.domain.User;

import java.util.List;

public interface UserService {
    List<User> findByMail(String mail);
}
