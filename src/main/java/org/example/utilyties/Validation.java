package org.example.utilyties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AdminView;
import org.example.Controller;
import org.example.LookForModel;
import org.example.userClasses.Readers;

import java.io.IOException;
import java.io.Reader;
import org.joda.time.LocalDate;
import static org.example.utilyties.InputUtil.*;

public class Validation {
    private static final Logger logger = LogManager.getLogger(Validation.class);
    public  AdminView view = new AdminView();

    public String validatedInputMenu() {
        String info = "0";
        try {
            info = inputMenu();
        } catch (LibraryException e) {
            AdminView.printMessage(AdminView.ERROR_DATA);
            //e.printStackTrace();
        }
        return info;
    }

    public LocalDate validatedInputDate() {
        LocalDate res = LocalDate.parse("2000-01-01");
        try {
            res = inputDate();
            if(res.compareTo(LocalDate.now()) > 0)
                throw new LibraryException(AdminView.ERROR_DATA_FUTURE);
        }
        catch (LibraryException e) {
            logger.warn(AdminView.ERROR_DATA_FUTURE);
            e.printStackTrace();
            res = validatedInputDate();
        }
        catch (Exception e) {
            logger.warn(AdminView.ERROR_DATE);
            AdminView.printMessage(AdminView.ERROR_DATE);
            res = validatedInputDate();
        }
        return res;
    }

    public boolean validatedAskSave() {
        boolean res;
        try {
            res = InputUtil.ifSave();
        } catch (LibraryException e) {
            logger.warn("unexpected input");
            e.printStackTrace();
            res = validatedAskSave();
        }
        catch (Exception e){
            e.printStackTrace();
            res = validatedAskSave();
        }
        return res;
    }

    public void saveStr(String res){

        try {
            Streams.saveResult(res);
            logger.info("saving result",res);
        }
        catch (IOException e){
            logger.error("cannt save DB");
            e.printStackTrace();
        }
    }

    public String inputReaderStr(String info){
        String reader = "";
        AdminView.printMessage(info);
        try {
            reader = InputUtil.input();
        }
        catch (Exception e){
            e.printStackTrace();
            logger.warn("creation new String problem");
            inputReaderStr(info);
        }

        return reader;
    }

    public Integer inputReaderInt(String info){
        Integer reader = null;
        AdminView.printMessage(info);
        try {
            reader = Integer.parseInt(InputUtil.input());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.warn("creation new Int problem");
            inputReaderInt(info);

        }
        return reader;
    }

    public void inputFullReader(Integer numOfReaders, Readers[] database){
        String name = inputReaderStr(AdminView.ENTER_NAME);
        String surname = inputReaderStr(AdminView.ENTER_SURNAME);
        String address = inputReaderStr(AdminView.ENTER_ADDRESS);

        DataBaseFill.fillAndCreate(numOfReaders, database, name,surname,address,AdminView.COUNT_BOOKS);
        logger.info("saved reader:",name,' ', surname, ' ',address);
    }

    public void inputFullBook(Readers[] database){
        Integer numOfReader = inputReaderInt(AdminView.ENTER_NUM_OF_READER);
        String bookTitle = inputReaderStr(AdminView.ENTER_TITLE);
        String dateTook = inputDate().toString();
        Integer daysOfUse = inputReaderInt(AdminView.ENTER_DAYS);
        try{
            database[numOfReader].setBooks(bookTitle, dateTook,daysOfUse);
            logger.info("saved book:",bookTitle,' ', dateTook, ' ',daysOfUse);

        }
        catch (Exception e){
            logger.error("creation new Book crashed");
            e.printStackTrace();
        }
    }

    public LookForModel importDB(LookForModel mod ){
        try {
            logger.info("open DB");
            mod.openDB();
        }
        catch (Exception e)
        {
            AdminView.printMessage("Unable to open DB");
            logger.error("DB wasn't opened ,",e);
            mod.InitializeDB();
            logger.info("fill from example");
        };
        return mod;
    }
}