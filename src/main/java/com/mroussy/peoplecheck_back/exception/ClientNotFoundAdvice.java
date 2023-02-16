package com.mroussy.peoplecheck_back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@ControllerAdvice
public class ClientNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(ClientNotFoundException exception) {
        Map<String, String> erroMap = new HashMap<>();
        erroMap.put("errorMessage", exception.getMessage());
        return erroMap;
    }
}
