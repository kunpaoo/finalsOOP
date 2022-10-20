import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import org.apache.commons.validator.routines.*; //jar files in https://commons.apache.org/proper/commons-validator/download_validator.cgi


public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.print("Graduate(G) or Undergraduate(U): ");
        String ug = inp.nextLine();
        while (!checkUG(ug)) {
            System.out.println("Invalid input.");
            System.out.print("Graduate(G) or Undergraduate(U): ");
            ug = inp.nextLine();
        }
        String statype;
        if (ug.equalsIgnoreCase("G")) {
            System.out.println("Part time(P) or Full time(F): ");
            statype = inp.nextLine();
            while (!checkType(statype, "g")) {
                System.out.println("Invalid input.");
                System.out.print("Part time(P) or Full time(F): ");
                statype = inp.nextLine();
            }
        } else {
            System.out.println("Regular(R) or Irregular(I): ");
            statype = inp.nextLine();
            while (!checkType(statype, "u")) {
                System.out.println("Invalid input.");
                System.out.print("Regular(R) or Irregular(I): ");
                statype = inp.nextLine();
            }
        }
        System.out.print("Enter your Student ID: ");
        String id = inp.nextLine();
        while (!checkId(id)) {
            System.out.println("Invalid input.");
            System.out.print("Enter your Student ID (6 digits): ");
            id = inp.nextLine();
        }
        System.out.print("Enter your first name: ");
        String first = inp.nextLine();
        while (!checkName(first)) {
            System.out.println("Invalid input.");
            System.out.print("Enter your first name: ");
            first = inp.nextLine();
        }
        System.out.print("Enter your middle initial: ");
        String mid = inp.nextLine();
        while (!checkName(mid)) {
            System.out.println("Invalid input.");
            System.out.print("Enter your middle name: ");
            mid = inp.nextLine();
        }
        System.out.print("Enter your last name: ");
        String last = inp.nextLine();
        while (!checkName(last)) {
            System.out.println("Invalid input.");
            System.out.print("Enter your last name: ");
            last = inp.nextLine();
        }
        System.out.print("Enter your birthdate: ");
        String birth = inp.nextLine();
        while (!checkDate(birth)) {
            System.out.println("Invalid input.");
            System.out.print("Enter your birthdate (Month Day, Year): ");
            birth = inp.nextLine();
        }
        System.out.print("Enter your gender: ");
        String gend = inp.nextLine();
        while (!checkName(gend)) {
            System.out.println("Invalid input.");
            System.out.print("Enter your gender: ");
            gend = inp.nextLine();
        }
        System.out.print("Enter your address: ");
        String addr = inp.nextLine(); //how to validate address fhsjdkhf

        System.out.print("Enter your course: ");
        String course = inp.nextLine();
        while (!checkName(course)) {
            System.out.println("Invalid input.");
            System.out.print("Enter your course: ");
            course = inp.nextLine();
        }
        String year = null;
        if(ug.equalsIgnoreCase("u")){
            System.out.print("Enter your year level: ");
            year = inp.nextLine();
            while (!checkYear(year)) {
                System.out.println("Invalid input.");
                System.out.print("Enter your year level: ");
                year = inp.nextLine();
            }
        }

        System.out.print("Enter your contact number: ");
        String num = inp.nextLine();
        while (!checkContact(num)) {
            System.out.println("Invalid number.");
            System.out.print("Enter your contact number: ");
            num = inp.nextLine();
        }
        System.out.print("Enter your email: ");
        String email = inp.nextLine();
        while (!checkEmail(email)) {
            System.out.println("Invalid email.");
            System.out.print("Enter your email: ");
            email = inp.nextLine();
        }


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

        //PROGRAM OUTPUT

    System.out.print("\nWelcome, "+s.getName()
                        +" to our university. "
                        +"Your birthday is "
                        +s.getBirthdate()
                        +" and you are "
                        +age(s.getBirthdate())
                        +" years old. "
                        +"Your gender is "
                        +s.getGender()
                        +" and you reside in "
                        +s.getAddress()
                        +"."
                        +" Your course is "
                        +s.getCourse()
                        +", currently a");
    if (ug.equalsIgnoreCase("u")){
        System.out.print(" "+yearT(s.getYear()));
        if(s.getStatus().equalsIgnoreCase("r")){
            System.out.print(" regular");
        }
        else{
            System.out.print(" irregular");
        }
        System.out.print(" undergraduate");
    }
    else{
        if(s.getStatus().equalsIgnoreCase(("p"))){
            System.out.print(" part time");
        }
        else{
            System.out.print(" full time");
        }
        System.out.print(" graduate");
    }
    System.out.print(" student."+" Your Student ID is "  +s.getID()+".");
    System.out.print(" Your contact number is "+s.getNumber()+" and your email is "+s.getEmail()+".");

    if(!s.getStatus().equalsIgnoreCase("i")){
        if(Integer.parseInt(s.getYear())==4){
            System.out.println("\nYou're graduating this year. Good luck!");
        }
        else{
            System.out.println("\nYou currently have a minimum of "+s.minYearsLeft()+" years left before graduating. Good luck!");
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
