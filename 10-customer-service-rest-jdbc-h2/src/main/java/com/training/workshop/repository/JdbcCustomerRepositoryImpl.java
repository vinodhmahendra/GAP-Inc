package com.training.workshop.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.workshop.model.Customer;

//@Repository , Default class name becomes bean name (eg) of bean listCustomerRepositoryImpl
@Repository(value = "customerRepository")
public class JdbcCustomerRepositoryImpl implements CustomerRepository {

	private static String SELECT_ALL = "SELECT * from CUSTOMERS";
	private static String INSERT_SQL = "INSERT INTO CUSTOMERS(ID,FIRSTNAME,LASTNAME,EMAIL) VALUES (?,?,?,?)";
	private static String SELECT_BY_ID = "SELECT * from CUSTOMERS where id = ?";
	private static String DELETE_BY_ID = "DELETE CUSTOMERS where id = ?";
	private static Integer customerCount = 3;
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = jdbcTemplate.query(SELECT_ALL, new CustomerRowMapper());
		return customers;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {

		jdbcTemplate.update(INSERT_SQL, ++customerCount, theCustomer.getFirstName(), theCustomer.getLastName(),
				theCustomer.getEmail());
		return getCustomer(customerCount);
	}

	@Override
	public Customer getCustomer(Integer theId) {
//		return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[] {theId},(rs,rowNum)-> 
//					Optional.of(new Customer(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"),rs.getString("email")))
//				).get();

		return jdbcTemplate.queryForObject(SELECT_BY_ID,
				(rs, rowNum) -> Optional.of(new Customer(rs.getInt("id"), rs.getString("firstname"),
						rs.getString("lastname"), rs.getString("email"))), new Object[] { theId })
				.get();
	}

	@Override
	public void deleteCustomer(Integer theId) {
		jdbcTemplate.update(DELETE_BY_ID, theId);
	}

	public class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer theCustomer = new Customer();
			theCustomer.setId(rs.getInt("ID"));
			theCustomer.setFirstName(rs.getString("FIRSTNAME"));
			theCustomer.setLastName(rs.getString("LASTNAME"));
			theCustomer.setEmail(rs.getString("EMAIL"));
			return theCustomer;
		}

	}

}
