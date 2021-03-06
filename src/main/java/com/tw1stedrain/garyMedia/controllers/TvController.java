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


@Controller
@RequestMapping("/tv")
public class TvController {

    @Autowired
    TvSeasonRepo tvRepo;

    @Autowired
    ActorRepo actorRepo;

    @GetMapping("/allTv")
    public String allTv(
            Model model,
            @RequestParam(required = false, defaultValue = "title") String sort,
            @RequestParam(required = false)String keyword
            ){
        List<TvSeason> tvSeasons = tvRepo.findAll();
        switch (sort) {
            case "title":
                if (keyword != null){
                    tvSeasons = tvRepo.findByTitleContains(keyword);
                } else {
                tvSeasons = tvRepo.findAllByOrderByTitle();
                }
                break;
            case "episodes":
                tvSeasons = tvRepo.findAllByOrderByNumOfEpisodes();
                break;
            case "genre":
                tvSeasons = tvRepo.findAllByOrderByGenre();
                break;
            case "rating":
                tvSeasons = tvRepo.findAllByOrderByRating();
                break;
            case "loaned":
                tvSeasons = tvRepo.findAllByLoanedTrue();
        }

        model.addAttribute("seasons", tvSeasons);
        return "tvSeasons/seasons";
    }

    @GetMapping("/seasonDetail/{id}")
    public String thisSeason(
            @PathVariable Long id
    ){
        return "tvSeasons/seasonDetailPage";
    }

    @PostMapping("/newSeason")
    public RedirectView createSeason(String title, String coverArt, int numOfEpisodes, String genre, String rating, int releaseDate, String imdbLink, double rottenTomatoes){

        TvSeason tvSeason = new TvSeason(title, coverArt, numOfEpisodes, genre, rating, releaseDate, imdbLink, rottenTomatoes);
        tvRepo.save(tvSeason);
        return new RedirectView("/tv/allTv");
    }

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
            @RequestParam boolean ownerChanged,
            @RequestParam String newOwner,
            @RequestParam Actor actor
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
            foundSeason.setOwnerChanged(ownerChanged);
            foundSeason.setNewOwner(newOwner);
            foundSeason.addTvActor(actor);

            tvRepo.save(foundSeason);
            return new RedirectView("/tv/update/" + id);
        }
        throw new ContentNotFoundException();
    }

    @PostMapping("/removeactor/{seasonid}/{actorid}")
    public RedirectView removeActor(
            @PathVariable long seasonid,
            @PathVariable long actorid
    ){
        Optional<TvSeason> season = tvRepo.findById(seasonid);
        Optional<Actor> actor = actorRepo.findById(actorid);
        if (season.isPresent()){
            TvSeason foundSeason = season.get();
            if (actor.isPresent()){
                Actor foundActor = actor.get();
                foundSeason.removeTvActor(foundActor);

            }
            tvRepo.save(foundSeason);
            return new RedirectView("/tv/update/" + seasonid);
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
