package ua.h1totsu.DAO;

import ua.h1totsu.entity.UserImagePK;

import java.util.List;

public interface FavoriteDAO {
    List<UserImagePK> getAllUserImage();
    UserImagePK getUImageByImageId(int imageId);
    UserImagePK getUImageByUserId(int userId);
    //void insertUImage(UserImagePK uImage);
    //void updateUImage(UserImagePK uImage);
    //void deleteUImage(UserImagePK uImage);

}
