package rdc.aeroporto;

import java.util.ArrayList;
public class Airline {
  ArrayList<Payload> payloads = new ArrayList<Payload>();
  ArrayList<Flight> flights = new ArrayList<Flight>();
  
  public Airline()
  {
  }
  
  public String addFlight(char type) throws InvalidInputException
  {
    if (type == 'I')
    {
      Flight flight = new Industrial();
      flights.add(flight);
      return (flight.toString());
    }
    else if (type == 'C')
    {
      Flight flight = new Commercial();
      flights.add(flight);
      return (flight.toString());
    }
    else
      throw new InvalidInputException ("Entrada Invalida"); 
  }
  
  public Flight getFlight(int id)
  {
    
    for (int i = 0; i< flights.size();i++)
    {
      if(flights.get(i).id == id)
      {
        return flights.get(i);
      }
    }
    return null;
  }
  
  public void addPayload (Payload thePayload)
  {
    payloads.add(thePayload);
  }
  
  public Payload getPayload(int id)
  {
    for (int i = 0;i<payloads.size();i++)
    {
      if(payloads.get(i).id == id)
        return payloads.get(i);
    }
    return null;
  }
}


