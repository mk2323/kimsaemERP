package ktds.secure.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class SQLInjectionTestDAO {
	public String sqlInjection(String id,String pass){
		System.out.println("dao"+id+pass);
		StringBuffer  result=new StringBuffer();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql =
				"select * from member where id='"+id +"' and pass='"+pass+"'";
		try{
			con = DBUtil.getConnect();	
			stmt = con.createStatement();
			/*stmt.setString(1,id);
			stmt.setString(2,pass);*/
			rs = stmt.executeQuery(sql);
   		    if ( rs.next() ) {
   		    	System.out.println("if내부");
			       result.append("ID: "+rs.getString(1));
			       result.append("    PASSWORD: "+rs.getString(2));
			}
   		    System.out.println(result);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{ 
			DBUtil.close(rs, stmt, con);
		}
		return result.toString();
	}
}
