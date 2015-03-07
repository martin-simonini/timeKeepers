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
    //p  ublic String email;
	
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
	
	public static Map<String, String> findAllMap()
	{
	LinkedHashMap<String, String> users = new LinkedHashMap<String, String>();
	for(User c: User.findAll())
	{
		users.put(c.name, c.idToString());
	}
	return users;
	}
    /**
     * Retrieve a User from id.
     */
    public static User findById(Long id) {
        return find.where().eq("id", id).findUnique();
    }
	
	public static User findByName(String name)
	{
		return find.where().eq("name", name).findUnique();
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
    
    public String NametoString() {
        return "User(" + name + ")";
    }
	
	public String idToString()
	{
		return ""+id+"";
	}

}