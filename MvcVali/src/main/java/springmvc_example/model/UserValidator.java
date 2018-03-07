package springmvc_example.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Service
public class UserValidator implements Validator {

//	    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//	   
//	     private Pattern pattern;
//	     private Matcher matcher;
//	    
	    
	    public boolean supports(Class<?> type) 
	    {
	        return User.class.isAssignableFrom(type);
	        //return TuClase.class.isAssignableFrom(type); Una clase validator por cada clase a validar

	    }

	    public void validate(Object o, Errors errors) 
	    {
	        User user=(User) o;
	        ValidationUtils.rejectIfEmptyOrWhitespace
            (errors, 
            "firstname", 
            "required.firstname",
            "El campo nombre es obligatorio");
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace
            (errors, 
            "lastname", 
            "required.lastname",
            "El campo apellido es obligatorio");
	        
//	        if((user).getEdad()<=10)
//	        {
//	            errors.rejectValue("edad", "required.edad","Edad debe ser mayor a 10" );
//	        }
//	                
//	        ValidationUtils.rejectIfEmptyOrWhitespace
//	                                                        (errors, 
//	                                                        "correo", 
//	                                                        "required.correo", 
//	                                                        "El campo E-Mail es obligatorio");
//	        if (!(persona.getCorreo() != null && persona.getCorreo().isEmpty()))
//	        {
//	            this.pattern = Pattern.compile(EMAIL_PATTERN);
//	            this.matcher = pattern.matcher(persona.getCorreo());
//	             if (!matcher.matches()) {
//	                errors.rejectValue("correo", "correo.incorrect",
//	                  "El E-Mail "+persona.getCorreo()+" no es válido");}
//	        }
//
//	                
//	        if(persona.getPais().equals("Seleccione"))
//	        {
//	            errors.rejectValue("pais", "required.pais", "Seleccione un país");
//	        }
	        
	    }
	    
	}


