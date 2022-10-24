import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import org.apache.commons.validator.routines.*; //jar files in https://commons.apache.org/proper/commons-validator/download_validator.cgi



//Make sure to give the user the ability to input again the form if there are missing details, wrong format etc. and it does not execute an error right away.

public class Main {
    public static void main(String[] args) throws IOException {


        while(true){
            FileWriter c = new FileWriter("src/data.txt");
            Scanner inp = new Scanner(System.in);
            System.out.print("Graduate(G) or Undergraduate(U): ");
            String ug = inp.nextLine();
          

            String statype;
            if (ug.equalsIgnoreCase("G")) {
                System.out.println("Part time(P) or Full time(F): ");
                statype = inp.nextLine();
                
            } else {
                System.out.println("Regular(R) or Irregular(I): ");
                statype = inp.nextLine();
               
            }
            System.out.print("Enter your Student ID: ");
            String id = inp.nextLine();
           
            System.out.print("Enter your first name: ");
            String first = inp.nextLine();
          
            System.out.print("Enter your middle initial: ");
            String mid = inp.nextLine();
           
            System.out.print("Enter your last name: ");
            String last = inp.nextLine();
         
            System.out.print("Enter your birthdate: ");
            String birth = inp.nextLine();
         
            System.out.print("Enter your gender: ");
            String gend = inp.nextLine();
          
            System.out.print("Enter your address: ");
            String addr = inp.nextLine(); //how to validate address fhsjdkhf

            System.out.print("Enter your course: ");
            String course = inp.nextLine();
          
            String year = null;
            if(ug.equalsIgnoreCase("u")){
                System.out.print("Enter your year level: ");
                year = inp.nextLine();
              
            }

            System.out.print("Enter your contact number: ");
            String num = inp.nextLine();
            System.out.print("Enter your email: ");
            String email = inp.nextLine();
            

            // OBJECT STORAGE
            Student s = null;
            switch (ug.toLowerCase()) {
                case "u":
                    s = new Undergraduate();
                    break;
                case "g":
                    s = new Graduate();
                    break;
            }
            s.setFirstname(first);
            s.setMidI(mid);
            s.setLast(last);
            s.setID(id);
            s.setBirthdate(birth);
            s.setGender(gend);
            s.setAddress(addr);
            s.setCourse(course);
            s.setYear(year);
            s.setNumber(num);
            s.setEmail(email);
            s.setStatus(statype);

            //empty file
            PrintWriter pw = new PrintWriter("src/data.txt");
            pw.close();

            //write file
            c.write("\nType: "+s.showType());
            c.write("\nStatus: "+s.showStatus());
            c.write("\nStudent ID: "+s.getID());
            c.write("\nName: "+s.getName());
            c.write("\nBirthdate: "+s.getBirthdate());
            c.write("\nGender: "+s.getGender());
            c.write("\nAddress: "+s.getAddress());
            c.write("\nCourse: "+s.getCourse());

            if(ug.equalsIgnoreCase("u")){
                c.write("\nYear: "+s.getYear());
            }
            c.write("\nContact Number: "+s.getNumber());
            c.write("\nEmail: "+s.getEmail());
            c.flush();
            //PROGRAM OUTPUT
            boolean error = false;

            if (!checkEmail(email)) {
                error = true;
                System.out.println("Invalid email.");
            }

            if (!checkContact(num)) {
                error = true;
                System.out.println("Invalid Contact Number.");
            }

            if (ug.equalsIgnoreCase("u") && !checkYear(year)) {
                error = true;
                System.out.println("Invalid Year.");
            }

            if (!checkName(course)) {
                error = true;
                System.out.println("Invalid Course.");
            }

            if (!checkName(gend)) {
                error = true;
                System.out.println("Invalid Gender.");
            }

            if (!checkDate(birth)) {
                error = true;
                System.out.println("Invalid Birthdate.");
            }

            if (!checkName(last)) {
                error = true;
                System.out.println("Invalid Last Name.");
            }

            if (!checkName(mid)) {
                error = true;
                System.out.println("Invalid Middle Initial.");
            }

            if (!checkName(first)) {
                error = true;
                System.out.println("Invalid First Name.");
            }

            if (!checkId(id)) {
                error = true;
                System.out.println("Invalid Student ID.");

            }

            if (!checkType(statype, "u")) {
                error = true;
                System.out.println("Invalid input.");

            }

            if (!checkType(statype, "g")) {
                error = true;
                System.out.println("Invalid input.");

            }

            if (!checkUG(ug)) {
                error = true;
                System.out.println("Invalid input.");

            }

            if (error) {
                System.out.println("Here's the data you've entered.");
                Scanner read = new Scanner(new FileReader("src/data.txt"));

                while (read.hasNextLine()) {
                    String x = read.nextLine();
                    System.out.println(x);
                }

                System.out.print("Would you like to update your data? (y/n)");
                String upd = inp.nextLine();
                if (upd.equalsIgnoreCase("n")) {
                    break;
                }
            } else {
                System.out.print("Invalid input. Try again.");
            }

        }

}


    static String yearT(String year){
        switch(year){
            case "1":
                return "1st year";
            case "2":
                return "2nd year";
            case "3":
                return "3rd year";
            default:
                return year+"th year";
        }
    }

    static int age(String birth){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate bdate = LocalDate.parse(birth,form);
        LocalDate todei = LocalDate.now();
        Period age = Period.between(bdate, todei);
        return age.getYears();


    }
    static boolean checkContact(String num){
        char[] nm = num.toCharArray();
        if(num.length()==11){
            for(int y=0; y<num.length(); y++){
                if (!Character.isDigit(nm[y])){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

    static boolean checkId(String id){
        char[] nm = id.toCharArray();
        if(id.length()==6){
            for(int y=0; y<id.length(); y++){
                if (!Character.isDigit(nm[y])){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

    static boolean checkEmail(String mail){
        EmailValidator e = EmailValidator.getInstance();
        return e.isValid(mail);

    }

    static boolean checkUG(String ug){
        String lower = ug.toLowerCase();
        switch (lower){
            case "u":
            case "g":
                return true;
            default:
                return false;
        }

    }

    static boolean checkType(String typ, String ug){
        if(ug.equalsIgnoreCase("u")){
            if(typ.equalsIgnoreCase("i")||typ.equalsIgnoreCase("r")){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(typ.equalsIgnoreCase("p")||typ.equalsIgnoreCase("f")){
                return true;
            }
            else{
                return false;
            }
        }
    }

    static boolean checkName(String b){
        String n = b.replace(" ","");
        for(int i=0; i<n.length();i++){
            char x = n.charAt(i);
            if(!Character.isLetter(x)){
                return false;
            }
        }
        return true;
    }

    static boolean checkDate(String date){
        DateValidator x = DateValidator.getInstance();
        return x.isValid(date,"MMMM d, yyyy") && age(date)>0;
    }

    static boolean checkYear(String year){
        if(year.length()!=1){
            return false;
        }
        if(!Character.isDigit(year.charAt(0))){
            return false;
        }
        int x = Integer.parseInt(year);
        if(x>4 || x<1){
            return false;
        }
        return true;
    }
}
