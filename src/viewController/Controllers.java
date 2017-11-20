package viewController;

import static functions.CookieCheck.cookieCheck;
import static Values.Strings.sessionUsername;
import static Values.Strings.domainHTML;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(sessionUsername)
public class Controllers {
	
    /*
     * Index and check cookies
     */
    
    @RequestMapping(value = "index")
    public String checkCookie(
    		@CookieValue(value = domainHTML, defaultValue = "null")
        String WeEatdotcom, ModelMap model) {
    	    if(WeEatdotcom.equals("null"))
    	    	    return "login";
    	    else {
    	        	String username = cookieCheck(WeEatdotcom);
    	        	model.put(sessionUsername, username);
    	        	return "redirect:/welcome";
    	    } 	
    }
    
    // Regular View Only
    
    @RequestMapping(value="registerView")
    public String registerView(ModelMap model) {
        return "register";
    }
    @RequestMapping(value="geolocation")
    public String geolocationView(ModelMap model) {
        return "geolocation";
    }
}
