# NOVA-Weather-Project-Public
A Public Version of the NOVA Weather Project repository. Private version has authorization credentials hard-coded in. This is an objviously bad practice, but this was not known at the time. 

<h2> Purpose </h2>
<p> This project was NOVA STEAM Club's attempt to create a project that fully encompassed the entirety of STEM, a project that had never been completed in the past for this organization. The goal was to create a device that would actively track current weather conditions at the Northern Virginia Community College - Manassas Campus and send it to a remote server. Using this data, both mathematical and scientific analysis would be used to draw a prediction of weather conditions in a short period of time (around an hour). </p>
<ul>
  <li><ins>S</ins>cience: The correlation between temperature, humidity, wind speed/direction, and barometric pressure was researched extensively. In the original plan, a formula that roughly estimated their correlation to temperature was to be used. These were never accurate enough, and were dropped.</li>
  <li><ins>T</ins>echnology: Perhaps the most heavily used aspect in this project. Java was the main language used in the development of this, obviously. Additionally, a MySQL Database hosted on Amazon Web Service's RDS was used. This program is intended to be run on an AWS t2.micro EC2 Instance. </li>
  <li><ins>E</ins>ngineering: A weather data collecting box was originally planned to be built, equipped with a thermometer, barometer, and wind vane. The humidty was to be calculated using the other collected measurements. </li>
  <li><ins>M</ins>athematics: The final incarnation of the prediction method includes using a quadratic equation created by three data points, and extrapolating the data point at any given x, in this case, x=1. The formula for creating a quadratic equation from three points was derived using linear algebra. </li>
</ul>

<h2> Problems </h2>
<p> There were three primary problems faced on this project.</p>

<h4> The Weather Box </h4>
<p> The initial plan was to have a device that collected weather data and sent it to a remote server (whether it was AWS or physically owned server stored in the nearby building) with several data collecting devices on board. The goal was to use a Raspberry Pi 3 in a container that had two layers to ensure it was fully weatherproofed. A fan would be used to prevent overheating. The primary issue was power, and cost-effectiveness. Another important objective was to have the entire project be "fire and forget," as in, we would never have to perform maintenence on the physical device. This is where power proved to be an issue, as there were no high locations near the building (or anywhere in several reseaarched locations) that allowed connections to power. This led us to need to look into renewable energy sources, which, did not provide sufficient power (wind turbines and solar panels) for the small scale and were very expensive, to the point where they were outisde of the club's budget. This part of the project was put on hiatus and has been terminated at the time of writing this due to COVID-19. </p>

<h4> Chemical Formulas in Regards to Humidity </h4>
<p> Much research went into attempting to create a formula that correlated air pressure and temperature to the current humidity to relative accuracy. This was not accomplished. The derived formula used the Ideal Gas law, and a formula from Absolute Humidity to Relative Humidity. This formula was found to not be sufficiently accurate, however. </p>

<h4> Forecasting/Extrapolation Techniques </h4> 
<p> As with all software projects from the STEAM Club, we use external packages and imports only when necessary, as the programming and problem solving experience acquired is unparalleled when building the solutions manually. As such, our best methods for prediction/extrapolation came down to Linear Regression or a Quadratic Fit over three points. It was decided that a Quadratic Fit must be better, as they represent a trend better, due to the fluctuating nature of temperatures in a short time period. Obviously, the best option would be to use a sinusoidal function, as they best represent the day/night patterns, but it was found to be too difficult to implement this with the team's current skills. </p>
