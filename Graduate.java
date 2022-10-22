public class Graduate extends Student {



    Graduate(){
    }

    String showType(){
        return "Graduate";
    }

    String showStatus(){
        if(getStatus().equalsIgnoreCase("p")){
            return "Part time";
        }
        else{
            return "Full time";
        }
    }


}


