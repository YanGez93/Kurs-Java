import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner =new Scanner(System.in);
        String odpowiedz ="";

        String pytanie1[] = {"stado","klucz","dwa","owca","lama"};
        String pytanie2[] = {"sztafeta","skok o tyczce","skoki narciarskie","sumo","szachy"};

        int sumaPunktow =0;
        int liczbaPytan =2;

        for(int y=0; y<liczbaPytan;y++)
        {
            sumaPunktow =0;
            String obecnyZestawPytan[] ={};
            switch (y)
            {
                case 0:
                    obecnyZestawPytan = pytanie1;  
                    System.out.println("Więcej niż jedno zwierze to :");
                    odpowiedz = scanner.nextLine();
                    break;
                case 1:
                    obecnyZestawPytan = pytanie2;
                    System.out.println("Sporty na literę S: ");
                    odpowiedz = scanner.nextLine();
                    break;
            }
            for(int i=0;i<obecnyZestawPytan.length;i++)
            {
                
                if(odpowiedz.equals(obecnyZestawPytan[i]))
                {
                    System.out.println("Brzdęk");
                    sumaPunktow+=10*(i+1);
                    System.out.println(sumaPunktow);
                }
            }
            if(sumaPunktow==0)
            {
                System.out.println("X");
            }
        }
        scanner.close();
    }
}

/*
        Ćwiczenie 1 

        System.out.println("Wpisz swoje imię i nazwisko");
        Scanner scanner =new Scanner(System.in);
        String firstName =scanner.nextLine();

        System.out.println("Twoje imie i nazwisko to "+firstName);

        scanner.close();

*/

/*
        Ćwiczenie 2

        Scanner scanner =new Scanner(System.in);
        System.out.println("Wpisz 1 liczbę"); 

        int pierwszaLiczba = scanner.nextInt();

        System.out.println("Wpisz 2 liczbę");

        int drugaLiczba = scanner.nextInt();

        System.out.println("Wpisz 3 liczbę");
        int trzeciaLiczba = scanner.nextInt();

        int suma = pierwszaLiczba+drugaLiczba+trzeciaLiczba;
        System.out.println("Suma to "+suma);

        scanner.close();

*/

/*

        if(operator.equals("+"))
        {
            suma = pierwszaLiczba+drugaLiczba;
        }
        else if(operator.equals("-"))
        {
            suma = pierwszaLiczba-drugaLiczba;
        }
        else
        {
            System.out.println("Podałeś zły operator");    
        }

*/

/*
        Scanner scanner =new Scanner(System.in);
        System.out.println("Wpisz 1 liczbę");
       
        int pierwszaLiczba = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Podaj operator");

        String operator = scanner.nextLine();

        System.out.println("Wpisz 2 liczbę");

        int drugaLiczba = scanner.nextInt();

        int suma=0;

        switch(operator)
        {
            case "+":
                suma = pierwszaLiczba+drugaLiczba;
                break;
            case "-":
                suma = pierwszaLiczba-drugaLiczba;
                break;
            case "*":
                suma = pierwszaLiczba*drugaLiczba;
                break;
            case "/":
                suma = pierwszaLiczba/drugaLiczba;
                break;
            default:
                System.out.println("Podałeś zły operator");    
        }


        System.out.println("Suma to "+suma);


*/
