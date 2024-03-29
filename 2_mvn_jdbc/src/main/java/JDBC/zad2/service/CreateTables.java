package JDBC.zad2.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
		
		private final String createTableOrdersSql = "CREATE TABLE Orders (id bigint GENERATED BY DEFAULT AS IDENTITY, ClientDetails_id bigint, DeliveryAddress_id bigint)";
		private final String createTableClientDetailsSql = "CREATE TABLE ClientDetails (id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(50), surname varchar(50), login varchar(50))";
		private final String createTableAddressSql = "CREATE TABLE Address (id bigint GENERATED BY DEFAULT AS IDENTITY, street varchar(50), buildingNumber varchar(50), flatNumber varchar(50), postalCode varchar(50), city varchar(50), country varchar(50))";
		private final String createTableOrderItemSql = "CREATE TABLE OrderItem (id bigint GENERATED BY DEFAULT AS IDENTITY, Order_id bigint, item varchar(150), description varchar(900), price float)";

	
		private Connection connection;
		private ResultSet rs;
		private Statement statement;
		
		public CreateTables(Connection connection) {
			this.connection = connection;
		}
		
		
		private void createTable(String createTableSql) {
				try {
				statement = connection.createStatement();
				statement.executeUpdate(createTableSql);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				
		}
		
		
		private boolean checkIfTableExist (String tableName) {
			try {
				
				rs = connection.getMetaData().getTables(null, null, null, null);
				boolean tableExists = false;
				
				while (rs.next()) {
					if (tableName.equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
						tableExists = true;
						break;
					}
				}
			return tableExists;
				
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public CreateTables createTableOrders() {
			if (!checkIfTableExist ("Orders")) {
				createTable(createTableOrdersSql);
			}
			return this;
		}
		
		public CreateTables createTableClientDetails() {
			if (!checkIfTableExist ("ClientDetails")) {
				createTable(createTableClientDetailsSql);
			}
			return this;
		}
		
		public CreateTables createTableAddress() {
			if (!checkIfTableExist ("Address")) {
				createTable(createTableAddressSql);
			}
			return this;
		}
		
		public CreateTables createTableOrderItem() {
			if (!checkIfTableExist ("OrderItem")) {
				createTable(createTableOrderItemSql);
			}
			return this;
		}
		
}
