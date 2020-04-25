
import java.util.ArrayList;

public class Polygon extends Shape{
    protected ArrayList<Integer> sides;

    public Polygon( int...varargs){
        sides = new ArrayList<>();
        for(int arg : varargs){
            sides.add(arg);
        }
    }

    public ArrayList<Integer> getSides(){
        return sides;
    }

    @Override
    public void draw(){
        System.out.println(toString());
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0.0;
        for (int i = 0; i < sides.size(); i++) {
            perimeter += sides.get(i);
        }
        return perimeter;
    }


    @Override
    public String toString(){
        String newStr = "";
        for(int i=1; i<=sides.size(); i++){
            newStr+="side";
            newStr+=i;
            newStr+=":";
            newStr+=sides.get(i-1);
            if(i!=sides.size()) {
                newStr += ", ";
            }
        }
        return newStr;
    }
}
