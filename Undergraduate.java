public class Undergraduate extends Student{

    private String status;

    Undergraduate(){
    }

    String getStatus() {
        return this.status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    int minYearsLeft(){
        if(status.equalsIgnoreCase("r")){
            return Integer.parseInt(getYear())-4;
        }
        else{
            return 0; //if irregular, don't display minYearsLeft ???
        }
    }

}
