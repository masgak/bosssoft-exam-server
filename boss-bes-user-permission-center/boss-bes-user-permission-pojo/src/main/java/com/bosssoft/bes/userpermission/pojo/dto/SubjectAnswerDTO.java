package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.SubjectAnswer;

public class SubjectAnswerDTO extends SubjectAnswer {

    public SubjectAnswerDTO(){
    }

    @Override
    public String toString() {
        return "SubjectAnswerDTO{" +
                "ID=" + ID +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                ", subjectID=" + subjectID +
                '}';
    }
}
