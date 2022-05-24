package com.codeup.springblog;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExerciseTest {


    @Autowired
    private PostRepository postDao;
    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder pen;

    @Autowired
    private MockMvc mvc;

    private User testUser;

    private HttpSession session;



    private void setUpTestUser() {
        testUser = userDao.findByUsername("testUser");
        if (testUser == null) {
            testUser = new User();
            testUser.setEmail("test@email.com");
            testUser.setPassword(pen.encode("password"));
            testUser.setUsername("testUser");
            testUser = userDao.save(testUser);
        }

    }

    private void setUpSession() throws Exception {
        session = mvc.perform(post("/login").with(csrf())
                        .param("username", testUser.getUsername())
                        .param("password", "password"))
                .andExpect(status().isFound())
                .andReturn()
                .getRequest()
                .getSession();

    }


    @Before
    public void setUp() throws Exception {
        setUpTestUser();
        setUpSession();
    }

    @Test
    public void testContext() {
        assertNotNull(mvc);
        assertNotNull(session);
    }


    @Test
    public void testPostCreation() throws Exception {
        mvc.perform(
                        post("/post/create")
                                .with(csrf())
                                .session((MockHttpSession) session)
                                .flashAttr("post", new Post("xxTestTitlexx", "body text"))
                ).andExpect(status().is3xxRedirection())
                .andDo(print());

        Post p = postDao.findFirstByTitle("xxTestTitlexx");
        postDao.deleteById(p.getId());

    }


    @Test
    public void testPostShow() throws Exception {
        Post post = postDao.findAll().get(0);

        mvc.perform(
                        get("/posts/" + post.getId())
                ).andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                post.getTitle()
                        )))
                .andExpect(content().string(
                        containsString(
                                post.getDescription()
                        )
                ));

    }


    @Test
    // test post index
    public void testPostIndex() throws Exception {
        Post post = postDao.findAll().get(0);

        mvc.perform(
                        get("/posts")
                ).andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                post.getTitle()
                        )))
                .andExpect(content().string(
                        containsString(
                                post.getDescription()
                        )
                ));
    }



    @Test
    public void testPostEdit() throws Exception {

        // need an existing item to edit
        Post post = new Post("New Post", "I am the body", testUser);

        post = postDao.save(post);

        // new values to change the current values to

        post.setTitle("Updated Title!");
        post.setDescription("Updated Body!!!");

        mvc.perform(post("/posts/edit")
                .with(csrf())
                .session((MockHttpSession) session)
                .flashAttr("post", post)
        ).andExpect(status().is3xxRedirection());


        // test if the values have changed
        mvc.perform(
                        get("/posts/" + post.getId())
                ).andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                post.getTitle()
                        )))
                .andExpect(content().string(
                        containsString(
                                post.getDescription()
                        )
                ));

        // delete the new post we created.
        postDao.deleteById(post.getId());
    }



    // test post delete
    @Test
    public void testPostDelete() throws Exception {


        // make a post to delete
        // need an existing item to delete
        Post post = new Post("New Post", "I am the body", testUser);
        post = postDao.save(post);

        Long id = post.getId();


        // post delete:f test that the post doesent exist
        mvc.perform(
                post("/posts/" + post.getId() + "/delete")
                        .with(csrf())
                        .session((MockHttpSession) session)
        ).andExpect(status().is3xxRedirection());

//         System.out.println("dbPost = " + dbPost);
        assertEquals(postDao.existsById(id), false);
    }







}
