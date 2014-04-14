/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.PlayerClient;

import QuizProject.Servers.*;

/**
 *
 * @author Esha
 */
public interface QuizIDInterf{

    /**
     * Gets a quiz id number that increments
     * @return an incrementing ID number for Quiz ID. The incrementing number means that QuizID is unique.
     */
    int getQuizIDNumber();
    
}
