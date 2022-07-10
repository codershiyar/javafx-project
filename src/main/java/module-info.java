module com.groep9D.betabit_app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.groep9D.BetabitApp to javafx.fxml;
    exports com.groep9D.BetabitApp;
    exports models;
    opens models to javafx.fxml;
}