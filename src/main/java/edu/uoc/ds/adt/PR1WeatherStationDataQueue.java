package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.uoc.ds.traversal.Iterator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class PR1WeatherStationDataQueue {

    private Queue<WeatherStationData> queue;
    public final int CAPACITY = 1000;

    public PR1WeatherStationDataQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }

    public Queue<WeatherStationData> getQueue() {
        return queue;
    }

    public void add(WeatherStationData data) {
        if (queue.size() < CAPACITY) {
            queue.add(data);
        }
    }

    public WeatherStationData poll() {
        try {
            return queue.poll();
        } catch (edu.uoc.ds.exceptions.EmptyContainerException e) {
            return null;
        }
    }

    public void loadFromCSV(String filePath) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        File csvFile = new File(filePath);
        if (!csvFile.exists() || !csvFile.isFile()) {
            throw new IOException("CSV file not found: " + filePath);
        }

        try (FileReader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            for (CSVRecord record : csvParser) {
                try {
                    String dateStr = record.get("lastUpdated");
                    String tempStr = record.get("avgAirTemperature");
                    String precipStr = record.get("precipitation");

                    LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
                    double temperature = Double.parseDouble(tempStr);
                    double precipitation = Double.parseDouble(precipStr);

                    WeatherStationData data = new WeatherStationData(dateTime, temperature, precipitation);
                    add(data);

                    System.out.println("Added: " + dateTime + " | Temp: " + temperature + " | Precip: " + precipitation);

                } catch (Exception e) {
                    System.err.println("Skipping row due to error: " + record.toString() + " -> " + e.getMessage());
                }
            }
        }
    }

    public double averageTemperature() {
        double sum = 0;
        int count = queue.size();
        Iterator<WeatherStationData> it = queue.values();
        while (it.hasNext()) {
            sum += it.next().getTemperature();
        }
        return count > 0 ? sum / count : 0;
    }

    public double averagePrecipitation() {
        double sum = 0;
        int count = queue.size();
        Iterator<WeatherStationData> it = queue.values();
        while (it.hasNext()) {
            sum += it.next().getPrecipitation();
        }
        return count > 0 ? sum / count : 0;
    }
}