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
    @Constraints.Required
    @Formats.NonEmpty
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
	
     public static Model.Finder<String,Times> find = new Model.Finder<String,Times>(String.class, Times.class);
	 
	
	//find all times for an event
    public static List<Event> findByEvent(Long event) {
        return Event.find.where()
            .eq("event.id", event)
            .findList();
    }
	
	
    public static boolean isOwner(Long time, String user) {
        return find.where()
            .eq("event.swimmers.email", user)
            .eq("id", time)
            .findRowCount() > 0;
    }
	
	public String toString()
	{
		return "Time("+id+") in event "+ event;
	}
	
}