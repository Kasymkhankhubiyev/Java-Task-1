package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//StringBuffer & StringBuilder - двойники, только первый для многопоточных проектов, а второй для однопоточных.

abstract class Translator { //строим слова при помощи StringBuilder
    abstract StringBuilder build(File Inputfile); //abstract т.к. у нас ООП, а значит переводы будут через одну
}              // и ту же функцию, но с перееобозначенными реализациями. 
