package com.myuniversity.university111;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class SceneController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label messageLabel;
    @FXML
    private Label additionalLabel;

    @FXML
    private TextField countryName;

    @FXML
    private ListView universitiesList = new ListView();

    @FXML
    private void initialize() {
        // Initialize labels if needed
    }

    @FXML
    private void onHelloButtonClick() throws IOException, InterruptedException {

        String country = countryName.getText();
        ObservableList<String> universitiesNames = FXCollections.observableArrayList();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://universities.hipolabs.com/search?country="+country))
                .GET() // GET is default
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        try{
            Gson gson = new Gson();
        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> universities = gson.fromJson(response.body(), listType);

        for (Map<String, Object> university : universities) {
            universitiesNames.add(university.get(("name")).toString());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        universitiesList.setItems(universitiesNames);
    }
}
