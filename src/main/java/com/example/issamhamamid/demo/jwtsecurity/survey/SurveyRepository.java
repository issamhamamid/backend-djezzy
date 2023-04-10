package com.example.issamhamamid.demo.jwtsecurity.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    @Query("SELECT COUNT(i) FROM Survey i WHERE DAY(i.ingestionDttm) = :day AND MONTH(i.ingestionDttm) = :month AND YEAR(i.ingestionDttm) = :year")
    Long countByDate(@Param("day") int day, @Param("month") int month, @Param("year") int year);

    @Query("SELECT s FROM Survey s WHERE s.contractNumberB2cMob = 306597183 ")
    List<Survey> getsurvey ();


}
