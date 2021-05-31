package org.example;

import org.example.userClasses.Readers;
import org.example.utilyties.DataBaseFill;
import org.example.utilyties.Streams;

import java.io.*;
import org.joda.time.LocalDate;
public class LookForModel {
    private Readers[] dataBase;

    private int numOfRes;
    private int numOfResDebt;
    private int MAX_READERS;

    private int numOfReaders;

    LookForModel(int readers){
        this.numOfRes = 0;
        this.MAX_READERS = readers;
        this.numOfReaders = 0;
        this.numOfResDebt = 0;
    }

    public void InitializeDB(){
            dataBase = new Readers[MAX_READERS];//db length clean code
            DataBaseFill.createReader(dataBase);
    }

    public void saveDB(){
        Streams.serializeDB(dataBase);
    }

    public void openDB() throws Exception{
        dataBase = new Readers[MAX_READERS];
        dataBase = Streams.deserializeDB(dataBase);
    }

    public Readers[] findWhoTook(LocalDate date){
        Readers[] resultTook;
        resultTook = new Readers[MAX_READERS];

        numOfRes = 0;
        for(int i = 0;i < getNumOfReaders(); i++){
            if (dataBase[i].getNumOfBooks() > 0){
                for (int j = 0; j < dataBase[i].getNumOfBooks();j++){
                    if (dataBase[i].getBook()[j].getDateWhenTook().equals(date)) {
                        resultTook[numOfRes] = dataBase[i];
                        numOfRes++;
                        j = dataBase[i].getNumOfBooks();
                    }
                }
            }
        }
        return resultTook;
    }

    public  Readers[] findWhoDebt(){
        Readers[] resultDebt;
        resultDebt = new Readers[MAX_READERS];
        numOfResDebt = 0;
        for(int i = 0;i < getNumOfReaders(); i++){
            if (dataBase[i].getNumOfBooks() > 0){
                        for (int j = 0; j < dataBase[i].getNumOfBooks();j++){
                            if (dataBase[i].getBook()[j].getDateWhenTook().plusDays( dataBase[i].getBook()[j].getDays())
                                    .isBefore( LocalDate.now())) {
                                resultDebt[numOfResDebt] = dataBase[i];
                                numOfResDebt++;
                                j = dataBase[i].getNumOfBooks();
                            }
                }
            }
        }

        return resultDebt;
    }

    public void countNumOfReaders() {
        int cnt = 0;
        for (Readers name : dataBase) {
            if (name != null)
                cnt++;
        }
        numOfReaders = cnt;
    }

    public int getNumOfRes () {
        return numOfRes;
    }
    public int getNumOfResDebt () {
        return numOfResDebt;
    }
    public int getNumOfReaders(){countNumOfReaders();return numOfReaders;}
    public Readers[] getDataBase(){
        return dataBase;
    }
}
