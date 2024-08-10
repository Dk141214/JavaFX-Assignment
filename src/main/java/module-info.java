module com.myuniversity.university111 {
    // Requires JavaFX modules for your application
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Requires GSON for JSON parsing
    requires com.google.gson;
    requires java.net.http;

    // Opens the package to JavaFX for reflection purposes
    opens com.myuniversity.university111 to javafx.fxml;

    // Exports the package so other modules can use it
    exports com.myuniversity.university111;
}
