package GisTask.domain;

import java.util.Date;

/**
 * @author Jayce
 * @date 2019/12/23
 */
public class Coordinate {
    private int id;
    private String username;
    private Point latlng;
    private String description;
    private String time;

    public Coordinate() {}

    public Coordinate(String username, Point latlng, String description, String time) {
        this.username = username;
        this.latlng = latlng;
        this.description = description;
        this.time = time;
    }

    public Coordinate(int id, String username, Point latlng, String description, String time) {
        this.id = id;
        this.username = username;
        this.latlng = latlng;
        this.description = description;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Point getLatlng() {
        return latlng;
    }

    public void setLatlng(Point latlng) {
        this.latlng = latlng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", latlng=" + latlng +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
