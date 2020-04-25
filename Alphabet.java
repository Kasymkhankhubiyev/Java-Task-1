package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Alphabet {
    static String terminator = " ";
    static Properties EM = new Properties(); //здесь будем хранить данные в виде строки;
    static Properties ME = new Properties();
    static{
        FileInputStream alph_code = null; //создаем объект, который будет хранить путь к файлу
        FileInputStream alph_decode = null;

        try {
            alph_code = new FileInputStream("c:\\Eng_to_Mor"); //принимает путьж
            alph_decode = new FileInputStream("C:\\Mor_to_Eng");

            EM.load(alph_code); //теперь заполняем наш контейнер, с которым будем работать.
            ME.load(alph_decode);
        }
        catch(IOException excep) //всегда нужно проверять дейсвие открытие файла и загрузку его содержимого, т.к. действие "не безопасное"
        {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }

}
