package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.SubjectAnswer;

public class SubjectAnswerDTO extends SubjectAnswer {

    public SubjectAnswerDTO(){
    }

    @Override
    public String toString() {
        return "SubjectAnswerDTO{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                ", subjectId=" + subjectId +
                '}';
    }
}
