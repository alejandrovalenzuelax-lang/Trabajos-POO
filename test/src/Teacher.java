public class Teacher extends Person{
    String Email;

    public Teacher(String name, String age, String email) {
        super(name, age);
        Email = email;
    }

    @Override
    void greeting(){
        System.out.println("Hola soy profesor y este es mi correo: "+this.Email);
    }
}
