package org.example.utilyties;

import org.example.AdminView;

import org.joda.time.LocalDate;
import java.util.Scanner;

public class InputUtil {

    private static Scanner sc = new Scanner(System.in);

    public static LocalDate inputDate(){
        LocalDate res = LocalDate.parse("2000-01-01");
        AdminView.printMessage(AdminView.INPUT_LOCDATE_DATA_);
            res = LocalDate.parse(sc.nextLine());
        return res;
    }

    public static String inputMenu() throws LibraryException{

            AdminView.printMessage(AdminView.MENU);
            String str = sc.nextLine();
            boolean expected_res = str.equals(AdminView.WHO_TOOK_THAT_DATE)
                    || str.equals(AdminView.WHO_OWED) || str.equals(AdminView.EXIT)
                    || str.equals(AdminView.FULL_DB) || str.equals(AdminView.ADD_READER)
                    || str.equals(AdminView.ADD_BOOK);
            if ( !expected_res ){
                throw new LibraryException(AdminView.ERROR_DATA);
            }
            return str;
    }

    public  static Boolean ifSave() throws LibraryException{
        AdminView.printMessage(AdminView.ASK_FOR_SAVE);
        String str = sc.nextLine();
        boolean yes = str.toLowerCase().equals("y");
        boolean no = str.toLowerCase().equals("n");
        boolean expected_res = no || yes;
        if (!expected_res){
            throw new LibraryException(AdminView.ERROR_DATA);
        }
        else {
            if (yes)
                return true;
            else
                return false;
        }
    }

    public static String input(){
        String res = sc.nextLine();
        return res;
    }
}
