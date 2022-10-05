public class Graduate extends Student {

    private String type;

    Graduate(){
    }

    String getType() {
        return this.type;
    }

    void setType() {
        this.type = type;
    }

    int minYearsLeft(){
        if(type.equalsIgnoreCase("f")){
            return 1;
        }
        else{
            return Integer.parseInt(getYear()) - 2;
        }
    }

}


