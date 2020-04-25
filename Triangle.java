
import java.util.HashSet;

public class Triangle extends Polygon {

    public Triangle(int ... sides){
        super(sides);
    }

    @Override
    public double calculateArea() {
        double area = 0.0;
        double p = calculatePerimeter()/2;
        area = Math.sqrt(p * (p-sides.get(0)) * (p-sides.get(1)) * (p-sides.get(2)) );
        return area;
    }

    @Override
    public void draw(){
        super.draw();
    }

    @Override
    public boolean equals(Object e) {
        if (e instanceof Triangle) {
            int[][] sidesThisTriangle= new int[2][3];
            for(int i=0; i<3; i++){
                sidesThisTriangle[0][i]=sides.get(i);
                sidesThisTriangle[1][i]=0;
            }

            Triangle newTriangle = (Triangle)e;
            int[] sidesNewTriangle= new int[3];
            for(int i=0; i<3; i++){
                sidesNewTriangle[i]=newTriangle.getSides().get(i);
            }

            for(int i=0; i<3; i++){
                boolean exist = false;
                for(int j=0; j<3; j++){
                    if( sidesNewTriangle[i] == sidesThisTriangle[0][j] && sidesThisTriangle[1][j]==0 ) {
                        exist = true;
                        sidesThisTriangle[1][j]=1;
                        break;
                    }
                }
                if(!exist){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString();
    }

    public boolean isEquilateral(){
        int side =sides.get(0);
        for(int i=1; i<sides.size(); i++){
            if(sides.get(i) != side){
                return false;
            }
        }
        return true;
    }
}
