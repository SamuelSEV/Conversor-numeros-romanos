package conversornumeros;

import java.util.Scanner;

public class NumerosRomanos {

	private Scanner sc;
	
	static public int N;
	static public String R;
	public NumerosRomanos() {
		sc = new Scanner(System.in);
		System.out.println("Seleccione una conversion");
	    System.out.println("1. Decimal a Romano");
	    System.out.println("2. Romano  a  Decimal");
	    int n=sc.nextInt();
	    if(n==1){
	    	System.out.print("Introduce un número entre 1 y 3999: ");
			N = sc.nextInt();
			while (N < 1 || N > 3999); {
			    System.out.println(N + " en numeros romanos -> " + dec2roman(N));
			}
	    }else{
	    	sc = new Scanner(System.in);
	    	System.out.print("Introduce un número ROMANO: ");
			R = sc.nextLine();
			System.out.println(R + " en numeros decimales -> " + roman2dec(R));
	    	
	    }
	}
	

	//método para pasar a números romanos
	public String dec2roman(int numero) {
	    int i, miles, centenas, decenas, unidades;
	    String romano = "";
	   //obtenemos cada cifra del número
	    miles = numero / 1000;
	    centenas = numero / 100 % 10;
	    decenas = numero / 10 % 10;
	    unidades = numero % 10;
	
	   //millar
	    for (i = 1; i <= miles; i++) {
	       romano = romano + "M";
	    }
	
	   //centenas
	    if (centenas == 9) {
	       romano = romano + "CM";
	    } else if (centenas >= 5) {
	        romano = romano + "D";
	        for (i = 6; i <= centenas; i++) {
	        	romano = romano + "C";
	        }
	    } else if (centenas == 4) {
	        romano = romano + "CD";
	    } else {
	        for (i = 1; i <= centenas; i++) {
	            romano = romano + "C";
	        }
	    }
	
	   //decenas
	    if (decenas == 9) {
	        romano = romano + "XC";
	    } else if (decenas >= 5) {
	        romano = romano + "L";
	        for (i = 6; i <= decenas; i++) {
	            romano = romano + "X";
	        }
	    } else if (decenas == 4) {
	        romano = romano + "XL";
	    } else {
	        for (i = 1; i <= decenas; i++) {
	            romano = romano + "X";
	        }
	    }
	
	   //unidades
	    if (unidades == 9) {
	       romano = romano + "IX";
	    } else if (unidades >= 5) {
	       romano = romano + "V";
	       for (i = 6; i <= unidades; i++) {
	           romano = romano + "I";
	       }
	    } else if (unidades == 4) {
	       romano = romano + "IV";
	    } else {
	       for (i = 1; i <= unidades; i++) {
	           romano = romano + "I";
	       }
	    }
	    return romano;
	}
	
	private static int GetNumber(char roman)
    {
        return roman == 'M' ? 1000 :
               roman == 'D' ? 500 :
               roman == 'C' ? 100 :
               roman == 'L' ? 50 :
               roman == 'X' ? 10 :
               roman == 'V' ? 5 :
               roman == 'I' ? 1 : 0;
    } 
	
	public int roman2dec(String nRoman)
    {
        int total = 0, numero = 0;
        
        for (int i = 0; i < nRoman.length(); i++) {
            int numActual = GetNumber(nRoman.charAt(i));
            
            if (numero == 0){
                numero = numActual; continue;
            }
            if (numero < numActual)
                numero = -numero;
            total += numero;
            numero = numActual;
        }
        return total + numero;
    }
}