# SpringBootFleetApp

Tasks:

1. Adding a new vehicle to the fleet.

A vehicle may have following properties:
• Passenger capacity
• Range (how many kilometers can it travel with a full tank/charge)
• Fuel (gasoline; mild hybrid; pure electric)

2. Provide a suggestion for assigning vehicles to a trip.

Here we get the number of passengers and the distance as parameters. Based on this the application should
list all the combinations based on the available vehicles. For each such suggestion the application should
compute the assumed profit and show it to help the dispatcher assigning vehicles to the trip.
Before the route, all the vehicles are fully fueled/charged. We cannot stop for tanking/charging during a trip.
After the trip the vehicles are always going to be refueled for the maximum. Approaching the gas station is
considered immediate.
What does the profit consist of?
• Travel fee: Every customer pays €2 for every kilometer traveled – plus another €2 for every half hour
started
• Refueling: After every trip, we fill the tank. This costs €2 per kilometer traveled for gasoline and €1 for
electric drive
Note: The part of the trips under 50 km mostly takes place in the city, here every kilometer traveled should be
calculated as taking 2 minutes, while from 50 km onwards, a kilometer traveled takes 1 minute. Similarly, for
city trips (which we can consider as the part of the trips under 50 km) for hybrid cars, the remaining range
should only decrease by 1 km after every second kilometer traveled.
 
