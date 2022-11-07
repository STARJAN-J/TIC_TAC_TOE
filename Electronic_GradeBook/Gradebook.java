package Electronic_GradeBook;

import java.util.*;

public class Gradebook
{
    public static void main(String[] args) 
    {
            student student1 = new student();
            student1.student_Profile("rex", 25, 28);
            student1.print_details();
        
            student student2 = new student();
            student2.student_Profile("starjan", 22, 29);
            student2.print_details();

            student student3 = new student();
            student3.student_Profile("anand", 27, 30);
            student3.print_details();

            subject rex = new subject();
            rex.Get_marks(97, 25, 28);
            rex.Get_sub();
    }    
}
