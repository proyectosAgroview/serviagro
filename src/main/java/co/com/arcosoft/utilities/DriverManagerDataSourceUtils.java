package co.com.arcosoft.utilities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DriverManagerDataSourceUtils {
  
  @Autowired
  private static DriverManagerDataSource datasource;

  
	public static DriverManagerDataSource getDatasource() {
		datasource = new DriverManagerDataSource();
		datasource.setUsername("arcosoft");
		datasource.setPassword("arcosoft");
		datasource.setUrl("jdbc:mariadb://localhost:3306/agroviewserviagromaq");
		datasource.setDriverClassName("org.mariadb.jdbc.Driver");
		return datasource;
	}


}
