import java.util.Scanner;
public class SafeInput
{
    /**
     * get an arbitrary String of at least one character in length
     * @param pipe a Scanner opened to read from System.in
     * @param prompt String that tells the user what to input
     * @return a String response that is not zero in length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
            if (retString.length() == 0)
            {
                System.out.println("you must have an input");
            }
        }while(retString.length() == 0);
        return retString;
    }

    /**
     * us scanner to get an int from the console with no constraints
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @return returns an int
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 1;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Use Scanner to get a double from the console with no constraints
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @return returns a double
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get an integer value within a specified range of low - high
     * @param pipe Scanner tou use for console input
     * @param prompt String that tells the user what to input
     * @param low low value for a range low - high
     * @param high value for the range
     * @return an int within the low - high range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = low - 1;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    //  System.out.println("\nyou said your val is " + retVal);
                    done = true;
                } else {
                    System.out.println("you said your val is " + retVal + " but that is out of range [" + low + " - " + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a double value within a specified range of low - high
     * @param pipe Scanner tou use for console input
     * @param prompt String that tells the user what to input
     * @param low low value for a range low - high
     * @param high value for the range
     * @return a double  within the low - high range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = low - 1;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    //System.out.println("\nyou said your val is " + retVal);
                    done = true;
                } else {
                    System.out.println("you said your val is " + retVal + " but that is out of range [" + low + " - " + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number");
            }
        } while (!done);
        return retVal;
    }

    /**
     * gets a Y or an N and returns a true or a false respectively
     * @param pipe Scanner to use to get the input
     * @param prompt String prompt foor the user the you or no question
     * @return
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String confirmation = "";
        boolean done = false;
        boolean retVal = true;
        do
        {
            System.out.print(prompt + "[Y/N]: ");
            confirmation = pipe.nextLine();
            if (confirmation.equalsIgnoreCase("Y"))
            {
                done = true;
                retVal = true;
            }
            else if (confirmation.equalsIgnoreCase("N"))
            {
                done = true;
                retVal = false;
            }
            else
            {
                System.out.print(confirmation + " is not a valid answer you must enter [Y/N]");
            }
        } while (!done);
        return retVal;
    }

    /**
     * gets a string that matches a regular expression pattern like ###-##-#### \d{3}-\d{2}-\d{4}
     * @param pipe Scanner to use for input
     * @param prompt String prompt to tell the user what to input
     * @param pattern AregEx Pattern to use for the test
     * @return a String that matches the RexEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String pattern)
    {
        // figure this one out by asking other people
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(pattern))
            {
                done = true;
            }
            else
            {
                System.out.println("You did not match the pattern");
            }
        }while (!done);
        return retVal;
    }
}