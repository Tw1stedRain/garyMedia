package com.tw1stedrain.garyMedia.controllers;

import com.tw1stedrain.garyMedia.models.Actor;
import com.tw1stedrain.garyMedia.models.Movie;
import com.tw1stedrain.garyMedia.models.MovieRepo;
import com.tw1stedrain.garyMedia.util.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepo movieRepo;

    @GetMapping("/allmovies")
    public String allMovies(Model model){
        List<Movie> movies = movieRepo.findAll();
        model.addAttribute("movies", movies);
        return "movies/movies";
    }

    @GetMapping("/moviedetail/{id}")
    public String thisMovie(
            @PathVariable Long id
    ){
    // TODO: movie detail page
        return "movies/movieDetailPage";
    }

    // TODO: get all movies to sort (sorted by rating, duration, actor) - may have to be done with a little JS

    @PostMapping("/newmovie")
    public RedirectView createMovie(String title, String coverArt, int duration, int releaseDate, String dvdOrBluRay, String genre, String rating, String imdb, double tomatoes){
        //TODO: when actors are implemented properly, add them back in

        Movie movie = new Movie(title, coverArt, duration, releaseDate, dvdOrBluRay, genre, rating, imdb, tomatoes);

        movieRepo.save(movie);
        return new RedirectView("/movies/allmovies");
    }

    @GetMapping("/update/{id}")
    public String updateMovieRoute(
            @PathVariable Long id,
            Model model
    ){
        Optional<Movie> movie = movieRepo.findById(id);
        model.addAttribute("movie", movie.get());
        return "movies/movieDetailPage";
    }

    // TODO: this is where you get to add series connection
    @PostMapping("/update/{id}")
    public RedirectView updateMovie(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String coverArt,
            @RequestParam int duration,
            @RequestParam int releaseDate,
            @RequestParam String dvdOrBluRay,
            @RequestParam String genre,
            @RequestParam String rating,
            @RequestParam String imdb,
            @RequestParam double tomatoes,
            @RequestParam boolean loaned
    ){
        Optional<Movie> movie = movieRepo.findById(id);
        if (movie.isPresent()){
            Movie foundMovie = movie.get();

            foundMovie.setTitle(title);
            foundMovie.setCoverArt(coverArt);
            foundMovie.setDurationInMinutes(duration);
            foundMovie.setReleaseDate(releaseDate);
            foundMovie.setDvdOrBluRay(dvdOrBluRay);
            foundMovie.setGenre(genre);
            foundMovie.setRating(rating);
            foundMovie.setImdbLink(imdb);
            foundMovie.setRottenTomatoes(tomatoes);
            foundMovie.setLoaned(loaned);

            movieRepo.save(foundMovie);
            return new RedirectView("/movies/allmovies");
        }
        throw new ContentNotFoundException();
    }


    @DeleteMapping("/movie/{id}")
    public RedirectView deleteMovie(
            @PathVariable long id
    ){
        this.movieRepo.deleteById(id);
        return new RedirectView("/movies/allmovies");
    }
}
