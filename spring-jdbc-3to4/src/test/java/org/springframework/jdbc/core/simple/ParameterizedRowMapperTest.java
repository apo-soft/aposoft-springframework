/**
 * 
 */
package org.springframework.jdbc.core.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

/**
 * ParameterizedRowMapper 对象测试用例
 * 
 * @author LiuJian
 * 
 */
public class ParameterizedRowMapperTest {
	private RowMapper<Person> personMapper;

	private final String name = "lili";

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	private ResultSet getMockResultSet() throws SQLException {
		ResultSet rs;
		final int index = 1;
		rs = mock(ResultSet.class);
		when(rs.getString(index)).thenReturn(name);
		return rs;
	}

	/**
	 * 初始化
	 * 
	 * @throws SQLException
	 */
	@Before
	public void initialize() {
		personMapper = new ParameterizedRowMapper<Person>() {
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p = new Person();
				p.setName(rs.getString(1));
				return p;
			}
		};
	}

	/**
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testRowMappper() throws SQLException {
		try {
			// 构造测试数据
			final ResultSet rs = getMockResultSet();
			final int rownum = 1;
			// 执行步骤 : 传入 模拟的Rs, 返回人Person对象
			Person person = personMapper.mapRow(rs, rownum);
			// 验证结果 : 返回的名字 == lili
			assertEquals(name, person.getName());
		} catch (SQLException e) {
			fail();
		}
	}

	// 测试用例bean
	private class Person {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
