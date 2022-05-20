package com.codeup.springblog.controllers;


import com.codeup.springblog.model.*;
import com.codeup.springblog.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final PostDetailsRepository postDetailsDao;
    private final PostImagesRepository postImagesDao;
    private final PostTagRepository postTagDao;

    public PostController(PostRepository postDao, UserRepository userDao, PostDetailsRepository postDetailsDao, PostImagesRepository postImagesDao, PostTagRepository postTagDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postDetailsDao = postDetailsDao;
        this.postImagesDao = postImagesDao;
        this.postTagDao = postTagDao;
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
    public String createPostForm(Model model) {
        LocalDate today = LocalDate.now();
        model.addAttribute("currentDate", today);
        return "posts/create";
    }

//    @PostMapping("/post/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
//        Post post = new Post(title, description);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

//    @PostMapping("/post/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, @RequestParam(name = "awesome") boolean awesome, @RequestParam(name = "post-history") String postHistory, @RequestParam(name = "topic") String topic) {
//
//        User user = userDao.getById(1L);
//        Post post = new Post();
//        PostDetails postDetails = new PostDetails(awesome, postHistory, topic);
//        postDetailsDao.save(postDetails);
//
//        post.setTitle(title);
//        post.setDescription(description);
//        post.setOwner(user);
//        post.setPostDetails(postDetails);
//
//        postDao.save(post);
//        return "redirect:/posts";
//    }

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

//    @PostMapping("/posts/edit")
//    public String updatePost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, @RequestParam(name = "id") long id) {
//        Post post = new Post(id, title, description);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/delete")
    public String updatePost(@RequestParam(name = "deletePost") long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }



//    @PostMapping("/posts/edit")
//    public String addPostImages(@RequestParam(name = "image") String imageUrl,
//                                @RequestParam(name = "id") long id,
//                                @RequestParam(name = "title") String imageTitle) {
//        System.out.println(imageTitle);
//        System.out.println(imageUrl);
//        System.out.println(id);
//        Post post = postDao.getById(id);
//        PostImage postImages = new PostImage(imageTitle, imageUrl, post);
//        List<PostImage> postImages1 = post.getPostImages();
//        postImages1.add(postImages);
//        post.setPostImages(postImages1);
//        postDao.save(post);
////        postImagesDao.save(postImages);
//        return "redirect:/posts";
//    }

    //    @PostMapping("/posts/edit")
//    public String updatePost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, @RequestParam(name = "id") long id) {
//        Post post = new Post(id, title, description);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/add")
    public String addPostImages(
                                @RequestParam(name = "id") long id,
                                @RequestParam(name = "title-add") String title4,
                                @RequestParam(name = "image-add") String image4) {

        Post post = postDao.getById(id);
        PostImage postImages = new PostImage(title4, image4, post);
        List<PostImage> postImages1 = post.getPostImages();
        postImages1.add(postImages);
        post.setPostImages(postImages1);
        postDao.save(post);
//        postImagesDao.save(postImages);
        return "redirect:/posts";
    }



    @PostMapping("/posts/edit")
    public String editPost4(
        @RequestParam(name = "id") long id,
        @RequestParam(name = "post-title") String postTitle,
        @RequestParam(name = "description") String postDescription,
        @RequestParam(required = false, name = "id1", defaultValue = "0") long id1,
        @RequestParam(required = false, name = "title1", defaultValue = "0") String title1,
        @RequestParam(required = false, name = "image1", defaultValue = "0") String image1,
        @RequestParam(required = false, name = "id2", defaultValue = "0") long id2,
        @RequestParam(required = false, name = "title2", defaultValue = "0") String title2,
        @RequestParam(required = false, name = "image2", defaultValue = "0") String image2,
        @RequestParam(required = false, name = "id3", defaultValue = "0") long id3,
        @RequestParam(required = false, name = "title3", defaultValue = "0") String title3,
        @RequestParam(required = false, name = "image3", defaultValue = "0") String image3,
        @RequestParam(required = false, name = "id4", defaultValue = "0") long id4,
        @RequestParam(required = false, name = "title4", defaultValue = "0") String title4,
        @RequestParam(required = false, name = "image4", defaultValue = "0") String image4)  {

        Post post = postDao.getById(id);
        post.setTitle(postTitle);
        post.setDescription(postDescription);
        postDao.save(post);
        if (id1 != 0) {
            PostImage postImage1 = postImagesDao.getById(id1);
            postImage1.setImageTitle(title1);
            postImage1.setImageUrl(image1);
            postImagesDao.save(postImage1);
        }
        if (id2 != 0) {
            PostImage postImage2 = postImagesDao.getById(id2);
            postImage2.setImageTitle(title2);
            postImage2.setImageUrl(image2);
            postImagesDao.save(postImage2);
        }
        if (id3 != 0) {
            PostImage postImage3 = postImagesDao.getById(id3);
            postImage3.setImageTitle(title3);
            postImage3.setImageUrl(image3);
            postImagesDao.save(postImage3);
        }
        if (id4 != 0) {
            PostImage postImage4 = postImagesDao.getById(id4);
            postImage4.setImageTitle(title4);
            postImage4.setImageUrl(image4);
            postImagesDao.save(postImage4);
        }
//        postImagesDao.save(postImages);
        return "redirect:/posts";
    }

//    @PostMapping("/posts/edit3")
//    public String editPost3(
//            @RequestParam(name = "id") long id,
//            @RequestParam(name = "post-title") String postTitle,
//            @RequestParam(name = "description") String postDescription,
//            @RequestParam(name = "id1") long id1,
//            @RequestParam(name = "title1") String title1,
//            @RequestParam(name = "image1") String image1,
//            @RequestParam(name = "id2") long id2,
//            @RequestParam(name = "title2") String title2,
//            @RequestParam(name = "image2") String image2,
//            @RequestParam(name = "id3") long id3,
//            @RequestParam(name = "title3") String title3,
//            @RequestParam(name = "image3") String image3) {
//
//        Post post = postDao.getById(id);
//        post.setTitle(postTitle);
//        post.setDescription(postDescription);
//        postDao.save(post);
//
//        PostImage postImage1 = postImagesDao.getById(id1);
//        postImage1.setImageTitle(title1);
//        postImage1.setImageUrl(image1);
//        postImagesDao.save(postImage1);
//
//        PostImage postImage2 = postImagesDao.getById(id2);
//        postImage2.setImageTitle(title2);
//        postImage2.setImageUrl(image2);
//        postImagesDao.save(postImage2);
//
//        PostImage postImage3 = postImagesDao.getById(id3);
//        postImage3.setImageTitle(title3);
//        postImage3.setImageUrl(image3);
//        postImagesDao.save(postImage3);
//
////        postImagesDao.save(postImages);
//        return "redirect:/posts";
//    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
    }




    @PostMapping("/post/create")
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "awesome") boolean awesome,
            @RequestParam(name = "post-history") String postHistory,
            @RequestParam(name = "topic") String topic,
            @RequestParam(name = "tags")List<Tag> tags,
            @RequestParam(required = false, name = "title1", defaultValue = "null") String title1,
            @RequestParam(required = false, name = "image1", defaultValue = "null") String image1,
            @RequestParam(required = false, name = "title2", defaultValue = "null") String title2,
            @RequestParam(required = false, name = "image2", defaultValue = "null") String image2,
            @RequestParam(required = false, name = "title3", defaultValue = "null") String title3,
            @RequestParam(required = false, name = "image3", defaultValue = "null") String image3,
            @RequestParam(required = false, name = "title4", defaultValue = "null") String title4,
            @RequestParam(required = false, name = "image4", defaultValue = "null") String image4)
             {



        User user = userDao.getById(1L);
        Post post = new Post();
        PostDetails postDetails = new PostDetails(awesome, postHistory, topic);
        post.setPostDetails(postDetails);
        post.setTitle(title);
        post.setDescription(description);
        post.setOwner(user);
        post.setPostTags(tags);
//        System.out.println(tags);

        if (!title1.equals("null")){
            PostImage postImage = new PostImage(title1, image1, post);
            post.getPostImages().add(postImage);
        }
        if (!title2.equals("null")) {
            PostImage postImage1 = new PostImage(title2, image2, post);
            post.getPostImages().add(postImage1);
        }
        if (!title3.equals("null")) {
            PostImage postImage2 = new PostImage(title3, image3, post);
            post.getPostImages().add(postImage2);
        }
        if (!title4.equals("null")) {
            PostImage postImage3 = new PostImage(title4, image4, post);
            post.getPostImages().add(postImage3);
        }


        postDao.save(post);
        return "redirect:/posts";
    }



    @PostMapping("/posts/delete/img")
    public String deletePostImg(@RequestParam(required = false, defaultValue = "0", name = "img") long id1,
                                @RequestParam(required = false, defaultValue = "0", name = "img1") long id2,
                                @RequestParam(required = false, defaultValue = "0", name = "img2") long id3,
                                @RequestParam(required = false, defaultValue = "0", name = "img3") long id4) {
        if (id1 != 0) {
            postImagesDao.deleteById(id1);
        }
        if (id2 != 0) {
            postImagesDao.deleteById(id2);
        }
        if (id3 != 0) {
            postImagesDao.deleteById(id3);
        }
        if (id4 != 0) {
            postImagesDao.deleteById(id4);
        }

        return "redirect:/posts";
    }



}
