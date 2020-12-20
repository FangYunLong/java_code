package com.fylong.annotation;

import com.fylong.web.entity.User;
import lombok.Data;

@Data
public class UserController {

    @AutoWired
    private User user;

}
