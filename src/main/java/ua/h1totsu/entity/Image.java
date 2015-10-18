package ua.h1totsu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Image {
    private Integer imageId;
    private String description;
    private Date date;
    private Set<Tag> tags = new HashSet<Tag>();
    private Set<Comment> comments = new HashSet<Comment>();
    private Set<User> users = new HashSet<>();
    private String img;
    private Integer likeCount;
    private Integer loadCount;
    private Integer userId;

    public Image() {
        this.likeCount = 0;
        this.loadCount = 0;
    }

    public Image(String description, Date date) {
        this.description = description;
        this.date = date;
        this.likeCount = 0;
        this.loadCount = 0;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getLoadCount() {
        return loadCount;
    }

    public void setLoadCount(Integer loadCount) {
        this.loadCount = loadCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (!getImageId().equals(image.getImageId())) return false;
        if (getDescription() != null ? !getDescription().equals(image.getDescription()) : image.getDescription() != null)
            return false;
        if (getDate() != null ? !getDate().equals(image.getDate()) : image.getDate() != null) return false;
        if (getLikeCount() != null ? !getLikeCount().equals(image.getLikeCount()) : image.getLikeCount() != null)
            return false;
        if (getLoadCount() != null ? !getLoadCount().equals(image.getLoadCount()) : image.getLoadCount() != null)
            return false;
        return !(getUserId() != null ? !getUserId().equals(image.getUserId()) : image.getUserId() != null);

    }

    @Override
    public int hashCode() {
        int result = getImageId().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getLikeCount() != null ? getLikeCount().hashCode() : 0);
        result = 31 * result + (getLoadCount() != null ? getLoadCount().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", description='" + description + '\'' +
                ", date=" + date + '}';
    }
}
