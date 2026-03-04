package com.jdc.mkt.test;

import static com.jdc.mkt.ConnectionManager.getConnectionWithString;
import static com.jdc.mkt.ConnectionManager.getConnectionWithStrings;
import static com.jdc.mkt.test.UserDetail.getUserFromConsole;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class A_StatementTest {
	
	//@Test
	void insertTest() {
		try(var con = getConnectionWithStrings();
			var stmt = con.createStatement()
				){
			var user = getUserFromConsole();
			String sql = "insert into user_tbl (name,gender) values('%s','%s')".formatted(user.getName(),user.getGender());
			int row = stmt.executeUpdate(sql);
			assertEquals(1, row);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	void updateTest() {
		try(var con = getConnectionWithStrings();
			var stmt = con.createStatement()
				){
			var user = getUserFromConsole();		
			String sql = "update user_tbl set name='%s',gender='%s' where id = %d".formatted(user.getName(),user.getGender(),1);
			stmt.executeUpdate(sql);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	void deleteTest() {
		try(var con = getConnectionWithStrings();
			var stmt = con.createStatement()
				){
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void selectTest() {
		try(var con = getConnectionWithStrings();
			var stmt = con.createStatement()
				){
			String sql =  "select * from user_tbl";
			var rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.print(rs.getString("name")+"\t");
				System.out.println(rs.getString("gender"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	void batchUpdateTest() {
		try(var con = getConnectionWithString();
			var stmt = con.createStatement()
				){			
			stmt.addBatch("insert into user_tbl(name,gender) values('SuSu',2)");
			stmt.addBatch("insert into user_tbl(name,gender) values('Sandi',2)");
			stmt.executeBatch();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
