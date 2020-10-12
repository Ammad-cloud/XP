package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.Tilkob;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

    @Controller
    public class ShopController {
        ArrayList<Tilkob> items = new ArrayList<>();

        public ShopController() {
            add();
        }

        public void add() {
            Tilkob soda = new Tilkob("Sodavand", 20.0);
            Tilkob haribo = new Tilkob("Sodavand", 20.0);
            Tilkob tshirt = new Tilkob("tshirt", 129.0);
            items.add(soda);
            items.add(haribo);
            items.add(tshirt);
        }


        @GetMapping("/home/shop")
        public String overview(Model viewModel) {
            viewModel.addAttribute("tilkob", items);
            viewModel.addAttribute("totalprice", 0);
            return "/home/shop";
        }

        @PostMapping("/home/shop")
        public String addTilkob(@RequestParam int sodaPrice, @RequestParam int hariboPrice, @RequestParam int tshirtPrice,  Model model) {



            int totalPrice = (sodaPrice * 20) + (hariboPrice * 20) + (tshirtPrice * 129);
            model.addAttribute("totalprice", totalPrice);
            System.out.println(totalPrice + "kr     ");


            return "/home/shop";
        }
    }



