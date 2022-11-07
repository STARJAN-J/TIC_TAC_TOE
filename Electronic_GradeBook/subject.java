package Electronic_GradeBook;

import java.util.*;

public class subject 
{
    int Tamil, English, Maths;
    int N = 3;

    public void Get_marks(int tamil, int englsih, int maths)
    {
        Tamil=tamil;
        English = englsih;
        Maths = maths;
    }

    public void Get_sub()
    {
        
            System.out.println("Tamil - "+ Tamil);
            System.out.println("English - "+ English);
            System.out.println("Maths - "+ Maths);
        
    }
}