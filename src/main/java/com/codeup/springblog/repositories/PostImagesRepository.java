package com.codeup.springblog.repositories;

import com.codeup.springblog.model.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImagesRepository extends JpaRepository<PostImage, Long> {

}
