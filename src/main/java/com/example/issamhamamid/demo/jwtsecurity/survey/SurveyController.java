package com.example.issamhamamid.demo.jwtsecurity.survey;

import com.example.issamhamamid.demo.jwtsecurity.dto.DateQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


public class SurveyController {
    @Autowired
    SurveyRepository surveyRepository;

    @GetMapping("/count")
    public Long getsurveys(@RequestBody DateQ date) {
        return surveyRepository.countByDate(date.getDay(), date.getMonth(), date.getYear());
    }

    @GetMapping("/getsurv")
    public List<Survey >getsurveys() {
       return  surveyRepository.getsurvey();
    }
}
