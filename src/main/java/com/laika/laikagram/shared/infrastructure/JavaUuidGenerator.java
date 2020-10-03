package com.laika.laikagram.shared.infrastructure;

import com.laika.laikagram.shared.domain.UuidGenerator;

import java.util.UUID;

public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
