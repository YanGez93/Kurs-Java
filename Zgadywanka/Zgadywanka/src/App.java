import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 101);  

        int chances = 5;
        int currentChance =0;
        int inputRandomNumber;

        System.out.println(randomNumber); 
       
        while(currentChance<chances)
        {
            inputRandomNumber = scanner.nextInt();

            if(inputRandomNumber==randomNumber)
            {
                System.out.println("Brawo zgadłeś liczbę, a jej wartośc to "+ randomNumber); 
                break;
            }
            else
            {
                System.out.println("Niestety to nie ta liczba, ta liczba jest "); 

                if(inputRandomNumber>randomNumber)
                {
                    System.out.println(" mniejsza"); 
                }
                else
                {
                    System.out.println(" większa"); 
                }

                System.out.println("Pozostało prób "+ (chances-currentChance-1));
            }
            currentChance++;
            
        }

        if(currentChance==chances)
        {
            System.out.println("Niestety nie zgadłeś");
        }
        
        scanner.close();
    }
}
