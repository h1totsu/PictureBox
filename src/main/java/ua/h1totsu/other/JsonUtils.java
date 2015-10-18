package ua.h1totsu.other;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.h1totsu.entity.Image;
import ua.h1totsu.entity.Tag;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class JsonUtils {
    public static JSONArray toJSONArray(Set<Tag> tags) {
        JSONArray array = new JSONArray();
        JSONObject jsonObject = null;
        for(Iterator<Tag> iterator = tags.iterator(); iterator.hasNext();) {
            jsonObject = toJSONObject(iterator.next());
            array.add(jsonObject);
        }
        return array;
    }

    public static JSONObject toJSONObject(Image image) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", image.getDescription());
        jsonObject.put("date", image.getDate().toString());
        jsonObject.put("likes", image.getLikeCount());
        jsonObject.put("loads", image.getLoadCount());
        jsonObject.put("img", image.getImg());
        jsonObject.put("tags", toJSONArray(image.getTags()));
        return jsonObject;
    }

    public static JSONObject toJSONObject(Tag tag) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag", tag.getTag());
        return jsonObject;
    }
}
