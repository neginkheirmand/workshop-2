
public class Rectangle extends Polygon{

    public Rectangle(int ... sides){
        super(sides);
    }
    @Override
    public double calculateArea() {
        double area = 0.0;
        double side1 = 0.0;
        double side2 = 0.0;
        side1 += sides.get(0);
        for (int i = 1; i < sides.size(); i++) {
            if (sides.get(i) != side1) {
                side2 += sides.get(i);
                break;
            }
        }
        if(side2== 0.0){
            //square
            side2=side1;
        }
        area += side1 * side2;
        return area;
    }

    @Override
    public void draw(){
        super.draw();
    }

    @Override
    public boolean equals(Object e) {
        if (e instanceof Rectangle) {
            Rectangle newRectangle = (Rectangle) e;
            double sideE1 = 0.0;
            double sideE2 = 0.0;
            sideE1 += newRectangle.getSides().get(0);
            for (int i = 1; i < newRectangle.getSides().size(); i++) {
                if (newRectangle.getSides().get(i) != sideE1) {
                    sideE2 += newRectangle.getSides().get(i);
                    break;
                }
            }
            if (sideE2 == 0.0) {
                //square
                sideE2 = sideE1;
            }
            //now we have the sides of the object passed to this method
            double side1 = (double) sides.get(0);
            ;
            double side2 = 0.0;
            for (int i = 1; i < sides.size(); i++) {
                if (sides.get(i) != side1) {
                    side2 += sides.get(i);
                    break;
                }
            }
            if (side2 == 0.0) {
                //square
                side2 = side1;
            }

            if ((side1 == sideE1 && side2 == sideE2) || (side1 == sideE2 && side2 == sideE1)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString();
    }

    public boolean isSquare(){
        int side = sides.get(0);
        for(int i=1; i<sides.size(); i++){
            if(sides.get(i) != side){
                return false;
            }
        }
        return true;
    }
}
