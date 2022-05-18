package com.codeup.springblog.controllers;


import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }





//    public List<Post> generatePost () {
//        Post secondPost = new Post(2, "Apple Post", "All apple products");
//        Post thirdPost = new Post(3, "Tesla Post", "All Tesla products");
//        List<Post> allPosts = new ArrayList<>();
//        allPosts.add(secondPost);
//        allPosts.add(thirdPost);
//         return allPosts;
//    }
//

//
//    @GetMapping("/posts")
//    public String posts(Model model) {
//
//        List<Post> allPosts = generatePost();
//
//        model.addAttribute("posts", allPosts);
//
//        return "posts/index";
//    }


//    @GetMapping("/posts/{id}")
//    public String postById(@PathVariable long id, Model model) {
//
//        List<Post> allPosts = generatePost();
//            Post post = null;
//        for (int i = 0 ; i < allPosts.size(); i++) {
//            if (allPosts.get(i).getId() == id){
//                post = allPosts.get(i);
//            }
//            model.addAttribute("post", post);
//        }
//
//        return "posts/show";
//    }


    @GetMapping("/post/create")
    public String createPostForm() {
        return "posts/create";
    }

//    @PostMapping("/post/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
//        Post post = new Post(title, description);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @PostMapping("/post/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
        User user = userDao.getById(1L);
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @PostMapping("/posts/edit")
    public String updatePost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, @RequestParam(name = "id") long id) {
        Post post = new Post(id, title, description);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String updatePost(@RequestParam(name = "deletePost") long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }



}
