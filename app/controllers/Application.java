package controllers;


import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import models.*;
import static play.data.Form.form;


public class Application extends Controller 
{

    public static Result index() 
	{
		Form<User> swimmerForm = form(User.class);
        return ok(index.render(swimmerForm));
    }
	
	public static Result postSwimmer()
	{
		return TODO;
	}
	
	public static Result save()
	{
		Form<User> swimmerForm = form(User.class).bindFromRequest();
		if(swimmerForm.hasErrors())
		{
			return badRequest(index.render(swimmerForm));
		}
		User newUser = User.create(swimmerForm.get());
		flash("success","swimmer "+swimmerForm.get().name+" has ben created");
		return TODO; //this should go to view swimmers
	}
	

	public static Result login()
	{
		return ok("Gtg");
	}
	
	public static Result signup()
	{
		return ok("ig");
	}
	
	public static Result viewSwimmers()
	{
		return TODO;
	}
	
	public static Result addEvents()
	{
		return TODO;
	}
	
	public static Result viewEvent()
	{
		return TODO;
	}
	
	public static Result addTime()
	{
		return TODO;
	}
	

}