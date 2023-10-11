package controller;

import dto.ResponseDto;
import dto.WeatherDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.WeatherService;
import service.impl.WeatherServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import static enums.ResponseStatus.OK;

@WebServlet("/api/get/")
public class ApiController extends HttpServlet {

    private final WeatherService weatherService = new WeatherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WeatherDto weather = weatherService.getWeatherByDate(LocalDate.now());
        PrintWriter writer = response.getWriter();
        writer.write(String.valueOf(new ResponseDto<>(OK, weather)));

    }
}
