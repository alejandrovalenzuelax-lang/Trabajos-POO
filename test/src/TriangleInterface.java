public class TriangleInterface implements FigureInterface{
    int base;
    int height;

    public TriangleInterface(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public int getArea() {
        return (this.base*this.height)/2;
    }
}
