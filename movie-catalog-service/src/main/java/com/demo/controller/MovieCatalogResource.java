package com.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.CatalogItem;
import com.demo.model.Movie;
import com.demo.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//get all rated movies by user
		UserRating ratings=restTemplate.getForObject("http://user-rating-service/ratingsdata/users/"+userId, UserRating.class);
		// for each movieId , call movie info service and get details
		
		return ratings.getUserRating().stream().map(rating -> {
				Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
				return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
			}).collect(Collectors.toList());
			
		//put them all together
		/*return Collections.singletonList(
					new CatalogItem("Alien", "girlfriend", 5)
				);*/
	}
}
