package project2;

/**
 * CIS 27C
 * Project 2
 * Andrew Headrick
 * May 2010
 */

public class ShortName {

          private String FirstName;

          private String LastName;

         

          public ShortName()

          {

                   FirstName = "";

                   LastName  = "";

          }

         

          public ShortName(String First, String Last)

          {

                   FirstName = First;

                   LastName  = Last;

          }

         

          public void SetFirst(String First) { FirstName = First; }

          public void SetLast(String Last)   { LastName = Last; }

         

          public String GetFirst()  { return FirstName; }

          public String GetLast()   { return LastName;  }

          @Override
          public String toString(){
              return FirstName + " " + LastName;
          }

 

}