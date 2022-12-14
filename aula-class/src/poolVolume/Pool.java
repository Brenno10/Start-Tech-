package poolVolume;

public class Pool {
    public double width;
    public double length;
    public double depth;

    public Pool(double width, double length, double depth) {
        this.width = width;
        this.length = length;
        this.depth = depth;
    }

    public double calculateVolume() {
        return (width * length * depth) * 1000;
    }
}
