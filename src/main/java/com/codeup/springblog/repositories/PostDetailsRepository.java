package com.codeup.springblog.repositories;

import com.codeup.springblog.model.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {
}
