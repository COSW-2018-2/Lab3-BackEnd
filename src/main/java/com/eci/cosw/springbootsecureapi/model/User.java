package com.eci.cosw.springbootsecureapi.model;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public class User
{

    private long id;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private String username;

    private String image;

    public User()
    {
    }

    public User( String username, String firstname, String email, String lastname, String image, String password )
    {
        this.username = username;
        this.firstname = firstname;
        this.email = email;
        this.lastname = lastname;
        this.image = image;
        this.password = password;
   
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", image=" + image + '}';
    }

}
