package com.bit.servlet.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bit.servlet.model.AddressbookVo;
public class AddressbookDaoOrclImpl implements AddressbookDao {
		//	커넥션 메서드
		private Connection getConnection() throws SQLException {
			Connection conn = null;
			
			try {
				//	드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
				//	드라이버 매니저 -> 접속 얻어오기
				conn = DriverManager.getConnection(dburl, "C##SUMIN", "1234");
			} catch (ClassNotFoundException e) {
				System.err.println("드라이버 로딩 실패");
				e.printStackTrace();
			}
			
			return conn;
		}
		
		@Override
		public List<AddressbookVo> getList() {
			List<AddressbookVo> list = new ArrayList<>();
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT no, name, cell_phone, home_phone " ;
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					String cell_phone = rs.getString(3);
					String home_phone = rs.getString(4);
					
					
					AddressbookVo vo = new AddressbookVo(no, name, cell_phone, home_phone);
					//	리스트에 추가
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//	자원 정리
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception e) {}
			}
			return list;
		}

		@Override
		public int insert(AddressbookVo vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int insertedCount = 0;
			
			try {
				conn = getConnection();
				String sql = "INSERT INTO Addressbook " +
						"VALUES(seq_emaillist_pk.NEXTVAL, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getcell_phone());
				pstmt.setString(3, vo.gethome_phone());
				
				insertedCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return insertedCount;
		}

		@Override
		public int delete(Long no) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int deletedCount = 0;
			
			try {
				conn = getConnection();
				String sql = "DELETE FROM addressbook " +
						"WHERE no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, no);
				
				deletedCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return deletedCount;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		public List<AddressbookVo> search (String a) {
			List<AddressbookVo> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				String sql = "SELECT no, name, cell_phone, home_phone " +
						     "WHERE name like = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(2, "%"+a+"%");
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					String cell_phone = rs.getString(3);
					String home_phone = rs.getString(4);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch(Exception e ) {
					e.printStackTrace();
				}
			}
			
			return list;
		}

	}
