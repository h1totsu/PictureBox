package ua.h1totsu.DAO;

import ua.h1totsu.entity.Tag;

import java.util.List;

public interface TagDAO {
    List<Tag> getAllTags();
    Tag getTag(String tag);
    void insertTag(Tag tag);
    void updateTag(Tag tag);
    void deleteTag(Tag tag);
}
