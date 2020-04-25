
public class Circle extends Shape{

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter(){
        double perimeter=3.14;
        perimeter*=2;
        perimeter*=radius;
        return perimeter;
    }

    @Override
    public double calculateArea(){
        double area = 3.14;
        area*=radius;
        area*=radius;
        return area;
    }

    public void draw(){
        System.out.println("The shape: Circle\nthe Area: "+calculateArea()+"\nthe Perimeter: "+calculatePerimeter());
        return;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object e){
        if(e instanceof Circle){
            if(this.radius == ((Circle)e).getRadius()){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString(){
        return ("radius"+radius);
    }
}
