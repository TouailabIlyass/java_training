/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import models.Student;
import view.StudentView;

/**
 *
 * @author drging
 */
public class Main {
 
    public static void main(String[] args) {
        Student model = getStudentFromDB();
        
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(model,view);
        controller.updateView();
    }
    
    public static Student getStudentFromDB()
    {
        Student st = new Student();
        st.setName("alami");
        st.setNum("1");
        return st;
    }
}
