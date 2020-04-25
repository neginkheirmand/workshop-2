
public class Main {
    public static void main (String... args) {
        Circle circle1 = new Circle(3);
        Shape circle2 = new Circle(3);

        Rectangle rect1 = new Rectangle( 1, 4, 1, 4 );
        Rectangle rect2 = new Rectangle(4,1,1,4);

        Triangle tri1 = new Triangle(2,2,2);
        Triangle tri2 = new Triangle(2,2,2);
        Triangle tri3 = new Triangle(1,4,6);

        Paint newPaint =new Paint();
        newPaint.addShape(circle1);
        newPaint.addShape(circle2);
        if(circle1.equals(circle2)){
            System.out.println("\033[0;31m"+"2 circles are alike"+"\033[0m");
        }
        newPaint.addShape(rect1);
        newPaint.addShape(rect2);
        if(rect1.equals(rect2)){
            System.out.println("\033[0;31m"+"2 rectangles are alike"+"\033[0m");
        }
        newPaint.addShape(tri1);
        newPaint.addShape(tri2);
        if(tri1.equals(tri2)){
            System.out.println("\033[0;31m"+"2 first triangles are alike"+"\033[0m");
        }
        newPaint.addShape(tri3);
        if(tri1.equals(tri3)){
            System.out.println("\033[0;31m"+"the first and the third triangles are alike"+"\033[0m");
        }
        if(tri2.equals(tri3)){
            System.out.println("\033[0;31m"+"the second and the third triangles are alike"+"\033[0m");
        }
        newPaint.DrawAll();
        System.out.println();
        newPaint.describeEqualSides();
    }

}
