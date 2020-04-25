package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;


//StringBuffer & StringBuilder - двойники, только первый для многопоточных проектов, а второй для однопоточных.

abstract class Translator { //строим слова при помощи StringBuilder
    abstract StringBuilder build(File Inputfile); //abstract т.к. у нас ООП, а значит переводы будут через одну
}              // и ту же функцию, но с перееобозначенными реализациями.

class Eng_Translator extends Translator {
    @Override
    StringBuilder build(File InputFileName) {//StringBuilder может изменять строки
//воспользуемся FileInputStream or Reader т.е. не Scanner scan, но Reader read = null;
//        Reader reader = null;
//        try {
//            reader = new InputStreamReader(InputFileName);
//        }
        Scanner reader = null;
        try{
            reader = new Scanner(InputFileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder EnglishText = new StringBuilder(""); //создаем контейнер
        if(reader!=null){ //если файл открыт и он не пустой начинаем чтение
            while(reader.hasNext()) //пока не конец файла, или дословно пока существует следующая строка, считываем строки
                EnglishText.append(reader.nextLine()).append("\n"); //поочередно складываем в контейнер.
        }
//        System.out.println(EnglishText); // вывод текста на экран
        int i =0;
        StringBuilder stringOutput = new StringBuilder("");//создаем промежуточный контейнер для перевода.
        while(i<EnglishText.length()){  //теперь разворачиваем сам процесс перевода, для этого:
            if(EnglishText.substring(i,i+1).equals(Alphabet.terminator)) //начинаем вытаскивать строки из контейнера, используем .substring
                stringOutput.append(Alphabet.terminator).append("\n"); //если просто пусто, тогда так.
            else if(EnglishText.substring(i,i+1).equals("\n"))
                stringOutput.append("\n");
            else {
                stringOutput.append(Alphabet.EM.getProperty(EnglishText.substring(i, i + 1)));
                String Str = Alphabet.EM.getProperty(EnglishText.substring(i,i+1)); //for the statistics&&
            }
            i++;
        }
        System.out.println("Translated into Morse: \n" + stringOutput);
        return stringOutput;
    }
}

class Morse_Translator extends Translator {
    @Override
    StringBuilder build(File InputFileName) {//StringBuilder может изменять строки
//воспользуемся FileInputStream or Reader т.е. не Scanner scan, но Reader read = null;
//        Reader reader = null;
//        try {
//            reader = new InputStreamReader(InputFileName);
//        }
        Scanner reader = null;
        try{
            reader = new Scanner(InputFileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder MorseText = new StringBuilder(""); //создаем контейнер
        if(reader!=null){ //если файл открыт и он не пустой начинаем чтение
            while(reader.hasNext()) //пока не конец файла, или дословно пока существует следующая строка, считываем строки
                MorseText.append(reader.nextLine()).append("\n"); //поочередно складываем в контейнер.
        }
//        System.out.println(EnglishText); // вывод текста на экран
        int i =0;
        StringBuilder stringOutput = new StringBuilder("");//создаем промежуточный контейнер для перевода.
        while(i<MorseText.length()){  //теперь разворачиваем сам процесс перевода, для этого:
            if(MorseText.substring(i,i+1).equals(Alphabet.terminator)) //начинаем вытаскивать строки из контейнера, используем .substring
                stringOutput.append(Alphabet.terminator).append("\n"); //если просто пусто, тогда так.
            else if(MorseText.substring(i,i+1).equals("\n"))
                stringOutput.append("\n");
            else {
                stringOutput.append(Alphabet.ME.getProperty(MorseText.substring(i, i + 1)));
                String Str = Alphabet.ME.getProperty(MorseText.substring(i,i+1)); //for the statistics&&
            }
            i++;
        }
        System.out.println("Translated into Morse: \n" + stringOutput);
        return stringOutput;
    }
}
