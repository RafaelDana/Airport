package rdc.aeroporto;

public class MainTest {
	public static void main(String [] args) {
		
		Airline airline = new Airline();
		Main.readInputFile("C:/Users/Rafael Dana/OneDrive/Documentos/NetBeansProjects/aeroporto/src/main/java/rdc/aeroporto/TxtTest.txt", airline);
		
		
		Airline airline2 = new Airline();
		try {
			System.out.println("Voo Comercial 100000003 tem um payload de 0 = ");
			System.out.println(airline2.addFlight('C'));
			System.out.println("Voo Industrial 200000004 tem um payload de 0 = ");
			System.out.println(airline2.addFlight('I'));
		} catch (InvalidInputException e) {
			System.out.println("Não roda!");
		}
		
		System.out.println(airline2.getFlight(100000003));
		
		//nulo:
		System.out.println(airline2.getFlight(100000000));
		System.out.println("Voo Comercial 100000000 tem um payload de 0 = ");
		System.out.println(airline.getFlight(100000000));
		
	}

}
