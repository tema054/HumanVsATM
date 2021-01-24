package ru.sber.projectATM.common;


import lombok.ToString;
import lombok.Value;
import org.springframework.core.serializer.Deserializer;

import java.io.Serializable;

@Value
@ToString
public class Request {
    private final int id;
    private final String PAN;
    private final int PIN;
}
