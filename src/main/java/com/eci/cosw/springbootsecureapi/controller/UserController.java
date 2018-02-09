package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping( value = "/items", method = RequestMethod.GET )
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @CrossOrigin
    @RequestMapping( value = "/item", method = RequestMethod.POST ) 
    public User registerUser( @RequestBody User user ) throws ServletException {
        if ( user.getUsername() == null || user.getPassword() == null || user.getImage()==null || 
            user.getEmail()==null || user.getFirstname() == null || user.getLastname() == null)
        {
            throw new ServletException( "Please fill all blanks" );
        }
        userService.createUser(user);
        return user;
    }

    @CrossOrigin
    @RequestMapping( value = "/filter/{email}", method = RequestMethod.GET ) 
    public User findUserByEmail(@PathVariable  String email) throws ServletException{
        return userService.findUserByEmail(email);
    }

    @CrossOrigin
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getUsername();
        String password = login.getPassword();

        User user = userService.getUser(username);

        /* Manejo excepción en service
        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }*/

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
