package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;

import java.util.List;

import javax.servlet.ServletException;


/**throws ServletException
 * @author Santiago Carrillo
 * 8/21/17.
 */
public interface UserService
{
    List<User> getUsers();

    User getUser( String username ) throws ServletException;

    User createUser( User user ) throws ServletException;

    User findUserByEmail( String email ) throws ServletException;

    User findUserByEmailAndPassword( String email, String password );
}