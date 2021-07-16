package by.epam.eugene.entity;

public class PyramidParameter {
    private double volume;
    private double area;
    private double perimeter;

    public PyramidParameter(double volume, double area, double perimeter) {
        this.volume = volume;
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PyramidParameter that = (PyramidParameter) o;

        if (Double.compare(that.volume, volume) != 0) return false;
        if (Double.compare(that.area, area) != 0) return false;
        return Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perimeter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PyramidParameter{");
        sb.append("volume=").append(volume);
        sb.append(", area=").append(area);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
