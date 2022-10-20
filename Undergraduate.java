public class Undergraduate extends Student{


    Undergraduate(){
    }


    int minYearsLeft(){
        if(getStatus().equalsIgnoreCase("r")){
            return 4-Integer.parseInt(getYear());
        }
        else{
            return 0; //if irregular, don't display minYearsLeft ???
        }
    }

}
