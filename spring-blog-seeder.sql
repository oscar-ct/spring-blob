

USE spring_blog_db;
INSERT INTO post_images (image_title, image_url, post_id) VALUES ('Black Cat', 'https://cf.ltkcdn.net/cats/images/orig/293922-1600x1066-black-cat-lies.jpg',2);
INSERT INTO post_images (image_title, image_url, post_id) VALUES ('White Cat', 'https://www.thehappycatsite.com/wp-content/uploads/2017/12/White-Cat-HC-long.jpg', 2);
INSERT INTO post_images (image_title, image_url, post_id) VALUES ('Black Cat', 'https://i.pinimg.com/564x/e7/2d/8a/e72d8ad92a0eb351b7e98c87f2b1a1c0.jpg', 2);


INSERT INTO tags (name) VALUES ('Silly');
INSERT INTO tags (name) VALUES ('Funny');
INSERT INTO tags (name) VALUES ('Humor');

INSERT INTO post_tag (post_id, tag_id) VALUES (2, 1);
INSERT INTO post_tag (post_id, tag_id) VALUES (2, 2);
INSERT INTO post_tag (post_id, tag_id) VALUES (3, 2);
INSERT INTO post_tag (post_id, tag_id) VALUES (3, 3);