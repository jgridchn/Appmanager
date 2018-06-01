package net.busniess.jg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.common.jg.APPMethod;
import net.db.jg.DB;
import net.entity.jg.YamlUtil;
import net.init.jg.StartApp;

import org.testng.Assert;


public class Check_car {
	private static String type_value;
	
	public static void car(){
		
		YamlUtil myYaml = new YamlUtil(StartApp.driver, "./src/Car.yaml");
		APPMethod.clickElement(myYaml.getElement("Green_check"));
		APPMethod.clickElement(myYaml.getElement("Licence_color"));
		APPMethod.clickElement(myYaml.getElement("Licence_color_sl"));
		
		String car_Test=APPMethod.AquireTest(myYaml.getElement("Illegal_text"));
		
		String car_number= car_Test.split("近60天有")[1].split("次违规")[0];
		
		Assert.assertEquals(car_number, check());
	
		
		
		
	}

	public static String check( ){
		
		
		Connection conn = DB.getConn();
		Statement stmt =  DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, "SELECT *FROM vehicle_water245000   ORDER BY vw.n_date desc LIMIT 1;");
		try {
			while (rs.next()) {
			 type_value = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return type_value;
		
		
		
		
		
	}

}
