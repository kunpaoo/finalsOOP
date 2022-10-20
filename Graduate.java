public class Graduate extends Student {



    Graduate(){
    }

    int minYearsLeft(){
        if(getStatus().equalsIgnoreCase("f")){
            return 1;
        }
        else{
            return 2;
        }
    }

}


