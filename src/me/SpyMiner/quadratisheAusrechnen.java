package me.SpyMiner;
import java.lang.Math;

public class quadratisheAusrechnen
{
    public quadratisheAusrechnen(double a, double b, double c)
    {
        int mengeX = nullstellen(a, b, c);
        switch(mengeX)
        {
        case 0: break;
        case 1: System.out.println((-b)/(2 * a)); break;
        case 2: System.out.println((-b + Math.sqrt((b * b) - (4 * a * c)))/(2 * a)); System.out.println((-b - Math.sqrt((b * b) - (4 * a * c)))/(2 * a)); break;
        }
    }

    public int nullstellen(double a, double b, double c)
    {
        double d = (b * b) - (4 * a * c);
        if(d < 0)
        {
            System.out.println("keine losong");
            return 0;
        }
        else if (d == 0)
        {
            System.out.println("1 X");
            return 1;
        }
        else
        {
            System.out.println("2 X");
            return 2;
        }
    }
}
