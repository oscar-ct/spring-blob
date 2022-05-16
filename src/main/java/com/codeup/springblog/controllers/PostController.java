package com.codeup.springblog.controllers;


import com.codeup.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    public List<Post> generatePost () {
        Post secondPost = new Post(2, "Apple Post", "All apple products");
        Post thirdPost = new Post(3, "Tesla Post", "All Tesla products");
        List<Post> allPosts = new ArrayList<>();
        allPosts.add(secondPost);
        allPosts.add(thirdPost);
         return allPosts;
    }


    @GetMapping("/posts")
    public String posts(Model model) {

       List<Post> allPosts = generatePost();

        model.addAttribute("posts", allPosts);

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, Model model) {

        List<Post> allPosts = generatePost();
            Post post = null;
        for (int i = 0 ; i < allPosts.size(); i++) {
            if (allPosts.get(i).getId() == id){
                post = allPosts.get(i);
            }
            model.addAttribute("post", post);
        }

        return "posts/show";
    }


//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createPostForm() {
//        return "view the form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "create a new post";
//    }


}
