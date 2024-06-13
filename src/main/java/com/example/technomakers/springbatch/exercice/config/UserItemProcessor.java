package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.User;
import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        if (user.getDepartment().equals("Engineering")) {
            user.setLocation("Bangalore");
        }
        return user;
    }
}
