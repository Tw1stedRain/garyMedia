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
@RequestMapping("/tv")
public class TvController {

    @Autowired
    TvSeasonRepo tvRepo;

    @Autowired
    ActorRepo actorRepo;

    @GetMapping("/allTv")
    public String allTv(Model model){
        List<TvSeason> tvSeasons = tvRepo.findAll();
        model.addAttribute("seasons", tvSeasons);
        return "tvSeasons/seasons";
    }

    // TODO: get all tv seasons route (sorted by rating, duration, actor)

    @GetMapping("/seasonDetail/{id}")
    public String thisSeason(
            @PathVariable Long id
    ){
        return "tvSeasons/seasonDetailPage";
    }

    // TODO: create a new tv season
    @PostMapping("/newSeason")
    public RedirectView createSeason(String title, String coverArt, int numOfEpisodes, String genre, String rating, int releaseDate, String imdbLink, double rottenTomatoes){

        TvSeason tvSeason = new TvSeason(title, coverArt, numOfEpisodes, genre, rating, releaseDate, imdbLink, rottenTomatoes);
        tvRepo.save(tvSeason);
        return new RedirectView("/tv/allTv");
    }

    // TODO: this is where you get to add series and actor connections (when theyre setup)
    @GetMapping("/update/{id}")
    public String updateTvSeasonRoute(
            @PathVariable Long id,
            Model model
    ){
        Optional<TvSeason> season = tvRepo.findById(id);
        List<Actor> actors = actorRepo.findAll();
        model.addAttribute("season", season.get());
        model.addAttribute("actors", actors);
        return "tvSeasons/seasonDetailPage";
    }

    @PostMapping("/update/{id}")
    public RedirectView updateSeason(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String coverArt,
            @RequestParam int numOfEpisodes,
            @RequestParam String genre,
            @RequestParam String rating,
            @RequestParam String dvdOrBluRay,
            @RequestParam int releaseDate,
            @RequestParam String imdbLink,
            @RequestParam double rottenTomatoes,
            @RequestParam boolean loaned,
            @RequestParam String loanedTo,
            @RequestParam Set<Actor> actors
    ){
        Optional<TvSeason> season = tvRepo.findById(id);
        if (season.isPresent()){
            TvSeason foundSeason = season.get();

            foundSeason.setTitle(title);
            foundSeason.setCoverArt(coverArt);
            foundSeason.setNumOfEpisodes(numOfEpisodes);
            foundSeason.setGenre(genre);
            foundSeason.setRating(rating);
            foundSeason.setDvdOrBluRay(dvdOrBluRay);
            foundSeason.setReleaseDate(releaseDate);
            foundSeason.setImdbLink(imdbLink);
            foundSeason.setRottenTomatoes(rottenTomatoes);
            foundSeason.setLoaned(loaned);
            foundSeason.setLoanedTo(loanedTo);
            foundSeason.setTvActors(actors);

            tvRepo.save(foundSeason);
            return new RedirectView("/tv/update/" + id);
        }
        throw new ContentNotFoundException();
    }

    @DeleteMapping("/season/{id}")
    public RedirectView deleteSeason(
            @PathVariable long id
    ){
        tvRepo.deleteById(id);
        return new RedirectView("/tv/allTv");
    }
}
