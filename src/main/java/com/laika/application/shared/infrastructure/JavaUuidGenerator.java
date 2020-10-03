package com.laika.application.shared.infrastructure;

import com.laika.application.shared.domain.UuidGenerator;

import java.util.UUID;

public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
