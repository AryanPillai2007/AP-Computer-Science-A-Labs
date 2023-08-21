import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
class Tombstone {
    String name;
    String burialDate;
    int age;
    String address;

    public Tombstone(String name, String burialDate, int age, String address) {
        super();
        this.name = name;
        this.burialDate = burialDate;
        this.age = age;
        this.address = address;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the burialDate
     */
    public String getBurialDate() {
        return burialDate;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
}
