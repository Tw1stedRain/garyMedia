package com.tw1stedrain.garyMedia.controllers;

import com.tw1stedrain.garyMedia.models.Actor;
import com.tw1stedrain.garyMedia.models.ActorRepo;
import com.tw1stedrain.garyMedia.util.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    ActorRepo actorRepo;

    @GetMapping("/allactors")
    public String allActors(
            Model model,
            @RequestParam(required = false, defaultValue = "lastname") String sort
            ){
        List<Actor> actors = actorRepo.findAll();
        if (sort.equals("firstname")){
            actors = actorRepo.findAllByOrderByFirstName();
        } else if (sort.equals("lastname")){
            actors = actorRepo.findAllByOrderByLastName();
        }

        model.addAttribute("actors", actors);
        return "actors/actors";
    }

    @GetMapping("/actordetail/{id}")
    public String thisActor(
            @PathVariable long id
    ){
        return "actors/actorDetailPage";
    }

    @PostMapping("/newactor")
    public RedirectView createActor(String firstName, String lastName, int activeYearsStart, int activeYearsEnd, String imageUrl, String imdbUrl){
        Actor actor = new Actor(firstName, lastName, activeYearsStart, activeYearsEnd, imageUrl, imdbUrl);

        actorRepo.save(actor);
        return new RedirectView("/actors/allactors");
    }

    @GetMapping("/update/{id}")
    public String updateActorRoute(
            @PathVariable long id,
            Model model
    ){
        Optional<Actor> actor = actorRepo.findById(id);
        model.addAttribute("actor", actor.get());
        return "actors/actorDetailPage";
    }

    @PostMapping("/update/{id}")
    public RedirectView updateActor(
            @PathVariable long id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int activeYearsStart,
            @RequestParam int activeYearsEnd,
            @RequestParam String imageUrl,
            @RequestParam String imdbUrl,
            @RequestParam boolean dead,
            @RequestParam int yearDead

    ){
        Optional<Actor> actor = actorRepo.findById(id);
        if (actor.isPresent()){
            Actor foundActor = actor.get();

            foundActor.setFirstName(firstName);
            foundActor.setLastName(lastName);
            foundActor.setActiveYearsStart(activeYearsStart);
            foundActor.setActiveYearsEnd(activeYearsEnd);
            foundActor.setImageUrl(imageUrl);
            foundActor.setImdbUrl(imdbUrl);
            foundActor.setDead(dead);
            foundActor.setYearDead(yearDead);

            actorRepo.save(foundActor);
            return new RedirectView("/actors/update/" + id);
        }
        throw new ContentNotFoundException();
    }

    @DeleteMapping("/actor/{id}")
    public RedirectView deleteActor(
            @PathVariable long id
    ){
        actorRepo.deleteById(id);
        return new RedirectView("/actors/allactors");
    }
}
