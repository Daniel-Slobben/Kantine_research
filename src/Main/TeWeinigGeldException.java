package Main;

/**
 * Write a description of class Main.TeWeinigGeldException here.
 * 
 */
public class TeWeinigGeldException extends Exception
{
   public TeWeinigGeldException()
   {
       super("Er is te weinig geld");
   }
   public TeWeinigGeldException(Exception e)
   {
       super(e);
   }
   public TeWeinigGeldException(String message)
   {
       super(message);
   }
   
}