package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.ServletException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "xyz", "Andres", "test@mail.com", "Perez", "http://assets.winsports.co/sites/default/files/8942_0.jpg", "password"));
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( String username ) throws ServletException
    {
        Optional<User> found = users.stream().filter(h-> h.getUsername().equals(username)).findAny();
        if (!found.isPresent()){
            throw new ServletException ("Username not found.");
        }
        return found.get();
    }

    @Override
    public User createUser( User user ) throws ServletException
    {
        if (users.stream().anyMatch(h->h.getUsername().equals(user.getUsername()))){
            throw new ServletException ("Username already exist");
        }
        users.add(user);
        return user;
    }

    @Override
    public User findUserByEmail( String email ) throws ServletException
    {
        Optional<User> found = users.stream().filter(h-> h.getEmail().equals(email)).findAny();
        if (!found.isPresent()){
            throw new ServletException ("No user found with the email address");
        }
        return found.get();
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        return users.get( 0 );
    }

}
