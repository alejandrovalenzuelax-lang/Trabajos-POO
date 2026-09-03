
public class Main {
    public static void main(String[] args) {

        Person person = new Person("Dayana", "26");
        Person person1 = new Person("Paola", "22");

        person.greeting();
        person1.greeting();

        Teacher teacher = new Teacher("Luis","35","@example.com");

        teacher.greeting();

        Figura triangle = new Triangle(4,4);
        System.out.println("La Area del triangulo es: "+triangle.getArea());
        Figura square = new Square(5,7);
        System.out.println("La area del cuadrado es: "+square.getArea());
        Figura rectangle = new Rectangle(6,3);
        System.out.println("La area del rectangulo es: "+rectangle.getArea());

        FigureInterface triangle2 = new TriangleInterface(4,5);
        System.out.println("El area del triangulo es de: "+triangle2.getArea());
    }
}