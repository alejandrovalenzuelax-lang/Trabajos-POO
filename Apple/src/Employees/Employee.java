package Employees;

public abstract class Employee {
    String name;
    int sueldo;
    public static final String Company_Name = "Apple";
    private final float taxes=.15f;


    public float getTaxes() {
        return taxes;
    }

    public abstract float GetSalary();

}
