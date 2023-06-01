package org.tukorea.free.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired(required=true)
	private UserService userService;

	@RequestMapping(value={"/signin"}, method=RequestMethod.GET)
	public String signInPageGet() throws Exception{
		return "user/signin";
	}
	
    @RequestMapping(value = {"/signin"}, method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute UserVO vo, HttpSession session, Model model) throws Exception {
		int user_id=userService.loginCheck(vo, session);
		if(user_id != -1) { // 로그인 성공
			return "redirect:/movie/list";
		}
		else {
			model.addAttribute("message", "error");
			return "redirect:/user/signin";
		}
	}
    
    @RequestMapping(value= {"/logout"})
    public ModelAndView logout(HttpSession session, ModelAndView mav) throws Exception{
    	userService.logout(session);
    	mav.setViewName("redirect:/movie/list");
    	return mav;
    }
	
	@RequestMapping(value={"/signup"}, method = RequestMethod.GET)
	public String signUpPageGet() throws Exception{
		return "user/signup";
	}
	
	@RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
	public String createUserPost(@ModelAttribute("user") UserVO vo) throws Exception {
		userService.addUser(vo);
		return "redirect:/user/signin";
	}
	
	@RequestMapping(value="/mylist", method=RequestMethod.GET)
	public String listMyReview(@RequestParam("id") int id, Model model) throws Exception{
		List<ReviewVO> reviews = userService.readMyList(id);
		model.addAttribute("reviews", reviews);
		return "user/my_list";
	}
	
    @RequestMapping(value = "/modify-title", method = RequestMethod.GET)
    public String modifyTitleReviewGet(@RequestParam("id") int id, Model model) throws Exception {
    	List<ReviewVO> reviews = userService.readMyList(id);
    	model.addAttribute("reviews", reviews);
        return "user/my_list_modify";
    }
    
    @RequestMapping(value = "/modify-title", method = RequestMethod.POST)
    public String modifyTitleReviewPost(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
    	String[] review_ids = request.getParameterValues("review_id");
    	List<ReviewVO> reviewList = new ArrayList<>();
    	
    	for (String review_id : review_ids) {
    		String title = request.getParameter("title_" + review_id);
    		String user_id=request.getParameter("user_id");
            ReviewVO review = new ReviewVO();
            review.setReview_id(Integer.parseInt(review_id));
            review.setTitle(title);
            review.setUser_id(Integer.parseInt(user_id));
            reviewList.add(review);
        }
    	try {
    		userService.updateReviewList(reviewList);
    		System.out.println("TRANSACTION 처리 완료");
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
	    redirectAttributes.addAttribute("id", reviewList.get(0).getUser_id());
		return "redirect:/user/mylist";
    }
}
