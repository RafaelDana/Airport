package rdc.aeroporto;

import java.io.*;
public class Main
{
  private static final String FILE_NAME = "C:/Users/Rafael Dana/OneDrive/Documentos/NetBeansProjects/aeroporto/src/main/java/rdc/aeroporto/TxtTest.txt";
  public static void main(String[] args)
  {
    Airline airline = new Airline();
    Main.readInputFile(FILE_NAME,airline);
  }
  
  Payload Payload;
  
  public static void readInputFile(String fileName, Airline airline)
  {
    try
    {
      FileReader fileRdr = new FileReader(fileName);
      BufferedReader inFile = new BufferedReader(fileRdr);
      try
      {
              
        String line = inFile.readLine();
        while(line != null)
        {
          String [] words = line.split(" ");
          if(line.charAt(0)=='*')
          {

            processComment(line);
          }
          else
          {
            parseCommand(words,airline);

          }
          line = inFile.readLine();
        }
        
      } catch(Exception e)
      {
        
        System.out.println ("Comando Invalido");
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println ("Arquivo nao encontrado.");
    }
  }
  
  
  public static void parseCommand(String [] tokens, Airline air) throws InvalidInputException
  {
    String type = tokens[0];
    
    if (type.equals("CRIAR-VOO"))
    {

      if (tokens[1].equals("I"))
      {
       System.out.println( air.addFlight('I')); 
        
      }
      else if (tokens[1].equals("C"))
      {
            
        System.out.println(air.addFlight('C')) ;
      }
      else{
             
        System.out.println("Comando Invalido");
      }
    }
    else if (type.equals("CON-VOO"))
    {
      
      int numberID = Integer.parseInt(tokens[1]);
      if (air.getFlight(numberID) != null)
      {
        System.out.println(air.getFlight(numberID));
      }
      else
        System.out.println("Comando Invalido");
    }
    /*
    else if (type.equals("CREATE-PAYLOAD"))
    {
      if(tokens[1].equals("C"))
      {
         payloads =  payloadFactory(tokens[1],tokens[2],null,null,null);
      }
      if (tokens[1].equals("P"))
      {
         payloads =  payloadFactory(tokens[1],tokens[2],tokens[3],tokens[4],null);
      }
      if (tokens[1].equals("E"))
      {
         payloads =  payloadFactory(tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
      }
      
    }
    else if (type.equals("GET-PAYLOAD"))
    {
      
    }
      else if (type.equals("ASSIGN-PAYLOAD"))
    {
        book(payloads);
    }*/
    
    else
       System.out.println("Comando Invalido");
  }
  
  public static void processComment(String data)
  {
    boolean start = false;
    String sentence = "";
    for (int i = 0; i <data.length();i++)
    {
      if ((!start) && (data.charAt(i) != '*') )
      {
        start = true;
      }
      if (start)
      {
        sentence = sentence + data.charAt(i);
      }
    }
    System.out.println(sentence);
  }
}