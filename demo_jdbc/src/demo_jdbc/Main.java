package demo_jdbc;


import demo_jdbc.models.DriverMaxPoint;

import demo_jdbc.models.DriverResult;
import demo_jdbc.respositories.DriverResultRepository;
import demo_jdbc.respositories.QueryRepository;


public class Main {

	public static void main(String[] args) {
		
		DriverResultRepository driverResultRepository = new DriverResultRepository();
		var results = driverResultRepository.getResultByYear(1998);
		
		for(DriverResult rs: results) {
			System.out.println(rs.getDriverName() + "\t" + rs.getWins() + "\t"+ rs.getTotalPoints() + "\t"+ rs.getRank());
		}
		
		QueryRepository queryRepository = new QueryRepository();
		var results1 = queryRepository.getConstructorsMaxPoints();
		System.out.println("\n\n");
		for(DriverMaxPoint rs: results1) {
			System.out.println(rs.getDriverName() + "\t" + rs.getPoints());
		}
		
		
//		QueryRepository queryRepository = new QueryRepository();
//		var results1 = queryRepository.getDriversMaxPoints();
//		System.out.println("\n\n");
//		for(DriverMaxPoint rs: results1) {
//			System.out.println(rs.getDriverName() + "\t" + rs.getPoints());
//		}
		
		
//		CircuitRepository circuitRepository = new CircuitRepository();
//				
//		var circuits = circuitRepository.getCircuits();
//		
//		
//		System.out.println("Total circuitos: " + circuits.size());
//		
//		String country = "Russia";
//		
//		var circuitsByCountry = circuitRepository.getCircuitsByCountry(country);
//		
//		System.out.println("Circuitos de " + country);
//		
//		for(Circuit circuit:circuitsByCountry) {
//			System.out.println(circuit.getName() + "\t" + circuit.getLocation() + "\t"+ circuit.getCountry());
//		}
		
		
//		String jdbcUrl = "jdbc:postgresql://localhost:5432/formula1";
//		String user = "postgres";
//		String password = "123";
//		
//		List<Circuit> circuits = new ArrayList();
//		
//		try {
//			// Establecer la conexion
//			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
//			System.out.println("Se conecto a la base de datos");
//			
//			// Crear una sentencia
//			Statement statement = conn.createStatement();
//			
//			// Ejecutar la consulta
//			String sql = "SELECT * FROM circuits";
//			ResultSet rs = statement.executeQuery(sql);
//			
//			// Procesar los resultados
//			while(rs.next()) {
//				int circuitid = rs.getInt("circuitid");
//				String circuitref = rs.getString("circuitref");
//				String name = rs.getString("name");
//				String location = rs.getString("location");
//				String country = rs.getString("country");
//				
//				Circuit circuit = new Circuit(circuitid, circuitref, name, location, country);
//				circuits.add(circuit);
//				
//				// System.out.println(circuitid + "\t" + circuitref + "\t"+ name + "\t" + location + "\t" + country);
//				
//			}
//			
//			
//			
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		
		
		
		
	}

}
