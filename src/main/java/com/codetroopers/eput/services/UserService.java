/*
 * Copyright 2016 Code-Troopers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codetroopers.eput.services;

import com.codetroopers.eput.domain.UserDAO;
import com.codetroopers.eput.domain.entities.User;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by cgatay on 19/01/16.
 */
//tag::class[]
@Stateless
@Named
public class UserService {
    @Inject
    public UserDAO userDAO; // <1>
    
    public List<User> all(){
        return userDAO.all();
    }
    
    @Produces
    @Named
    public List<User> listAllUsers(){
        return all();
    }

    public User create(){
        return userDAO.create();
    }

    public User create(User user) {
        return userDAO.save(user);
    }
    
    public String deleteUser(final User user)
    {
        userDAO.delete(user);
        return "";
    }
    
    public User getById(Long id)
    {
        return userDAO.getById(id);
    }
    
    public User getByName(String name)
    {
        return userDAO.getByName(name);
    }
}
//end::class[]