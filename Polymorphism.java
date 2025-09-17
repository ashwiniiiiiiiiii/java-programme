 class shape{
    
    double area(){
        reture 0;
    }
}
class circle extends shape{
    double radius;
    Circle(double radius){
        this.radius=radius;
    }
    @override
    double area(){
        return Math.PI*radius*radius;
    }
}
class Rectangle extends Shape{
    double length,width;
    Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    @override
    double area(){
        return length*width;
    }
}
public class Polymorphism{
    public static void Main(String[] args){
        shape s1=new Circle(5);
        shape s2=new rectangle(4,6);
        System.out.println("Area"+s1.area());
        System.out.println("area of rectangle"+s2.area());

    }
}

    