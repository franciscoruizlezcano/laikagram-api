package com.laika.laikagram.shared.domain.media;

public final class FailedUploadException extends Exception {
    public FailedUploadException() {
    }

    public FailedUploadException(String message) {
        super(message);
    }

    public FailedUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedUploadException(Throwable cause) {
        super(cause);
    }

    public FailedUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
