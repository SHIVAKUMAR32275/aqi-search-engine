function handleEnter(event){
    if(event.key === "Enter"){
        searchAQI();
    }
}

function getRecommendation(aqi){

    if(aqi <= 50)
        return "Air quality is excellent. Enjoy outdoor activities.";

    if(aqi <= 100)
        return "Air quality is acceptable for most people.";

    if(aqi <= 150)
        return "Sensitive individuals should reduce prolonged outdoor exertion.";

    if(aqi <= 200)
        return "Limit outdoor activities and wear protection if necessary.";

    if(aqi <= 300)
        return "Avoid outdoor exposure whenever possible.";

    return "Stay indoors and avoid outdoor activities.";
}

function getAQIColor(aqi){

    if(aqi <= 50) return "#22c55e";
    if(aqi <= 100) return "#eab308";
    if(aqi <= 150) return "#f97316";
    if(aqi <= 200) return "#ef4444";
    if(aqi <= 300) return "#9333ea";

    return "#7f1d1d";
}

async function searchAQI(){

    const city =
        document.getElementById("cityInput").value.trim();

    if(city === ""){
        alert("Please enter a city name");
        return;
    }

    const resultCard =
        document.getElementById("resultCard");

    const errorBox =
        document.getElementById("errorBox");

    const loader =
        document.getElementById("loader");

    resultCard.classList.add("hidden");
    errorBox.classList.add("hidden");
    loader.classList.remove("hidden");

    try{

        const response =
            await fetch(
                `/api/air-quality/city?city=${city}`
            );

        const data =
            await response.json();

        loader.classList.add("hidden");

        if(!response.ok){

            errorBox.innerText =
                data.message;

            errorBox.classList.remove("hidden");

            return;
        }

        document.getElementById("cityName").innerText =
            data.city;

        document.getElementById("aqiValue").innerText =
            data.aqi;

        document.getElementById("aqiStatus").innerText =
            data.status;

        document.getElementById("temperature").innerText =
            data.temperature + " °C";

        document.getElementById("humidity").innerText =
            data.humidity + " %";

        document.getElementById("pollutant").innerText =
            data.dominantPollutant;

        document.getElementById("lastUpdated").innerText =
            data.lastUpdated;

        document.getElementById("recommendation").innerText =
            getRecommendation(data.aqi);

        document.getElementById("aqiCircle").style.background =
            getAQIColor(data.aqi);

        resultCard.classList.remove("hidden");

    }
    catch(error){

        loader.classList.add("hidden");

        errorBox.innerText =
            "Unable to fetch AQI data.";

        errorBox.classList.remove("hidden");
    }
}