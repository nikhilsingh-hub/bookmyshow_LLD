package com.LLD.BookMyShow.Services.Interfaces;

import com.LLD.BookMyShow.Models.User;

public interface UserService {
    User createUser(String name, String email, String mobile);
    User getUser(String id);
}
