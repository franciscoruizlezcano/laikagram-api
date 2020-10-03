package com.laika.laikagram.shared.infrastructure.media.firebase;

public enum FirebaseHttpParam {
    PARAMS_HTTP_REQUEST("?uploadType=media&name="),
    NAME_POST("post-"),
    MEDIA_TYPE("image/jpeg"),
    PARAM_MEDIA("alt=media"),
    PARAM_TOKEN("token=");

    private final String type;

    FirebaseHttpParam(String type) {
        this.type = type;
    }

    public String value() {
        return type;
    }
}