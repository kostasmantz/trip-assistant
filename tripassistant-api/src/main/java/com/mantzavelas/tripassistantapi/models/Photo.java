package com.mantzavelas.tripassistantapi.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(indexes = {@Index(name = "photo_dateuploaded", columnList = "dateUploaded")})
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "text")
    private String description;

    private int rotation;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateUploaded;

    private String url;

    private String latitude;

    private String longitude;

    @ManyToMany
    @JoinTable(
        name = "photo_categories",
        joinColumns = @JoinColumn(name = "photo_id"),
        inverseJoinColumns = @JoinColumn(name = "categories_id")
    )
    private List<PhotoCategory> categories;

    public Photo() {
    }

    public Photo(Long id, String title, String description, int rotation, Date dateUploaded, String url, String latitude, String longitude) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rotation = rotation;
        this.dateUploaded = dateUploaded;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getRotation() { return rotation; }
    public void setRotation(int rotation) { this.rotation = rotation; }

    public Date getDateUploaded() { return dateUploaded; }
    public void setDateUploaded(Date dateUploaded) { this.dateUploaded = dateUploaded; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public List<PhotoCategory> getCategories() { return categories; }
    public void setCategories(List<PhotoCategory> categories) { this.categories = categories; }
}
