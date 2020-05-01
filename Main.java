package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Translator translator = null;
        Scanner read = new Scanner(System.in);
        File Source=null;
        File Out=null;
        System.out.println("Choose translate option:\n"+"English into Morse     1\n"+"Morse into English        2");

        if(read.nextInt()==1){
            translator = new Eng_Translator();
            Source = new File("C:\\Users\\Tom\\Desktop\\Programming\\java\\Eng_to_Mor.txt");
            Out = new File ("C:\\Users\\Tom\\Desktop\\Programming\\java\\outputer.txt");
        }else{
            translator = new Morse_Translator();
            Source = new File("C:\\Users\\Tom\\Desktop\\Programming\\java\\Mor_to_Eng.txt");
            Out = new File("C:\\Users\\Tom\\Desktop\\Programming\\java\\outputer.txt");
        }
        StringBuilder ReaderString = translator.build(Source);
        FileOutputStream WriteToFile = new FileOutputStream(Out);
        try {
            WriteToFile.write(ReaderString.toString().getBytes());
            System.out.println("Text is successfully translated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
