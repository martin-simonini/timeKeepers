package controllers;


import play.*;
import play.data.*;
//import play.data.Form.*;
//import play.api.data.*;
//import play.api.data.Forms.*;
import play.mvc.*;
import views.html.*;
import models.*;





public class Application extends Controller 
{

    public static Result index()  
	{
		Form<User> swimmerForm = Form.form(User.class);
        return ok(index.render(swimmerForm));
    }
	
	
	public static Result postSwimmer()
	{
		return ok(viewSwimmers.render(User.findAll())) ;
	}
	
	public static Result save()
	{
	
		Form<User> swimmerForm = Form.form(User.class).bindFromRequest();
		if(swimmerForm.hasErrors())
		{
			return badRequest(index.render(swimmerForm));
		}
		User newUser = User.create(swimmerForm.get().name, swimmerForm.get().school);
		flash("success","swimmer "+swimmerForm.get().name+" has been created");
		return ok(viewSwimmers.render(User.findAll())) ;
		
	}
	

	public static Result viewSwimmers()
	{
		return ok(viewSwimmers.render(User.findAll())) ;
	}
	
	public static Result viewEvent()
	{
		return ok(viewEvents.render(Event.findAll()));
	}
	
	public static Result addEvent()
	{
		Form<Event> eventForm = Form.form(Event.class);
        return ok(addEvent.render(eventForm));
	}
	
	public static Result eventSave()
	{
		Form<Event> eventForm = Form.form(Event.class).bindFromRequest();
		if(eventForm.hasErrors())
		{
			return badRequest(addEvent.render(eventForm));
		}
		Event newEvent = Event.create(eventForm.get().name, eventForm.get().distance, eventForm.get().units);
		flash("success","event "+eventForm.get().name+" has ben created");
		return ok(viewEvents.render(newEvent.findAll())); //this should go to view event
	}
	
	public static Result editUser(Long id)
	{
		Form<User> editForm = Form.form(User.class).fill(User.findById(id));
		return ok(editUser.render(id, editForm));
		
	}
	
	public static Result updateUser(Long id)
	{
		Form<User> updateForm = Form.form(User.class).bindFromRequest();
		if(updateForm.hasErrors())
		{
			return badRequest(editUser.render(id, updateForm));
		}
		updateForm.get().update(id);
		flash("Success", "User "+updateForm.get().name+" has been updated");
		return ok(viewSwimmers.render(User.findAll()));
	}
	
	public static Result deleteUser(Long id)
	{
		User.findById(id).delete();
		flash("Success", "Swimmer has been deleted");
		return ok(viewSwimmers.render(User.findAll())) ;
	}
	
	public static Result editEvent(Long id)
	{
		Form<Event> editForm = Form.form(Event.class).fill(Event.findById(id));
		return ok(editEvent.render(id,editForm));
	}
	
	public static Result updateEvent(Long id)
	{
		Form<Event> updateForm = Form.form(Event.class).bindFromRequest();
		if(updateForm.hasErrors())
		{
			return badRequest(editEvent.render(id, updateForm));
		}
		updateForm.get().update(id);
		flash("Succcess", "Event "+updateForm.get().name+" has been updated");
		return ok(viewEvents.render(Event.findAll()));
	}
	
	public static Result deleteEvent(Long id)
	{
		Event.findById(id).delete();
		flash("Success", "Event has been deleted");
		return ok(viewEvents.render(Event.findAll()));
	}
	
	//User: List[User],
	public static Result viewTimes(Long id)
	{
		Form<Times> timesForm = Form.form(Times.class);
		
		return ok(viewTimes.render(Event.findById(id) ,Times.findByEvent(id), timesForm));
	}
	
	public static Result addTime(Long id)
	{
		Form<Times> timesForm = Form.form(Times.class).bindFromRequest();
		if(timesForm.hasErrors())
		{
			return badRequest(viewTimes.render(Event.findById(id) ,Times.findByEvent(id), timesForm));
		}
		Times time = Times.create(timesForm.get().event, timesForm.get().time, timesForm.get().date, timesForm.get().swimmer);
		flash("Succcess, your times have been added");
		return ok(viewTimes.render(Event.findById(id) ,Times.findByEvent(id), timesForm));
	}

	
}
