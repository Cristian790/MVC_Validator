package springmvc_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.model.User;
import springmvc_example.model.UserValidator;
import springmvc_example.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView  model=new ModelAndView("user/user_page");
		List<User> list=userService.listAllUsers();
		model.addObject("listUser", list);
		return model;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView  model=new ModelAndView("user/user_form");
		User user=new User();
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView  model=new ModelAndView("user/user_form");
		User user=userService.findUserById(id);
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userForm") User user,BindingResult result,SessionStatus status) {
		
		userValidator.validate(user, result);
        if(result.hasErrors())
        {
            //acá volvemos al formulario porque los datos
            //ingresados no son correctos, es decir, se ejecutó la validación
        	ModelAndView  model=new ModelAndView("user/user_form");
    		
    		model.addObject("userForm", user);
    		return model;
        }
        else
        {
            //el usuario ingresó bien los datos
        	if(user!=null && user.getId()!=null) {
    			userService.updateUser(user);
    		}
    		else {
    			userService.addUser(user);
    		}
    		return new ModelAndView("redirect:/user/list");
        }}
		
		
	
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		userService.deleteUser(id);;
		return new ModelAndView("redirect:/user/list");
	}
}
