package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @GetMapping
    @ResponseBody
    public String allAlbums() {
        return "insert all albums";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String showOneAlbum(@PathVariable long id) {
        return "insert one album of " + id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createAlbumForm() {
        return "this is where you would view the form to create an album in the db";
    }


    @PostMapping()
    @ResponseBody
    public String createAlbum() {
        return "This is where the logic would be for when the create albums form is submitted";
    }


}
