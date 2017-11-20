package viewController;

import static Values.Strings.sessionUsername;
import static functions.ResturantNearBy.getList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(sessionUsername)
public class WelcomeController {
	
    @RequestMapping(value="welcome")
    public String welcomeView(ModelMap model) {
    	    model.addAttribute("user",model.get(sessionUsername));
    	    return "/welcome";
    }
    @RequestMapping(value="getRestaurantHandle", method = RequestMethod.POST)
    @ResponseBody
    public String getRestaurantHandle(
    		@RequestParam String latitude,
    		@RequestParam String longtitude) {
      	String restaurantJson = getList(latitude,longtitude);
    	    return restaurantJson;
    }
}
