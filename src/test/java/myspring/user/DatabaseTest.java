package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
public class DatabaseTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	void mybatis() {
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}
	
	@Test
	void conn() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name = " + metaData.getDatabaseProductName());
			System.out.println("DB Url = " + metaData.getURL());
			System.out.println("DB Username = " + metaData.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
