package com.koko.springboot.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {
	private final JdbcTemplate template;

	@Autowired
	public CarRepository(JdbcTemplate template) {
		this.template = template;
	}

	public List<Car> findByMakeIgnoringCase(String make) {

		return template.query("select * from car where UPPER(car.make) = UPPER(?) order by id",
				(rs, i) -> new Car(rs.getLong("id"), rs.getString("make"), rs.getString("model"), rs.getInt("year")),
				make);
	}

}
