public class Person {
    String name;
    String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    void greeting() {
        System.out.println("Hola soy " + this.name + ", mi edad es: " + this.age);
    }
}
