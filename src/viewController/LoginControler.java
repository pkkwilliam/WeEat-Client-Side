package viewController;

import static Values.Strings.domainHTML;
import static Values.Strings.sessionUsername;
import static functions.LoginCheck.login;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(sessionUsername)
public class LoginControler {
    @RequestMapping(value="login")
    public String loginView(ModelMap model) {
    		System.out.println("At Login");
    	    return "login";
    }
    
    @RequestMapping(value = "loginHandler", method = RequestMethod.POST)
    public String loginHand(
    		@RequestParam String username, 
    		@RequestParam String password,
    		HttpServletResponse response,
    		ModelMap model) {
    	    boolean check = login(username,password);
    	    if(check == true) {
    	       	Cookie cookie = new Cookie(domainHTML, username);
        	    response.addCookie(cookie);	  
        	    model.put(sessionUsername, username);
         	return "redirect:/welcome";
    	    }else
    	    	    return "redirect:/index";
    	    
    }
    
}
