public class Undergraduate extends Student{


    Undergraduate(){
    }

    String showType(){
        return "Undergraduate";
    }

    String showStatus(){
        if(getStatus().equalsIgnoreCase("r")){
            return "Regular";
        }
        else{
            return "Irregular";
        }
    }

}
