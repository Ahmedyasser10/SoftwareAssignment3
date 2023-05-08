import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class catalog {
    public void ShowCatalog()
    {
        try
        {
            File file=new File("catalog.txt");
            Scanner read=new Scanner(file);
            while (read.hasNextLine())
            {
                System.out.println(read.nextLine());
            }
            read.close();

        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
    }

    public void ReturnItem(String name)
    {
        Map<String,Double> items=new HashMap<>();
        try
        {

            FileReader file=new FileReader("catalog.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String line=scanner.nextLine();
                String[] separate=line.split(" ");
                String item=separate[0];
                Double price=Double.parseDouble(separate[1]);
                items.put(item,price);
            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println("File not found.");
        }
        if(items.containsKey(name))
        {
            System.out.println(name+" : "+items.get(name)+" LE");
        }
        else {
            System.out.println(name +"  doesn't exist in our site\n");
        }

    }
}
