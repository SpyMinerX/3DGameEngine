package me.spyminer.engine;

public class Logger
{
    public Logger()
    {
    }

    public static void error(String err)
    {
        System.out.println("[" + java.time.LocalDateTime.now()  + "] Error: " + err);
    }
        public static void warning(String err)
    {
        System.out.println("[" + java.time.LocalDateTime.now()  + "] Warning: " + err);
    }
        public static void info(String err)
    {
        System.out.println("[" + java.time.LocalDateTime.now()  + "] Info: " + err);
    }
}
