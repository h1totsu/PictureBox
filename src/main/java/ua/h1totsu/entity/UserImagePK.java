package ua.h1totsu.entity;

import java.io.Serializable;

public class UserImagePK implements Serializable {
    private Integer userId;
    private Integer imageId;

    public UserImagePK() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImagePK userImagePK = (UserImagePK) o;

        if (userId != null ? !userId.equals(userImagePK.userId) : userImagePK.userId != null) return false;
        if (imageId != null ? !imageId.equals(userImagePK.imageId) : userImagePK.imageId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
        return result;
    }
}
