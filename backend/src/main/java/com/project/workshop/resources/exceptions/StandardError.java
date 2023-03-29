package com.project.workshop.resources.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class StandardError implements Serializable {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
