import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz nazwę województwa a zostanie wpisana nazwa stolicy tego województwa :");

        String nazwaWojewodztwa = scanner.nextLine();

        System.out.println(nazwaStolicyWojewodztwa(nazwaWojewodztwa));
        
        scanner.close();
    }

    public static String nazwaStolicyWojewodztwa(String nazwaWojewodztwa)
    {
        String[][] arr = {
            {"Slask","Katowice"},
            {"Wielkopolska","Poznań"},
            {"Malopolska","Kraków"},
            {"Mazowieckie","Warszawa"},
            {"Lodzkie", "Łódź"}
        };
       
        for(int i=0;i<arr.length;i++)
        {
            for(int x=0;x<arr[i].length;x++)
            {

                if(arr[i][0].contains(nazwaWojewodztwa))
                {
                    return arr[i][1];
                }
            }
            
        }
        return "błędne województwo";
    }
}
