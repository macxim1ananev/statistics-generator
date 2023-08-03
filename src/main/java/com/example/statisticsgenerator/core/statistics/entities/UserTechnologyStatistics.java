package com.example.statisticsgenerator.core.statistics.entities;

import com.example.statisticsgenerator.core.technology.entities.Technology;
import lombok.Data;

@Data
public class UserTechnologyStatistics {
    Long id;
    UserStatistics userStatistics;
    Technology technology;
    int questionCount;
    int totalPoint;

    public void incrementQuestionCount(){
        questionCount+=1;
    }

    public void plusTotalPoint(Integer point){
        totalPoint += point;
    }
}
