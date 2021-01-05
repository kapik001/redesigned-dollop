package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.kapusta.webapp.controller.MainSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.rest.clients.UserClient;
import com.kapusta.webapp.utils.WebClientLogger;
import javafx.application.Platform;
import javafx.scene.Scene;

public class MainSceneServiceImpl implements MainSceneService {

    @Inject
    private FXMLHolder<MainSceneController> mainSceneController;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private UserClient userClient;

    public void init() {
        userClient.getUserData((userData) -> {
            Platform.runLater(() -> mainStageHolder.changeScene(new Scene(mainSceneController.getRoot())));
            mainSceneController.getController().setUserName(userData.getLogin());
        }, (t) -> {
            WebClientLogger.logError("Error during retrieving user data", t);
        });

    }
}
