import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        final String menu = "A - add D - delete P - print Q - quit";
        boolean done = false;
        boolean Adone = false;
        boolean Ddone = false;
        boolean quit = false;

        int deleteItem = 0;
        int addnum = 0;

        String cmd = "";
        String item = "";

        do {
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd)
            {
                case "A":
                    do
                    {
                        Adone = false;
                        dispalayList();
                        item = SafeInput.getNonZeroLenString(in, "what item would you like to input ");
                        if (list.size() > 0)
                        {
                            addnum = SafeInput.getRangedInt(in, "Where would you like to in put it", 1, (list.size() + 1));
                            addnum--;
                            list.add(addnum, item);
                        }
                        else
                            list.add(item);
                        Adone = SafeInput.getYNConfirm(in, "Are you done with adding");
                    }while (!Adone);
                    break;
                case "D":
                    do
                    {
                        Ddone = false;
                        dispalayList();
                        deleteItem = SafeInput.getRangedInt(in, "what is the number of the item you would like to delete ", 1, list.size());
                        deleteItem --;
                        list.remove(deleteItem);
                        Ddone = SafeInput.getYNConfirm(in, "Are you done with deleting");
                    }while (!Ddone);
                    break;
                case "P":
                    dispalayList();
                    break;
                case "Q":
                    quit = false;
                    quit = SafeInput.getYNConfirm(in, "Are you sure that you want to quit");
                    if (quit == true)
                    {
                        System.exit(0);
                    }
                    break;
            }
        }while(!done);
    }

    private static void dispalayList()
    {
        System.out.println("----------------------------------------------------");
        if (list.size() !=0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i + 1, list.get(i));
                System.out.println();
            }
        }
        else System.out.println("list is empty");
        System.out.println("----------------------------------------------------");
    }
}
