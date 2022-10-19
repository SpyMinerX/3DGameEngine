package me.SpyMiner;



public class simutaniusequation
{
    public static void solve(double a, double b, double c, double d, double e, double f) {
    double det = 1/ ((a) * (d) - (b) * (c));
    double x = ((d) * (e) - (b) * (f)) / det;
    double y = ((a) * (f) - (c) * (e)) / det;
    System.out.println("x=" + x + " y=" + y);
}
}
