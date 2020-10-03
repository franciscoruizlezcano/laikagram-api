package com.laika.laikagram.shared.domain.media;

import java.io.IOException;

public interface MediaService {
    String upload(byte[] file) throws IOException, InterruptedException, FailedUploadException;
}
