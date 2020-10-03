package com.laika.application.shared.application.media;

import com.laika.application.shared.domain.media.FailedUploadException;
import com.laika.application.shared.domain.media.MediaService;

import java.io.IOException;

public final class UploadMedia {
    private final MediaService mediaService;

    public UploadMedia(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    public String upload(byte[] file) throws IOException, InterruptedException, FailedUploadException {
        return this.mediaService.upload(file);
    }
}
