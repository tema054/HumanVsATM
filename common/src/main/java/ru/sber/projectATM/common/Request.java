package ru.sber.projectATM.common;


import lombok.Value;

@Value
public class Request {
    private final int id;
    private final String PAN;
    private final int PIN;
}
