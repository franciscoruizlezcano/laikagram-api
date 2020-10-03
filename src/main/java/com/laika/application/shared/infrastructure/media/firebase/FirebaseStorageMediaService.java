package com.laika.application.shared.infrastructure.media.firebase;

import com.laika.application.shared.domain.media.FailedUploadException;
import com.laika.application.shared.domain.media.MediaService;
import com.laika.application.shared.domain.util.JsonUtil;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class FirebaseStorageMediaService implements MediaService {
    private final static String URI_HTTP       = "https://firebasestorage.googleapis.com/v0/b/";

    @Override
    public String upload(byte[] file) throws FailedUploadException {
        try {
            URI uri = createUriMediaUpload();

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .timeout(Duration.ofMinutes(1))
                    .header("Content-Type", FirebaseHttpParam.MEDIA_TYPE.value())
                    .POST(HttpRequest.BodyPublishers.ofByteArray(file))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            HashMap<String, Serializable> responseBody = JsonUtil.jsonDecode(response.body());

            if (responseBody == null) {
                throw new FailedUploadException("Photo upload failed");
            }

            return createUriMedia(responseBody);

        } catch (InterruptedException | IOException exception) {
            throw new FailedUploadException("Photo upload failed");
        }
    }

    private URI createUriMediaUpload() {
        return URI.create(String.format("%s%s/o%s%s", URI_HTTP, this.getFirebaseProjectName(), FirebaseHttpParam.PARAMS_HTTP_REQUEST.value(), this.getNameMediaUpload()));
    }

    private String getNameMediaUpload() {
        return String.format("%s%s", FirebaseHttpParam.NAME_POST.value(), LocalDateTime.now().toString());
    }

    private String getFirebaseProjectName() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("FIREBASE_PROJECT_NAME");
    }

    private String createUriMedia(HashMap<String, Serializable> responseBody) throws IOException {
        return String.format(
                "%s%s/o/%s?%s&%s%s",
                URI_HTTP,
                this.getFirebaseProjectName(),
                responseBody.get("name"),
                FirebaseHttpParam.PARAM_MEDIA.value(),
                FirebaseHttpParam.PARAM_TOKEN.value(),
                responseBody.get("downloadTokens")
        );
    }
}
