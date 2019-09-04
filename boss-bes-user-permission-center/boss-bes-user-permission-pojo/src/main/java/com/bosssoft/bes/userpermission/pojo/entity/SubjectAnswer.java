package com.bosssoft.bes.userpermission.pojo.entity;

import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wukeqiang
 * @date 2019-09-02 10:49
 * @description : 试题答案实体
 */
@Repository
@Table(name = "`t_subject_answer`")
public class SubjectAnswer  implements Serializable {

    public SubjectAnswer(){
    }

    /**
     * 答案ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    /**
     * 答案名称
     */
    protected String answer;
    /**
     * 正确答案标志
     */
    protected Byte correct;
    /**
     * 答案对应的题目ID
     */
    protected Long subjectId;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Byte getCorrect() {
        return correct;
    }

    public void setCorrect(Byte correct) {
        this.correct = correct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "SubjectAnswer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                ", subjectId=" + subjectId +
                '}';
    }
}
