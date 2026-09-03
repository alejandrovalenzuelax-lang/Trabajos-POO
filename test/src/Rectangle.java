public class Rectangle extends Figura{
    public Rectangle(int base, int height) {
        super(base, height);
    }

    @Override
    public int getArea() {
        return this.base*this.height;
    }
}
