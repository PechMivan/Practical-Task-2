### Practical Task 2 - Medium level complexity

## Installation

Clone the project and extract it. Some configurations are needed as follow:

**Configure the applications.properties**
   - If you just want to run the application you need to configure DataSource settings.
   - If you want to run analysis too, change SonarQube configuration.

## Usage

Run the application and connect to http://localhost:8080 there you will see 
a welcome html and some extra actions to perform such as retrieve, save and see weather data.

This app admits different types of queries (city names and zip code for US preferred):

Latitude and Longitude (Decimal degree) e.g: q=48.8567,2.3508
city name e.g.: q=Paris
US zip e.g.: q=10001
UK postcode e.g: q=SW1

and some extra: visit https://www.weatherapi.com/docs/ for more information!

## SonarQube Analysis

![image](https://github.com/PechMivan/Practical-Task-2/assets/97990963/343bdecd-99f4-45d4-bece-da0f2d5a84c4)

## Feedback

- Was it easy to complete the task using AI?

  A bit complex due to my inexperience with testing.
  
- How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics)

  5 hours, because I had some trouble with tests, but it was my fault.
  
- Was the code ready to run after generation? What did you have to change to make it usable?

 Most of it, yes. I actually needed to add some data for the objects needed for test and some other details.
  
- Which challenges did you face during completion of the task?

Testing, I needed to verify everything was correct.

- Which specific prompts you learned as a good practice to complete the task?

I had a bit of trouble this time because I didn't follow an order like before. It's useful to remember ChatGPT about
something specific in the past or point out something you're specially interested in from the past context.
   
