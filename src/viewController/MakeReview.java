package viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import static databases.DatabaseConnection.insert;
import org.springframework.stereotype.Controller;
@Controller
public class MakeReview {
	int order_id;
	@RequestMapping(value = "/redirect_make_review", method = RequestMethod.GET)
	public String redirect_make_reivew(ModelMap model, 
			@RequestParam int order_id) {
		System.out.println("GOT order_ID "+order_id);
		this.order_id = order_id;
		return "make_review";
	}
	
	@RequestMapping(value = "/make_review", method = RequestMethod.POST)
	public void make_review(ModelMap model,
			@RequestParam float rating,
			@RequestParam String detail
			) {
		String query = "INSERT INTO restaurant_review (order_id,rating,detail) VALUES ('"+order_id+"','"+rating+"','"+detail+"')";
		insert(query);
		System.out.println(order_id+" "+rating+" "+detail);
		
	}
	
}
