public class Square extends Figura{
    public Square(int base, int height) {
        super(base, height);
    }

    @Override
    public int getArea() {
        return this.base*this.base;
    }
}
