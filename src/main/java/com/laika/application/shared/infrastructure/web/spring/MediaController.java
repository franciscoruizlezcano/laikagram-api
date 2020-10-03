package com.laika.application.shared.infrastructure.web.spring;

import com.laika.application.shared.application.media.UploadMedia;
import com.laika.application.shared.domain.media.FailedUploadException;
import com.laika.application.shared.infrastructure.media.firebase.FirebaseStorageMediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class MediaController {
    private final UploadMedia uploadMedia;

    public MediaController() {
        this.uploadMedia = new UploadMedia(new FirebaseStorageMediaService());
    }

    @PostMapping("/media")
    public ResponseEntity<HashMap<String, Serializable>> index(
            @RequestParam(value = "file", required = false) MultipartFile file
    ) throws IOException, FailedUploadException, InterruptedException {

        String url = this.uploadMedia.upload(file.getBytes());

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("url", url);
        }});
    }
}
