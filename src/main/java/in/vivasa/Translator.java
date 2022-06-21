package in.vivasa;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.FormBody;
import okhttp3.Response;

public class Translator {
  public static void main(String[] args) {
    try {
      OkHttpClient client = new OkHttpClient();

      RequestBody body = new FormBody.Builder()
          .add("q", "మహతి")
          .build();

      Request request = new Request.Builder()
          .url("https://google-translate1.p.rapidapi.com/language/translate/v2/detect")
          .post(body)
          .addHeader("content-type", "application/x-www-form-urlencoded")
          .addHeader("Accept-Encoding", "application/gzip")
          .addHeader("X-RapidAPI-Key", "8a3a2122bamshd3241f9f0833b52p17f94ejsn79a5d52dbada")
          .addHeader("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
          .build();

      Response response = client.newCall(request).execute();
      System.out.println("Response is " + response.message());

      Gson gson = new Gson(); 
      ResponseBody responseBody = response.body();
      System.out.println(responseBody.string());
    } catch (Exception ie) {
      ie.printStackTrace(System.out);
    }

  }
}