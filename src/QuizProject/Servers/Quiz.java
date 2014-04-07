/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.Servers;

import java.io.Serializable;

/**
 *
 * @author Esha
 */
public class Quiz implements QuizInterf, Serializable{

    private int quizID; //check permissions on all classes for fields and methods before submission
    private String quizName;
    private String[] quesAnsStringArray = new String[6];
    private int highestScore = 0;

    @Override
    public void setQuizName(String nameOfQuiz) {
        this.quizName = nameOfQuiz;
    }

    @Override
    public String getQuizName() {
        return this.quizName;
    }

    @Override
    public void checkObjectIsNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("THE ARGUMENT WAS NULL. ");
        }
    }
    
    @Override
    public void setQuizID(int idOfQuiz) {
        checkObjectIsNotNull(idOfQuiz);
        this.quizID = idOfQuiz;
    }

    @Override
    public int getQuizID() {
        return this.quizID;
    }
    
    @Override
    public void setHighestScore(int score) {
        checkObjectIsNotNull(score);
        this.highestScore = score;
    }

    @Override
    public int getHighestScore() {
        return this.highestScore;
    }

    @Override
    public String[] getQuesAns() {
        return this.quesAnsStringArray;
    }

    @Override
    public void setQuesAns(String[] QA) {
        checkObjectIsNotNull(QA);
        this.quesAnsStringArray = QA;
    }
}
