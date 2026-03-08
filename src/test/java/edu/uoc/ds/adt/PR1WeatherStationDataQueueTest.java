package edu.uoc.ds.adt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class PR1WeatherStationDataQueueTest {

    PR1WeatherStationDataQueue dataQueue;

    @Before
    public void setUp() {
        dataQueue = new PR1WeatherStationDataQueue();
    }

    @Test
    public void testAddAndPoll() {
        WeatherStationData data1 = new WeatherStationData(LocalDateTime.now(), 20.0, 5.0);
        WeatherStationData data2 = new WeatherStationData(LocalDateTime.now(), 22.0, 0.0);

        dataQueue.add(data1);
        dataQueue.add(data2);

        assertEquals(data1, dataQueue.poll());
        assertEquals(data2, dataQueue.poll());
        assertNull(dataQueue.poll());
    }

    @Test
    public void testAverageCalculations() {
        dataQueue.add(new WeatherStationData(LocalDateTime.now(), 10.0, 2.0));
        dataQueue.add(new WeatherStationData(LocalDateTime.now(), 20.0, 6.0));
        dataQueue.add(new WeatherStationData(LocalDateTime.now(), 30.0, 4.0));

        assertEquals(20.0, dataQueue.averageTemperature(), 0.001);
        assertEquals(4.0, dataQueue.averagePrecipitation(), 0.001);
    }

    @Test
    public void testLoadCSV() throws IOException {
        String filePath = "C:/Users/Sebastian/Documents/UOC/6 Semestre/Diseño y estructura de datos/PR1/DS_PR1/src/test/resources/weatherData.csv";

        dataQueue.loadFromCSV(filePath);

        int size = dataQueue.getQueue().size();
        System.out.println("Queue size after loading CSV: " + size);

        assertTrue("La cola debería contener datos tras cargar CSV", size > 0);
        assertNotNull("El primer elemento no debería ser null", dataQueue.poll());
    }
}