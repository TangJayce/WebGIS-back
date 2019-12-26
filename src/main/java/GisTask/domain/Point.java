package GisTask.domain;

/**
 * @author Jayce
 * @date 2019/11/1
 */
public class Point {
    private double longitude;
    private double latitude;

    public Point() {}

    /**
     * 经纬度点
     * @param longitude 经度
     * @param latitude 纬度
     */
    public Point(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Point{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
