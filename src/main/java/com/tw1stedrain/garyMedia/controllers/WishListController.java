package com.tw1stedrain.garyMedia.controllers;


import com.tw1stedrain.garyMedia.models.Wish;
import com.tw1stedrain.garyMedia.models.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/wishList")
public class WishListController {

    @Autowired
    WishListRepo wishListRepo;

    @GetMapping("/allwishes")
    public String allWishes(
            Model model
    ){
        List<Wish> wishList = wishListRepo.findAll();

        model.addAttribute("wishList", wishList);
        return "wishList/wishList";
    }

    @PostMapping("/newwish")
    public RedirectView createWish(String title, String coverArt, String imdbLink, String tvOrMovie){
        Wish wish = new Wish(title, coverArt, imdbLink, tvOrMovie);

        wishListRepo.save(wish);
        return new RedirectView("/wishList/allwishes");
    }

    @DeleteMapping("/wish/{id}")
    public RedirectView deleteWish(
            @PathVariable long id
    ){
        wishListRepo.deleteById(id);
        return new RedirectView("/wishList/allwishes");
    }
}
