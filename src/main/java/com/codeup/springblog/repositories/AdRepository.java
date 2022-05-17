//package com.codeup.springblog.repositories;
//
//import com.codeup.springblog.model.Ad;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface AdRepository extends JpaRepository<Ad, Long> {
//    List<Ad> findAdByTitle (String title);

//    @Query(FROM Ad a WHERE a.title LIKE %?1%)
//    List<Ad> findAdByTitleLike (String title);
//
//}
