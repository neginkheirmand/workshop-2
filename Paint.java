
import java.util.ArrayList;

public class Paint {
    private ArrayList<Shape> shapes;

    public Paint(){
        shapes = new ArrayList<>();
    }

    public void addShape(Shape newShape){
        shapes.add(newShape);
        return;
    }

    public void DrawAll(){
        System.out.println("\n---");
        System.out.println("Printing all the shapes:");
        for(int i=0; i<shapes.size(); i++){
            System.out.println("shape "+(i+1)+")");
            if(shapes.get(i) instanceof  Circle){
                ((Circle) shapes.get(i)).draw();
            }else if(shapes.get(i) instanceof  Triangle){
                System.out.println(" is a Triangle");
                ((Triangle) shapes.get(i)).draw();
            }else if(shapes.get(i) instanceof  Rectangle){
                System.out.println(" is a Rectangle");
                ((Rectangle) shapes.get(i)).draw();
            }
        }
        System.out.println("---\n");
    }

    public void describeEqualSides(){
        for(int i=0; i<shapes.size(); i++){
            if( (shapes.get(i) instanceof  Triangle) && ((Triangle) shapes.get(i)).isEquilateral() ){
                System.out.printf("the triangle:   ");
                ((Triangle) shapes.get(i)).draw();
                System.out.println("is equilateral");
            }else if( (shapes.get(i) instanceof  Rectangle) && ((Rectangle) shapes.get(i)).isSquare() ){
                System.out.printf("the Reactangle:   ");
                ((Triangle) shapes.get(i)).draw();
                System.out.println("is Square");
            }
        }
    }
}
