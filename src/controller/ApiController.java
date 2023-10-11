package controller;

import dto.WeatherDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.WeatherService;
import service.impl.WeatherServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/get")
public class ApiController extends HttpServlet {

    private final WeatherService weatherService = new WeatherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int days;
        WeatherDto weather;

        try {
            days = Integer.parseInt(request.getParameter("d"));
        } catch (NumberFormatException e){
            days = 0;
        }

        weather = days != 0 ?
                weatherService.getWeatherForDays(days) :
                weatherService.getWeatherByDate(LocalDate.now());

        getServletContext().setAttribute("weather", weather);
        request.setAttribute("weather", weather);
        request.getRequestDispatcher("/view/weather.jsp").forward(request, response);
    }
}
