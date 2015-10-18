package ua.h1totsu.DAO;

import ua.h1totsu.entity.Image;

import java.util.List;

public interface ImageDAO {
    List<Image> getAllImages();
    Image getImageById(int imageId);
    void insertImage(Image image);
    void updateImage(Image image);
    void deleteImage(Image image);
    public List<Image> getAnyImages(int first, int count);
    public int getImagesCount();
}
