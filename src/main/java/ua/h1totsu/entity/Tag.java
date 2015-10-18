package ua.h1totsu.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tag {
    private Integer tagId;
    private String tag;
    //private Set<Image> images = new HashSet<>();

    public Tag() {
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

//    public Set<Image> getImages() {
//        return images;
//    }
//
//    public void setImages(Set<Image> images) {
//        this.images = images;
//    }

    public static Set<Tag> setTagsFromString(String tagsString) {
        Set<Tag> tags = new HashSet<>();
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(tagsString);
        while (matcher.find()) {
            Tag tag = new Tag();
            tag.setTag(matcher.group());
            tags.add(tag);
        }
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag1 = (Tag) o;

        if (getTagId() != null ? !getTagId().equals(tag1.getTagId()) : tag1.getTagId() != null) return false;
        return !(getTag() != null ? !getTag().equals(tag1.getTag()) : tag1.getTag() != null);

    }

    @Override
    public int hashCode() {
        int result = getTagId() != null ? getTagId().hashCode() : 0;
        result = 31 * result + (getTag() != null ? getTag().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "tagId=" + tagId +
                ", tag='" + tag;
    }
}
