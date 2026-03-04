package com.jdc.mkt.test;

import static com.jdc.mkt.ConnectionManager.getConnectionWithStrings;
import static com.jdc.mkt.test.UserDetail.getUserFromConsole;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class B_PreparedStatementTest {

	@Test
	void selectByProcedureTest() {
		String sql = "{call selectById(?)}";

		try (var con = getConnectionWithStrings();
				var stmt = con.prepareCall(sql);) {
			stmt.setInt(1, 1);
			var rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.print("ID :" + rs.getInt(1) + "\t");
				System.out.print("Name :" + rs.getString(2) + "\t");
				System.out.println("Gender :" + rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	void selectTest() {
		String sql = "select * from user_tbl";

		try (var con = getConnectionWithStrings(); var stmt = con.prepareStatement(sql);) {

			var rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.print("ID :" + rs.getInt(1) + "\t");
				System.out.print("Name :" + rs.getString(2) + "\t");
				System.out.println("Gender :" + rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	void updateTest() {
		String sql = "update user_tbl set name = ? ,gender = ? where id = ?";

		try (var con = getConnectionWithStrings(); var stmt = con.prepareStatement(sql);) {
			var user = getUserFromConsole();

			/*
			 * java enum index MALE = 0 DB enum index MALE = 1
			 */
			stmt.setInt(3, user.getId());
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getGender().ordinal() + 1);

			int row = stmt.executeUpdate();
			assertEquals(1, row);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	 @Test
	void insertTest() {
		String sql = "insert into user_tbl (name,gender) values(?,?)";

		try (var con = getConnectionWithStrings();
				var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			var user = getUserFromConsole();

			/*
			 * java enum index MALE = 0 DB enum index MALE = 1
			 */
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getGender().ordinal() + 1);

			stmt.executeUpdate();

			var rs = stmt.getGeneratedKeys();

			while (rs.next()) {
				System.out.println("ID : " + rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
