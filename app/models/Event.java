package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;


@Entity 
public class Event extends Model 
{
	private static final long serialVersionUID = 1l;
	
	@Id
    @Constraints.Required
    @Formats.NonEmpty
	Long id;
	
	@Constraints.Required
	public String name;
	
	public String stroke;
	public int distance; //in yards
	
	@ManyToMany
	public List<User> swimmers = new ArrayList<User>();
	
	
	public Event(String name, int distance, User swimmer)
	{
		this.name = name;
		this.distance = distance;
		this.swimmers.add(swimmer);
	}
	  public static Model.Finder<Long,Event> find = new Model.Finder<Long,Event>(Long.class, Event.class);
	
	    /**
     * Retrieve Event for user
     */
    public static List<Event> findInvolving(String user) {
        return find.where()
            .eq("swimmer.email", user)
            .findList();
    }
	
	//create event
    public static Event create(String name, int distance, String swimmers) {
        Event event = new Event(name, distance, User.find.ref(swimmers));
        event.save();
        event.saveManyToManyAssociations("members");
        return event;
    }
	
	//rename event
	public static String rename(Long eventId, String newName)
	{
		Event event = find.ref(eventId);
		event.name = newName;
		event.update();
		return newName;
	}
	
	//add swimmers
    public static void addMember(Long event, String user) {
        Event p = Event.find.setId(event).fetch("swimmers", "email").findUnique();
        p.swimmers.add(
            User.find.ref(user)
        );
        p.saveManyToManyAssociations("swimmers");
    }
	//remove swimmer
    public static void removeSwimmer(Long event, String swimmer) {
        Event p = Event.find.setId(event).fetch("swimmers", "email").findUnique();
        p.swimmers.remove(
            User.find.ref(swimmer)
        );
        p.saveManyToManyAssociations("swimmers");
    }

	public static boolean isMember(Long event, String user)
	{
		return find.where()
			.eq("swimmer.email", user)
			.eq("id", event)
			.findRowCount() > 0;
	}
	
	public String toString()
	{
		return "Event("+id+") with"+(swimmers == null ? "null" : swimmers.size()) + "Swimmers";
	}
}
	
    
