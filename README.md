# Conductores-con-mas-puntos-ganados

## Descripción
Este proyecto es una aplicación Java que utiliza JDBC para interactuar con una base de datos y mostrar estadísticas de la Fórmula 1. La aplicación permite consultar resultados de carreras, circuitos, temporadas y mostrar a los conductores con más puntos ganados.

## Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes:
- `demo_jdbc.models`: Contiene las clases de modelo de datos.
- `demo_jdbc.repositories`: Contiene las clases de repositorio que manejan las operaciones de base de datos.

## Requisitos
- Java SE 17
- JDBC Driver para tu base de datos (por ejemplo, MySQL, PostgreSQL)
- Eclipse IDE

## Configuración del Proyecto
1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/tu_usuario/demo_jdbc.git
    ```

2. Importa el proyecto en Eclipse:
    - Abre Eclipse y selecciona `File > Import`.
    - Selecciona `Existing Projects into Workspace` y haz clic en `Next`.
    - Navega a la carpeta donde clonaste el repositorio y selecciona el proyecto `demo_jdbc`.
    - Haz clic en `Finish`.

3. Configura la conexión a la base de datos:
    - Asegúrate de tener el driver JDBC en tu classpath. Puedes agregarlo al proyecto en Eclipse haciendo clic derecho en el proyecto, seleccionando `Build Path > Add External Archives` y seleccionando el archivo JAR del driver JDBC.
    - Edita el archivo `QueryRepository.java` para proporcionar la URL, el usuario y la contraseña de tu base de datos.

## Ejecución del Proyecto
Para ejecutar el proyecto y mostrar a los conductores con más puntos ganados, sigue estos pasos:

1. Abre la clase `Main.java` en el paquete `demo_jdbc`.

2. Asegúrate de que el método `getDriversMaxPoints` en la clase `QueryRepository` esté implementado correctamente:
    ```java
    public List<DriverMaxPoint> getDriversMaxPoints() {
        List<DriverMaxPoint> maxPointsDrivers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(yourDbUrl, yourDbUser, yourDbPassword);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT driver_name, SUM(points) as total_points FROM driver_results GROUP BY driver_name ORDER BY total_points DESC";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String driverName = rs.getString("driver_name");
                int points = rs.getInt("total_points");
                maxPointsDrivers.add(new DriverMaxPoint(driverName, points));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxPointsDrivers;
    }
    ```

3. Ejecuta la aplicación:
    - Haz clic derecho en `Main.java` y selecciona `Run As > Java Application`.

4. La salida mostrará los conductores con más puntos ganados en la consola de Eclipse.

## Clases Principales

### Main.java
```java
package demo_jdbc;

import demo_jdbc.models.DriverMaxPoint;
import demo_jdbc.repositories.QueryRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueryRepository queryRepository = new QueryRepository();
        List<DriverMaxPoint> results = queryRepository.getDriversMaxPoints();

        System.out.println("Conductores con más puntos ganados:");
        for (DriverMaxPoint rs : results) {
            System.out.println(rs.getDriverName() + "\t" + rs.getPoints());
        }
    }
}
