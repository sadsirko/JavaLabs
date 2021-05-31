package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utilyties.Validation;

import java.io.IOException;
import org.joda.time.LocalDate;
import static java.lang.String.valueOf;

public class Controller {
    private static Integer readers;
    private static final Logger logger = LogManager.getLogger(Controller.class);
    Controller(){
        readers = 10;
    }
    public static void creation() {
        logger.info("\n\nSTART");
        LookForModel model = new LookForModel(readers);
        Validation val = new Validation();
        String menu = null;
        val.importDB(model);
        menu = val.validatedInputMenu();
        while (! menu.equals(AdminView.EXIT)){
            switch (menu) {
                case AdminView.WHO_TOOK_THAT_DATE -> {
                    logger.info("User try to find , who took book in that date");
                    LocalDate dateTook = val.validatedInputDate();
                    AdminView.printMessageFull(AdminView.RESULT_DATA_DATE, model.findWhoTook(dateTook),
                            model.getNumOfRes());
                    if (val.validatedAskSave()) val.saveStr(AdminView.getLast_result());
                }
                case AdminView.WHO_OWED -> {
                    logger.info("User try to find , who owed book");

                    AdminView.printMessageFull(AdminView.RESULT_DATA_DEBT, model.findWhoDebt(),
                            model.getNumOfResDebt());
                    if (val.validatedAskSave()) val.saveStr(AdminView.getLast_result());

                }
                case AdminView.FULL_DB ->
                    AdminView.printMessageFull(model.getDataBase(), model.getNumOfReaders());
                case AdminView.ADD_READER ->
                    val.inputFullReader(model.getNumOfReaders(), model.getDataBase());
                case  AdminView.ADD_BOOK ->
                        val.inputFullBook(model.getDataBase());
            }
            menu = val.validatedInputMenu();
        }
        logger.info("exit from program");
        model.saveDB();
        logger.info("save the DB");
    }
}
