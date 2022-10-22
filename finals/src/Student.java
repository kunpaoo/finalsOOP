import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    private String id,first,mid,last,birth,gend,addr,course,year,num,email,status;

    Student(){
    }

    String getFirstname(){
        return this.first;
    }

    void setFirstname(String first){
        this.first = first;
    }


    String getMidI(){
        return this.mid;
    }

    void setMidI(String mid){
        this.mid = mid;
    }

    String getLast(){
        return this.last;
    }

    void setLast(String last){
        this.last = last;
    }

    String getName(){           //returns full name
        return first+" "+mid+" "+last;
    }

    String getID(){
        return this.id;
    }

    void setID(String id){
        this.id = id;
    }

    String getBirthdate(){
        return this.birth;
    }

    void setBirthdate(String birth){
        this.birth = birth;
    }

    String getGender(){
        return this.gend;
    }

    void setGender(String gend){
        this.gend = gend;
    }

    String getAddress(){
        return this.addr;
    }

    void setAddress(String addr){
        this.addr = addr;
    }

    String getCourse(){
        return this.course;
    }

    void setCourse(String course){
        this.course = course;
    }

    String getYear(){
        return this.year;
    }

    void setYear(String year){
        this.year = year;
    }

    String getNumber(){
        return this.num;
    }

    void setNumber(String num){
        this.num=num;
    }

    String getEmail(){
        return this.email;
    }

    void setEmail(String email){
        this.email = email;
    }

    String getStatus() {
        return this.status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    String showStatus(){
        return null;
    }


    String showType(){
        return null;
    }
}
