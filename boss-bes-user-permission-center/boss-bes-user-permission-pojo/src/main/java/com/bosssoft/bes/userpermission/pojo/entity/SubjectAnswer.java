package com.bosssoft.bes.userpermission.pojo.entity;

import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

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
    protected Byte ID;
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
    protected int subjectID;

    public Byte getID() {
        return ID;
    }

    public void setID(Byte ID) {
        this.ID = ID;
    }

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

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public String toString() {
        return "SubjectAnswer{" +
                "ID=" + ID +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                ", subjectID=" + subjectID +
                '}';
    }
}
