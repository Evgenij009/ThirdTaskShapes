package by.epam.eugene.entity;

import by.epam.eugene.observer.PyramidEvent;
import by.epam.eugene.observer.PyramidObservable;
import by.epam.eugene.observer.PyramidObserver;
import by.epam.eugene.util.PyramidIdGeneration;

//the base is a regular triangle
public class Pyramid implements PyramidObservable {
    private long pyramidId;
    private CustomPoint pointCenterOfBase;
    private double height;
    private double sideLengthBase;
    private PyramidObserver observer;

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
    public void attach(PyramidObservable observable) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.updateParameters(new PyramidEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pyramid pyramid = (Pyramid) o;

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
