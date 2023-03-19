package com.dev.LojaVirtual.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
public class StandardError {
    private Instant timestamp;
    private int status;
    private String Error;
    private String messenger;
    private String path;

    public StandardError(Instant timestamp, int status, String Error, String messenger, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.Error = Error;
        this.messenger = messenger;
        this.path = path;
    }

}
