package ua.h1totsu.entity;


import java.io.Serializable;

public class ImageTagPK implements Serializable {
    Integer imageId;
    Integer tagId;

    public ImageTagPK() {
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageTagPK that = (ImageTagPK) o;

        if (getImageId() != null ? !getImageId().equals(that.getImageId()) : that.getImageId() != null) return false;
        return !(getTagId() != null ? !getTagId().equals(that.getTagId()) : that.getTagId() != null);

    }

    @Override
    public int hashCode() {
        int result = getImageId() != null ? getImageId().hashCode() : 0;
        result = 31 * result + (getTagId() != null ? getTagId().hashCode() : 0);
        return result;
    }
}
