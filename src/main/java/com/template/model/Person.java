
package com.template.model;

import java.io.Serializable;

/**
 * A Renseigner.
 * @author  : admin
 * @project : freeMarker
 * @package : com.template.model
 * @date    : 6 déc. 2015 01:20:48
 */
public class Person implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -1337586324268622782L;
   
   private String            firstname;
   
   private String            lastname;
   
   private String            email;
   
   private int               age;
   
   public Person( String firstname, String lastname, String email, int age )
   {
      this.firstname = firstname;
      this.lastname = lastname;
      this.email = email;
      this.age = age;
   }
   
   /**
    * @return Returns the age.
    */
   public int getAge()
   {
      return age;
   }
   
   /**
    * @param age The age to set.
    */
   public void setAge( int age )
   {
      this.age = age;
   }
   
   /**
    * @return Returns the firstname.
    */
   public String getFirstname()
   {
      return firstname;
   }
   
   /**
    * @param firstname The firstname to set.
    */
   public void setFirstname( String firstname )
   {
      this.firstname = firstname;
   }
   
   /**
    * @return Returns the lastname.
    */
   public String getLastname()
   {
      return lastname;
   }
   
   /**
    * @param lastname The lastname to set.
    */
   public void setLastname( String lastname )
   {
      this.lastname = lastname;
   }
   
   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }
   
   /**
    * @param email the email to set
    */
   public void setEmail( String email )
   {
      this.email = email;
   }
}