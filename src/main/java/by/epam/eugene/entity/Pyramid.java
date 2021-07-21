package by.epam.eugene.entity;

import by.epam.eugene.util.PyramidIdGeneration;

//the base is a regular triangle
public class Pyramid {
    private long pyramidId;
    private CustomPoint pointCenterOfBase;
    private double height;
    private double sideLengthBase;

    public Pyramid(CustomPoint pointCenterOfBase, double height, double sideLength) {
        this.pyramidId = PyramidIdGeneration.generateId();
        this.pointCenterOfBase = pointCenterOfBase;
        this.height = height;
        this.sideLengthBase = sideLength;
    }

    public long getPyramidId() {
        return pyramidId;
    }

    public void setPyramidId(long pyramidId) {
        this.pyramidId = pyramidId;
    }

    public CustomPoint getPointCenterOfBase() {
        return pointCenterOfBase;
    }

    public void setPointCenterOfBase(CustomPoint pointCenterOfBase) {
        this.pointCenterOfBase = pointCenterOfBase;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSideLengthBase() {
        return sideLengthBase;
    }

    public void setSideLengthBase(double sideLengthBase) {
        this.sideLengthBase = sideLengthBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pyramid pyramid = (Pyramid) o;

        if (pyramidId != pyramid.pyramidId) return false;
        if (Double.compare(pyramid.height, height) != 0) return false;
        if (Double.compare(pyramid.sideLengthBase, sideLengthBase) != 0) return false;
        return pointCenterOfBase != null ? pointCenterOfBase.equals(pyramid.pointCenterOfBase) : pyramid.pointCenterOfBase == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (pyramidId ^ (pyramidId >>> 32));
        result = 31 * result + (pointCenterOfBase != null ? pointCenterOfBase.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideLengthBase);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\nPyramid{");
        sb.append("pyramidId=").append(pyramidId);
        sb.append(", pointCenterOfBase=").append(pointCenterOfBase);
        sb.append(", height=").append(height);
        sb.append(", sideLength=").append(sideLengthBase);
        sb.append("}");
        return sb.toString();
    }
}
