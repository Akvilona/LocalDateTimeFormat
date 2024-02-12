package org.example;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String dateString = "2024-2-17T22:00+8:00";

        // Разбираем дату и время с явным указанием формата
        LocalDateTime localDateTime = LocalDateTime.parse(dateString.substring(0, dateString.indexOf("+")), DateTimeFormatter.ofPattern("yyyy-M-d'T'HH:mm"));

        // Разбираем смещение временной зоны
        String offsetString = dateString.substring(dateString.indexOf("+") + 1); // Извлекаем только строку смещения
        int hours = Integer.parseInt(offsetString.split(":")[0]); // Получаем часы из строки
        int minutes = Integer.parseInt(offsetString.split(":")[1]); // Получаем минуты из строки
        ZoneOffset zoneOffset = ZoneOffset.ofHoursMinutes(hours, minutes); // Создаем ZoneOffset

        // Создаем OffsetDateTime с помощью LocalDateTime и ZoneOffset
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

        System.out.println(offsetDateTime);
    }
}