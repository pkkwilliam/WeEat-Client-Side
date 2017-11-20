package viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static Values.Strings.getUserAttributes;
import static Values.Strings.users_SQLTable;

@Controller
public class RegisterController {
    @RequestMapping(value="register")
    public String register() {
    	    return "register";
    }
    @RequestMapping(value="registerHandler", method = RequestMethod.POST)
    public String registerHander(
    		@RequestParam String username,
    		@RequestParam String password,
    		@RequestParam String firstname,
    		@RequestParam String lastname,
    		@RequestParam String email1,
    		@RequestParam String email2,
    		@RequestParam String tel,
    		ModelMap model) {
    		
    		String values[] = {username,password,firstname,lastname,email1,tel,email2};
    	    String result = databases.DatabaseConnection.register(getUserAttributes(), values,users_SQLTable);
    	    model.addAttribute("result", result);
    	    return "register";
    }
}
