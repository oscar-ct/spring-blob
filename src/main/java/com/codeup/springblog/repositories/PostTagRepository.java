package com.codeup.springblog.repositories;

import com.codeup.springblog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository <Tag, Long> {
}
