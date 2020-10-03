package com.laika.laikagram.shared.application.media;

import com.laika.laikagram.shared.domain.media.FailedUploadException;
import com.laika.laikagram.shared.domain.media.MediaService;

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
