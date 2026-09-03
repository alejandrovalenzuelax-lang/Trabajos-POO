public class Triangle extends Figura {
    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    public int getArea() {
        return (this.base*this.height)/2;
    }

}
