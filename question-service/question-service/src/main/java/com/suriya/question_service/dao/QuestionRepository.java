package com.suriya.question_service.dao;


import com.suriya.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findByCategory(String category);

//    @Query(value = "select * from question where category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
//    List<Question> findByCategoryAndFilterByLimit(String category, int numQ);
@Query(value = "select q.id from question q where category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
List<Integer> findByCategoryAndFilterByLimit(String category, int numQ);
}
