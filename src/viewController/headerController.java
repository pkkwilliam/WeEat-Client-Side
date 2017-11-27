package viewController;

import static Values.Strings.sessionCart;
import static Values.Strings.sessionUsername;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.reactive.result.view.RedirectView;

@Controller
@SessionAttributes({sessionUsername,sessionCart})

public class headerController {
	
    @RequestMapping(value = "/header", method = RequestMethod.GET)
    public String header(ModelMap model) {
        model.addAttribute("username",String.valueOf(model.get(sessionUsername)));
    	    return "header";
    }
    @RequestMapping(value= "/checkLogin", method = RequestMethod.GET)
    public String checkLogin(ModelMap model) {
    	System.out.println("check login username = " +model.get(sessionUsername));
    	    if(model.get(sessionUsername) == null)
    	        return "redirect:/login";
    	    else
    	    	    return "welcome";
    }
    
	@RequestMapping(value = "go_shopping_cart", method = RequestMethod.GET)
	public String shopping_cart(ModelMap model) {
		return "/shopping_cart";
	}
    
    @RequestMapping(value ="/clearSession", method = RequestMethod.GET)
	public String clearSession(ModelMap model, SessionStatus session) {
		 session.setComplete();
		 model.put(sessionCart, null);
		 model.put(sessionUsername, null);
		 return "redirect:/login";
	}
}
