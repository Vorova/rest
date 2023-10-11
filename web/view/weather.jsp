<jsp:useBean id="weather" scope="request" type="dto.WeatherDto"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Прогноз погоды</title>
</head>
<body>
<style>
    body{
        margin: 0;
        padding: 0;
    }
    .location{
        padding: 20px;
        weight: 100%;
        vertical-align: center;
        text-align: center;
        font-weight: bold;
        background: bisque;
        color: dimgray;
    }
    .weather{
        padding: 20px;
    }
    .day_weather{
        background: beige;
        margin: 15px;
        padding: 15px;
    }
</style>
<div class="location">${weather.location.tz_id} ${weather.location.country}, ${weather.location.region} <br>
    Local time: ${weather.location.localtime}</div>
<div class="weather">
    <c:forEach var="day" items="${weather.forecastDto.forecastDayDto}">
        <div class="day_weather">
            Day: ${day.date} :
            min temp: <c:out value="${day.dayDto.mintemp_c}"/>
            max temp: <c:out value="${day.dayDto.maxtemp_c}"/>
            avg temp: <c:out value="${day.dayDto.avgtemp_c}"/>
            <hr>
            <span>By time:</span><br>
            <c:forEach var="hour" items="${day.hours}">

                 ${hour.time} : ${hour.temp_c} <br/>
            </c:forEach>
        </div>
    </c:forEach>
</div>

</body>
</html>