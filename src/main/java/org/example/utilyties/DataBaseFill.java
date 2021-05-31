package org.example.utilyties;

import org.example.userClasses.Readers;

import java.io.Serializable;

import static java.lang.Integer.parseInt;

public class DataBaseFill implements Serializable {
    public static int readers = 0;
    public static void createReader (Readers[] dataBase) {
        fillAndCreate(readers, dataBase, "Viktor", "Yanukovich", "Rostov, Podval under the Station",10);
        dataBase[readers - 1].setBooks("History 7-th class", "2013-12-13", 50);
        fillAndCreate(readers, dataBase, "Mishka", "Yaponchick", "Odessa Main Prison",10);
        dataBase[readers - 1].setBooks("The Count of Monte Cristo", "2016-08-16", 10);
        dataBase[readers - 1].setBooks("Boratino", "2019-08-16", 1000);
        dataBase[readers - 1].setBooks("Star Wars", "2000-08-16", 100);
        fillAndCreate(readers, dataBase, "Vladimir", "Zelen", "Bankova street",10);
        dataBase[readers - 1].setBooks("The world Economy", "2019-02-11", 5000);

        fillAndCreate(readers, dataBase, "Mark", "Zuckerberg", "London, Yelizaveta street",10);
        dataBase[readers - 1].setBooks("The world Economy", "2019-07-16", 50);
    }

    public static void fillAndCreate (int numOfReader, Readers[] arrR, String name, String surname,
                                      String address, int amountOfBook) {
        arrR[numOfReader] = new Readers(surname,name,address,amountOfBook);
        readers++;
    }

    public static int getReaders(){
        return readers;
    }
}