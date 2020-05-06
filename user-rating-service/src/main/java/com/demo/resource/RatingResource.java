package com.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Rating;
import com.demo.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId){
		return new Rating(movieId,4);
	}
	
	@GetMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId){
		List<Rating> ratings=Arrays.asList(new Rating("12",2),new Rating("13",5));
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
	

}
