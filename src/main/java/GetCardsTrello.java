import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetCardsTrello{

    public static void main(String[] args) throws IOException {

        String board = "4d5ea62fd76aa1136000000c";
        String Api_key = "4b0c70a39d33bb30c8747efbd95c6e08";
        String Token_key = "c56d90658d3f9735fb5f697508404584a5a60380bd42f585ae03f9eb3ca64988";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/"+board+"/?cards=all&key="+Api_key+"&token="+Token_key)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        String jsondata = response.body().string();


        JSONObject Jobject = new JSONObject(jsondata);
        JSONArray Jarray = Jobject.getJSONArray("cards");
        //System.out.println(Jarray);

        List<String> pokeTypes = new ArrayList<String>();

        for (int i = 0; i < Jarray.length(); i++) {
            String name;
            JSONObject object = Jarray.getJSONObject(i);
            name = object.getString("name");
            pokeTypes.add(name);
        }

        for (int i = 0; i < pokeTypes.size(); i++) {
            System.out.println(pokeTypes.get(i));
        }

    }
}

