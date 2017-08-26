package com.moier.dao;

import com.moier.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Name
 * @Description:
 * @Author hunaghuasong_cd@keruyun.com
 * @Date 2017/8/26 16:44
 */
public interface ReadingListRepository extends JpaRepository<Book,Long>{

    List<Book> findByReader(String reader);
}
