import java.util.*;
import java.io.*;
import java.util.List;

public class Librarian {

    // Fields:
    private Map<String, File> library;
    private File fileName;
    private Scanner fileScan;


    // Constructor Method:
    public Librarian(Map<String, File> Library) throws FileNotFoundException {
        this.library = Library;
        this.fileScan = new Scanner(fileName);
    }

    //
    public void fetch(String description) {
        if( !this.library.containsKey(description) ) {
            throw new IllegalArgumentException(description + " is not in the Library, dummy!");
        } else {
            this.fileName = this.library.get(description);


            
        }

    }

}


// 1.) Create new Librarian object
    // 1a.) The parameter for this object is a Map of String -> File; each String is a description
        // of what is in the file.
    // 1b.) This map object should only be created once at the beginning of the program

// 2.) A method called 'fetch' that retrieves all the desired info
    // 2a.) This method should take in a String parameter that is a description of the desired text
        // i.e. 'chaplainClass' or 'provinceDescription'
    // 2b.) This method will sort through the Map and load the necessary text from the File,
        // (perhaps calling on internal methods like 'saveTextPlace' or 'checkpoint' in order
        // to not lose the place that was scanned last).