package com.tw1stedrain.garyMedia.controllers;

import com.tw1stedrain.garyMedia.models.*;
import com.tw1stedrain.garyMedia.util.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    SeriesRepo seriesRepo;

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    TvSeasonRepo tvSeasonRepo;

    @GetMapping("/allseries")
    public String allSeries(Model model){
        List<Series> series = seriesRepo.findAll();
        model.addAttribute("series", series);
        return "series/series";
    }

    @GetMapping("/seriesdetail/{id}")
    public String thisSeries(
            @PathVariable long id
    ){
        return "series/seriesDetailPage";
    }

    @PostMapping("/newseries")
    public RedirectView createSeries(String name, int yearsRunStart, int yearsRunEnd, String coverArt, String imdbUrl){
        Series newSeries = new Series(name, yearsRunStart, yearsRunEnd, coverArt, imdbUrl);

        seriesRepo.save(newSeries);
        return new RedirectView("/series/allseries");
    }

    @GetMapping("/update/{id}")
    public String updateSeriesRoute(
            @PathVariable long id,
            Model model
    ){
        Optional<Series> series = seriesRepo.findById(id);
        List<Movie> movies = movieRepo.findAll();
        List<TvSeason> tvSeasons = tvSeasonRepo.findAll();
        model.addAttribute("series", series.get());
        model.addAttribute("movies", movies);
        model.addAttribute("tvSeasons", tvSeasons);
        return "series/seriesDetailPage";
    }

    @PostMapping("/update/{id}")
    public RedirectView updateSeries(
            @PathVariable long id,
            @RequestParam String name,
            @RequestParam int yearsRunStart,
            @RequestParam int yearsRunEnd,
            @RequestParam String coverArt,
            @RequestParam String imdbUrl,
            @RequestParam Movie movie,
            @RequestParam TvSeason tvSeason
            ){
        Optional<Series> series = seriesRepo.findById(id);
        if (series.isPresent()){
            Series foundSeries = series.get();

            foundSeries.setName(name);
            foundSeries.setYearsRunStart(yearsRunStart);
            foundSeries.setYearsRunEnd(yearsRunEnd);
            foundSeries.setCoverArt(coverArt);
            foundSeries.setImdbUrl(imdbUrl);
            foundSeries.addMovie(movie);
            foundSeries.addSeason(tvSeason);

            seriesRepo.save(foundSeries);
            return new RedirectView("/series/update/" + id);
        }
        throw new ContentNotFoundException();
    }


    @DeleteMapping("/series/{id}")
    public RedirectView deleteSeries(
            @PathVariable long id
    ){
        seriesRepo.deleteById(id);
        return new RedirectView("/series/allseries");
    }


}
