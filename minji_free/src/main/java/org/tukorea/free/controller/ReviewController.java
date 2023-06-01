package org.tukorea.free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.service.ReviewService;

@Controller
@RequestMapping(value="/review")
public class ReviewController {	
	@Autowired(required=true)
	private ReviewService reviewService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listReview(@RequestParam("id") int id, Model model) throws Exception{
		List<ReviewVO> reviews = reviewService.readReviewList(id);
		model.addAttribute("reviews", reviews);
		return "review/review_list";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String readReview(@RequestParam("id") int id, Model model) throws Exception{
		ReviewVO review = reviewService.readReview(id);
		model.addAttribute("review", review);
		return "review/review_read";
	}
	
	@RequestMapping(value={"/register"}, method=RequestMethod.GET)
	public String writeReviewGet() throws Exception{
		return "review/review_write";
	}
	
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String createReviewPost(@ModelAttribute("review") ReviewVO vo, RedirectAttributes redirectAttributes) throws Exception {
		reviewService.addReview(vo);
		redirectAttributes.addAttribute("id", vo.getMovie_id());
		return "redirect:/review/list";
	}
	
            
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyReviewGet(@RequestParam("id") int id, Model model) throws Exception {
    	ReviewVO review = reviewService.readReview(id);
        model.addAttribute("review", review);
        return "review/review_modify";
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyReviewPost(@ModelAttribute("review") ReviewVO vo, RedirectAttributes redirectAttributes) throws Exception {
    	reviewService.updateReview(vo);
    	redirectAttributes.addAttribute("id", vo.getMovie_id());
		return "redirect:/review/list";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteReviewrPost(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) throws Exception{
    	ReviewVO review = reviewService.readReview(id);
    	reviewService.deleteReview(id);
    	redirectAttributes.addAttribute("id", review.getMovie_id());
    	return "redirect:/review/list";
    }
}
