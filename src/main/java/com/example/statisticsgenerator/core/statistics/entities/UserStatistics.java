package com.example.statisticsgenerator.core.statistics.entities;

import com.example.statisticsgenerator.core.user.entities.User;
import lombok.Data;

@Data
public class UserStatistics {
    private Long id;
    private User user;
    private int totalOneToOneCount;
    private int totalQuestionCount;
    private int totalPoint;

    public void plusTotalPoint(Integer point){
        totalPoint += point;
    }

    public void incrementOneToOneCount(){
        totalOneToOneCount+=1;
    }

    public void incrementTotalQuestionCount(Integer count){
        totalQuestionCount+=count;
    }
}
