package org.example;

import org.example.userClasses.Readers;

public class AdminView {
    public static final String INPUT_LOCDATE_DATA_ = "Enter the date , when did he/she took the book\n " +
            "in format yyyy-mm-dd";
    public static final String WHO_TOOK_THAT_DATE = "1";
    public static final String WHO_OWED = "2";
    public static final String FULL_DB = "3";
    public static final String ADD_READER = "4";
    public static final String ADD_BOOK = "5";
    public static final String EXIT = "exit";
    public static final String ERROR_DATA = "Wrong format of input!";
    public static final String ERROR_DATA_FUTURE = "You cannot see future";
    public static final String ERROR_DATE = "Wrong format of date input !";
    public static final String RESULT_DATA_DEBT = "They should return us books:";
    public static final String RESULT_DATA_DATE = "There are humans , who took book in that day:";
    public static final String RESULT_NULL = "There are no such readers";
    public static final String MENU = "Enter the number to manage the system \n1.Find , who took book in that date " +
            "\n2.The list of the people, who owed book \n3.Full DataBase " +
            "\n4.Add reader\n5.Add Book" +
            "\nwrite 'exit' to stop program " ;
    public static final String ASK_FOR_SAVE = "Save result?(y/n)";
    public static final String ENTER_NAME = "Enter name";
    public static final String ENTER_SURNAME = "Enter surname";
    public static final String ENTER_ADDRESS = "Enter address";
    public static final String ENTER_TITLE = "Enter Title of book";
    public static final String ENTER_DAYS = "Enter how many days reader can use it";
    public static final String ENTER_NUM_OF_READER = "Enter num of reader, who took the book";
    public static final Integer COUNT_BOOKS = 10;

    //    public static final String CANCEL = "cancel operation";


    public static String last_result ="";

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printMessageFull(String message, Readers[] res, int numOfRes){
        if (numOfRes > 0) {
            System.out.println(message);
            System.out.println(createResultStr(res,numOfRes));
        }
        else {
            System.out.println(RESULT_NULL);
        }
    }

    public static void printMessageFull(Readers[] dataBase, int readers){
        System.out.println(createResultStr(dataBase,readers));
    }

    public static String createResultStr(Readers[] res, int numOfRes){
        String result = "";
        for (int i = 0; i < numOfRes; i++) {
             result = result + "num: " + i + " " + res[i].toString() + '\n'+ '\n';
        }
        last_result = result;
        return result;
    }

    public static String getLast_result() {
        return last_result;
    }
}
