package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model
{
	 private static final long serialVersionUID = 1L;

	//@Id
    //@Constraints.Required
    //@Formats.NonEmpty
    //public String email;
	
	@Id
	public Long id;
    
    @Constraints.Required
    public String name;
    
   // @Constraints.Required
   // public String password;
   
   @Constraints.Required
   public String school;
    
    // -- Queries
    
	public User(String name, String school)
	{
		this.name = name;
		this.school = school;
	}
    public static Model.Finder<String,User> find = new Model.Finder<String,User>(String.class, User.class);
    
	public static User create(String name, String school)
	{
		User user = new User(name, school);
		user.name = name;
		user.school = school;
		user.save();
		return user;
	}
    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from id.
     */
    public static User findById(Long id) {
        return find.where().eq("id", id).findUnique();
    }
    
    /**
     * Authenticate a User.
     
    public static User authenticate(String email, String password) {
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }
    */
    // --
    
    public String toString() {
        return "User(" + name + ")";
    }

}