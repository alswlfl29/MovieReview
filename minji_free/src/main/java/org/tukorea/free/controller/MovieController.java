package org.tukorea.free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.free.domain.MovieVO;
import org.tukorea.free.service.MovieService;

@Controller
@RequestMapping(value="/movie")
public class MovieController {
	@Autowired(required=true)
	private MovieService movieService;
	
	@RequestMapping(value={"/list"}, method=RequestMethod.GET)
	public String listMovie(Model model) throws Exception{
		List<MovieVO> movies = movieService.readMovieList();
		model.addAttribute("movies", movies);
		return "main";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String readReview(@RequestParam("id") int id, Model model) throws Exception{
		MovieVO movie = movieService.readMovie(id);
		model.addAttribute("movie", movie);
		return "movie/movie_read";
	}
	
	@RequestMapping(value={"/register"}, method=RequestMethod.GET)
	public String registerMovieGet() throws Exception{
		return "movie/movie_register";
	}
	
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String registerMoviewPost(@ModelAttribute("movie") MovieVO vo) throws Exception {
		movieService.addMovie(vo);
		return "redirect:/movie/list";
	}
	
            
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyMovieGet(@RequestParam("id") int id, Model model) throws Exception {
    	MovieVO movie = movieService.readMovie(id);
        model.addAttribute("movie", movie);
        return "movie/movie_modify";
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyMoviePost(@ModelAttribute("movie") MovieVO vo) throws Exception {
    	movieService.updateMovie(vo);
        return "redirect:/movie/list";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteMoviePost(@RequestParam("id") int id, Model model) throws Exception{
    	movieService.deleteMovie(id);
    	return "redirect:/movie/list";
    }

}
