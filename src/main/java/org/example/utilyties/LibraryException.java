package org.example.utilyties;

import java.io.PrintStream;

public class LibraryException extends Exception{

    private String message;
public  LibraryException(String mess){
this.message = mess;
}


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

}
