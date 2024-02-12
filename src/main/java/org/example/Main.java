package org.example;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String dateString = "2024-1-1T22:00+08:00";

        // Разбираем строку в объект OffsetDateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-M-d'T'HH:mmXXX"));

        // Получаем LocalDateTime из OffsetDateTime
        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();

        System.out.println(localDateTime);
    }
}