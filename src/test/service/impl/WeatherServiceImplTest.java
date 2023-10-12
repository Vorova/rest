package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.WeatherDao;
import dto.WeatherDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith({
        MockitoExtension.class
})
class WeatherServiceImplTest {

    @Mock
    ObjectMapper mapper;

    @Mock
    WeatherDao weatherDao;

    @InjectMocks
    WeatherServiceImpl weatherService;

    /**
     * Попытка получения запроса на сторонний сервис с null датой
     * должна сгенерировать NullPointerException
     */
    @Test
    @DisplayName("send request will date is null")
    void getWeatherByDateNegativeTest() {
        assertThatThrownBy(()->{
            weatherService.getWeatherByDate(null);
        }).isInstanceOf(NullPointerException.class);
    }

    /**
     * При попытке получения погоды по дате на конкретный день <br>
     * должен произойти вызов weatherDao.getWeatherByDate(LocalDate date) <br>
     * и mapper.readValue();
     */
    @Test
    @DisplayName("verify callbacks when calling getWeatherByDate")
    void getWeatherByDatePositiveTest() throws JsonProcessingException {
        String REQUEST_API_RESULT = "Return String";
        LocalDate DATE = LocalDate.now();
        WeatherDto weatherDto = new WeatherDto();

        Mockito.when(weatherDao.getWeatherByDate(DATE)).thenReturn(REQUEST_API_RESULT);
        Mockito.when(mapper.readValue(REQUEST_API_RESULT, WeatherDto.class))
                .thenReturn(weatherDto);

        weatherService.getWeatherByDate(DATE);

        Mockito.verify(weatherDao).getWeatherByDate(Mockito.any());
        Mockito.verify(mapper).readValue(REQUEST_API_RESULT, WeatherDto.class);
    }

    /**
     * При попытке получения погоды по дате на несколько дней <br>
     * должны произойти вызовы weatherDao.getWeatherByDays(int days) <br>
     * и mapper.readValue()
     */
    @Test
    @DisplayName("verify callbacks when calling getWeatherForDays")
    void getWeatherForDaysPositiveTest() throws JsonProcessingException {
        String REQUEST_API_RESULT = "Return String";
        int DAYS = 2;
        WeatherDto weatherDto = new WeatherDto();

        Mockito.when(weatherDao.getWeatherForDays(DAYS)).thenReturn(REQUEST_API_RESULT);
        Mockito.when(mapper.readValue(REQUEST_API_RESULT, WeatherDto.class))
                .thenReturn(weatherDto);

        weatherService.getWeatherForDays(DAYS);

        Mockito.verify(weatherDao).getWeatherForDays(DAYS);
        Mockito.verify(mapper).readValue(REQUEST_API_RESULT, WeatherDto.class);
    }
}