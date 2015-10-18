
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.h1totsu.DAO.DAOImpl.FactoryDAO;
import ua.h1totsu.entity.Image;
import ua.h1totsu.entity.Tag;
import ua.h1totsu.other.JsonUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Image image = FactoryDAO.getInstance().getImageDAO().getImageById(1);
        JSONArray array = JsonUtils.toJSONArray(image.getTags());
        System.out.println();
    }
}