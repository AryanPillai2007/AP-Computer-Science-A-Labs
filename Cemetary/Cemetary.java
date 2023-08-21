import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Cemetery {
    ArrayList<Tombstone> list = new ArrayList<>();
    String fileName;
    public Cemetery(String fileName) {
        this.fileName = fileName;
    }
    void readData() {
        File file = new File(fileName);
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                Scanner scan = new Scanner(line);
                scan.useDelimiter(" ");
                scan.tokens();

                String name = "";
                String burialDate;
                int age;
                String address = "";
                String temp = "";
                boolean done = true;

                while(done){
                    temp = scan.next();
                    try {
                        int num = Integer.parseInt(temp);
                        done = false;
                        break;
                    }catch(NumberFormatException n) {
                        done = true;
                    }
                    name += temp+" ";
                }

                burialDate = temp +" "+ scan.next()+ " "+scan.next();

                String stringAge = scan.next();
                age = parseAge(stringAge);

                while(scan.hasNext()){
                    address+= scan.next()+" ";
                }
                Tombstone Tombstone = new Tombstone(name, burialDate, age, address);
                list.add(Tombstone);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int parseAge(String ageString) {

        if(ageString.contains("d")) {
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }

        int result = 0;
        boolean done = true;

        try {
            result = Integer.parseInt(ageString);
        }catch(NumberFormatException n) {
            done = false;
        }

        if(done) {
            return 365*result;
        }

        double ageDouble = 0;
        done = true;

        try {
            ageDouble = Double.parseDouble(ageString);
        }catch(NumberFormatException n) {
            done = false;
        }

        if(done) {
            return (int)(365*ageDouble);
        }

        if(ageString.contains("w")) {
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString)*7;
        }

        return 0;
    }

    void averageAge() {
        int n = list.size();
        int ageSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Tombstone tombstone = list.get(i);
            String address = tombstone.getAddress();
            if(address.indexOf("Little Carter Lane") != -1) {
                ageSum += tombstone.getAge();
                count += 1;
            }
        }
        if(count ==0) {
            System.out.println("No data Found!!!");
            return;
        }
        double avg = (double) ageSum/count;
        double ans = (double) avg/365;

        System.out.println("Average of people lived in Little Carter Lane is "+ Math.round(ans));
    }

}