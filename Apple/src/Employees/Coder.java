package Employees;

public class Coder extends Employee{

    private float salary;
    private final float bonus = .15f;

    public Coder(float salary) {
        this.salary = salary;
    }

    @Override
    public float GetSalary() {
        return this.salary + (this.salary*this.bonus)-(this.salary-super.getTaxes());
    }
}
