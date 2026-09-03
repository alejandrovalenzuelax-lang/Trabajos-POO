package Employees;

public class Manager extends Employee{

    private float salary;
    private final float Bonus=0.3f;

    public Manager(float salary) {
        this.salary = salary;
    }

    @Override
    public float GetSalary() {
        return this.salary+(this.salary*this.Bonus)-(this.salary*super.getTaxes());
    }
}
