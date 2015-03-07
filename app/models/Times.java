package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Times 
{
	@Id
	Long id;
	
	@ManyToOne
	public Event event;
	
	@Constraints.Required
	public String time;
	
    @Constraints.Required
	@Formats.DateTime(pattern="MM/dd/yy")
	public String date;
	
	@ManyToOne
	public User swimmer;
	
	public Times(Event event, String time, String date, User user)
	{
		this.event = event;
		this.time = time;
		this.date = date;
		this.swimmer = user;
	}
		
     public static Model.Finder<String,Times> find = new Model.Finder<String,Times>(String.class, Times.class);
	 
	 public static Times create(Event event, String time, String date, User user)
	 {
		 
		 Times times = new Times(event,time,date,user);
		 times.event = event;
		 times.time = time;
		 times.date = date;
		 times.swimmer = user;
		 
		 return times;
	 }
	
	//find all times for an event
    public static List<Times> findByEvent(Long id) {
        return Times.find.where()
            .eq("event.id", id)
            .findList();
    }
	

	
	
    public static boolean isOwner(Long time, String user) {
        return find.where()
            .eq("event.swimmers.id", user)
            .eq("id", time)
            .findRowCount() > 0;
    }
	
	public static List<Times> findAll()
	{
		return find.all();                  
	}
	
	public String toString()
	{
		return "Time("+id+") in event "+ event;
	}
	
}