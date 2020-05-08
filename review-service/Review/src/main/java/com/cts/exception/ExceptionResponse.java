package com.cts.exception;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ExceptionResponse {
private Date timestamp;
private String message;
private String details;

}
