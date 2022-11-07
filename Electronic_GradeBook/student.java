package Electronic_GradeBook;

import java.util.*;

public class student 
{
    String Name;
    int Age, RollNo;
    // int Age = 0;
    
    public void student_Profile(String name, int age, int rollno)
    {
        Name=name;
        Age = age;
        RollNo = rollno;
    }

    public void print_details()
    {
        String str = String.format("The name is %s", Name);
        String str1 = String.format("The " +Name+ " age is %d", Age);
        String str2 = String.format("The " +Name+ " rollno is %d", RollNo); 
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}
