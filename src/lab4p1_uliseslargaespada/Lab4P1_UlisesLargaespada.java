/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p1_uliseslargaespada;

import java.util.Scanner;

import java.util.Random;


/**
 *
 * @author ularg
 */
public class Lab4P1_UlisesLargaespada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-- Bienvenido a la app que resuelve diversos ejercicios --");
        
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
        
        // Initialize Menu
        do {
            System.out.println("-- Elija una opcion del siguiente menu: --");
            System.out.println("1 - Fallout Words");
            System.out.println("2 - Rodatcripne");
            System.out.println("3 - Alpha");
            System.out.println("4 - Salir ");      
            
            // Solicitud de entrada
            int option = entry.nextInt();
            
            switch (option) {
                case 1 -> falloutWords();
                    
                case 2 -> rodatcripne();
                    
                case 3 -> is_alpha();
                
                default -> System.out.println("Por favor, elija una opcion del menu");
            }
            
            // Salir del programa 
            if (option == 4) {
                break;
            }
        } while(true);
    }
    
    // Metodo para el ejercicio fallout words
    public static void falloutWords() {
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
    
        System.out.println("-- Bienvenido al juego de Fallout Words --");
                    
        // Generar numero random para seleccionar la palabra
        int random = new Random().nextInt((9 - 1) + 1) + 1;

        String palabra = palabraRandom(random);

        System.out.println("-- Esta es la lista de palabras de las cuales tiene que adivinar una --");
        // Mostrar todas las palabras
        for(int i = 0; i < 10; i++) {
            String currentWord = palabraRandom(i);
            System.out.println(currentWord);
        }

        // Llamar funcion para realizar el juego de adivinacion con 5 intentos
        int i = 5;
        while(i > 0) {
            System.out.println("-- Usted tiene " + i + " vidas --");
            System.out.print("Porfavor ingrese una palabra para ver si es la correcta: ");
            String palabraIngresada = entry.nextLine();
            
            // Validar la palabra
            boolean wordValidate = wordEntryChecker(palabraIngresada);
            if(wordValidate == false) {
                System.out.println("La palabra ingresada no esta en la lista anterior");
                System.out.println("...Regresando al menu principal");
                System.out.println();
                break;
            }
            
            boolean wordChecker = wordCheckerGame(palabraIngresada, palabra);
            
            // Terminar si adivino 
            if(wordChecker) {
                break;
            }
            i--;
        }
                    
            
    }
    
    // Metodo para el ejercicio rodatcripne
    public static void rodatcripne() {
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
    
        System.out.println("-- Bienvenido al juego de Rodatcripne --");
        System.out.println("-- En este programa vamos a encriptar su contraseña --");
        System.out.print("Ingrese la contraseña: ");
        
        // Password del usuario 
        String password = entry.nextLine();
        
        // Password reverse
        String passwordReverse = "";
        
        // Validar que la palabra este en minusculas
        boolean checkerPassword = wordLowerChecker(password);
        
        if (checkerPassword) {
            System.out.println("Ingrese una contraseña con letras minusculas solamente");
        }
        else {
            // Revertir password
            for(int i = password.length() - 1; i >= 0; i--) {
                passwordReverse += password.charAt(i);
                
                if( i % 2 == 0){
                    // random number transformed to string
                    int random = new Random().nextInt((9) + 1);
                    String randomS = Integer.toString(random);
                    
                    // transform char to string
                    String letra = Character.toString(password.charAt(i));
                    passwordReverse = passwordReverse.replace(letra, randomS);
                }
            }
            
            System.out.println("El resultado encriptado es: " + passwordReverse);
            System.out.println();
        }
        
    }
    
    // Metodo para el ejercicio alpha
    public static void is_alpha() {
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
    
        System.out.println("-- Bienvenido al juego de Alpha --");
        System.out.println("-- En este programa vamos a determinar si su cadena consiste solo de letras y no de otro tipo de caracteres --");
        System.out.print("Ingrese la cadena: ");
        
        // Guardar cadena
        String cadena = entry.nextLine();
        
        // Checkers en booleans
        boolean soloLetras = true;
        
        for(int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            
            if(Character.isLetter(letra) == false) {
                soloLetras = false;
            }
        }
        
        if(soloLetras) {
            System.out.println("La cadena contiene solamente letras");
        } else {
            System.out.println("La cadena contiene caracteres que no son letras");
        }
        
        System.out.println();
    }
    
    // Metodo para generar las palabras random e imprimir las palabras
    public static String palabraRandom(int n) {
        String[] palabras = {"Comer", "Jugar", "Salta", "Llora", "Muere", "Unida", "Venti", "Llama", "Eevee", "Local"};
        
        return palabras[n];
    }
    
    // Metodo para confirmar si la palabra es correcta
    public static boolean wordCheckerGame(String palabraIngresada, String palabraCorrecta) {
        // Validador
        boolean check = false;
        
        // Contadores
        int posicionesCorrectas = 0;
        int letrasCorrectas = 0;
        
        if (palabraCorrecta.equalsIgnoreCase(palabraIngresada)) {
                System.out.println("Accesso Concedido");
                System.out.println();
                check = true;
        } else {
            // Comprobar si hay letras en posiciones correctas
            for(int j = 0; j < palabraCorrecta.length(); j++) {
                char letraCorrecta = palabraCorrecta.charAt(j);
                char letraIngresada = palabraIngresada.charAt(j);
                
                // Transformar char a String
                String letra = Character.toString(letraIngresada);
                
                if (letraCorrecta == letraIngresada) {
                    posicionesCorrectas++;
                } 
                if (palabraCorrecta.contains(letra)) {
                    letrasCorrectas++;
                }   
            }
                    
            System.out.println("Letras Correctas: " + letrasCorrectas);
            System.out.println("Posiciones Correctas: " + posicionesCorrectas);
            
            // Reiniciar contadores
            posicionesCorrectas = 0;
            letrasCorrectas = 0; 
        }
        
        return check;
    }
    
    // Metodo para validar si la palabra ingresada se encuentra en la lista
    public static boolean wordEntryChecker(String palabraIngresada) {
        boolean check = false;
        
        for (int i = 0; i < 10; i++) {
            String palabraCorrecta = palabraRandom(i);
            if (palabraIngresada.equalsIgnoreCase(palabraCorrecta)){
                check = true;
            }
        }
        
        return check;
    }
    
    // Metodo para validar si la palabra ingresada esta en minusculas
    public static boolean wordLowerChecker(String password){
        boolean check = false;
        
        for(int i = 0; i < password.length(); i++) {
            char passwordLetter = password.charAt(i);
            
            if(Character.isUpperCase(passwordLetter)) {
                check = true;
            }
        }
        
        return check;
    }
}
