package com.example.FamilyMember;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person
{
    @Id
    public String Email_ID;
    public String Password;
    public String DOB;
    public String Surname;
    public String Name;
    public String Gender;
    public String Phone;
    public String Address;

}
