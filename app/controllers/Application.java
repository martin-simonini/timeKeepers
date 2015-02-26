package controllers;


import play.*;
import play.data.Form.*;
import play.api.data.*;
import play.api.data.Forms.*;
import play.mvc.*;
import views.html.*;
import models.*;
import static play.data.Form.form;
import models.*;



public class Application extends Controller 
{

    public static Result index() 
	{
		Form<User> swimmerForm = form(User.class);
        return ok(index.render(swimmerForm));
    }
	
	
	public static Result postSwimmer()
	{
		return ok(viewSwimmers.render(User.findAll())) ;
	}
	
	public static Result save()
	{
	
		Form<User> swimmerForm = form(User.class).bindFromRequest();
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
		Form<Event> eventForm = form(Event.class);
        return ok(addEvent.render(eventForm));
	}
	
	public static Result eventSave()
	{
		Form<Event> eventForm = form(Event.class).bindFromRequest();
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
		Form<User> editForm = form(User.class).fill(User.findById(id));
		return ok(editUser.render(id, editForm));
		
	}
	
	public static Result updateUser(Long id)
	{
		form<User> updateForm = form(User.class).bindFromRequest();
		if(updateForm.hasErrors())
		{
			return badRequest(editUser.render(id, updateForm));
		}
		updateForm.get().update(id);
		flash("Success", "User "+updateForm.get().name+" has been updated");
		return ok(viewSwimmers.render());
	}

	
	
}