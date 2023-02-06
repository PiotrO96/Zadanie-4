package com.example.ps4;

import java.io.Serializable;

public class Account implements Serializable {

    private int id;
    private  String username;
    private  String password;
    private  String fullName;
    private  String email;

public  int getId(){
return  this.id;

}
public  void setId(int id )
{
    this.id=id;
}
public  String getUsername()
{
    return  this.username;

}
public void  setUsername(String username)
{
    this.username=username;
}
public String getPassword()
{
    return this.password;

}
public  void setPassword(String password)
{
    this.password=password;

}
public String getFullName()
{
    return this.fullName;
}
public  void  setFullName(String fullName)
{
this.fullName=fullName;
}

public String getEmail()
{
    return this.email;
}
public void  setEmail(String email)
{
    this.email=email;
}

}
