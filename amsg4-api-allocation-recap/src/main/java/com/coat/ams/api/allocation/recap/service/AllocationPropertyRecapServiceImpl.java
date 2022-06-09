package com.coat.ams.api.allocation.recap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.coat.ams.api.allocation.recap.entity.AllocationPropertyRecapEntity;
import com.coat.ams.api.allocation.recap.repository.AllocationPropertyRecapRepository;
import com.coat.ams.api.allocation.recap.service.impl.AllocationPropertyRecapService;


@Service
public class AllocationPropertyRecapServiceImpl implements AllocationPropertyRecapService {

	private SimpleJdbcCall simpleJdbcCallRefCursor;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	AllocationPropertyRecapRepository allocationPropertyRecapRepository;
    
	@Override
	public List<AllocationPropertyRecapEntity> findAll() {
		return allocationPropertyRecapRepository.findAll();
	}

	@Override
	public Optional<AllocationPropertyRecapEntity> findById(Long id) {
		return findById(id);
	}

	@Override
	public List<AllocationPropertyRecapEntity> findById(String batchIds, String reportId) {
		
		SqlParameterSource paramaters = new MapSqlParameterSource()
				.addValue("I_batch_ids", batchIds)
				.addValue("I_report", reportId);

		return getAllocPropertyRecapById(paramaters);
	}

	@Override
	public void save(AllocationPropertyRecapEntity recap) {
		allocationPropertyRecapRepository.save(recap);
	}

	@Override
	public void delete(Long id) {
		allocationPropertyRecapRepository.deleteById(id);		
	}
	
	List<AllocationPropertyRecapEntity> getAllocPropertyRecapById(SqlParameterSource paramaters) {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//tlallocdb1.coat.com:1521/dalloc.coat.com");
		dataSource.setUsername("BAS");
		dataSource.setPassword("testalloc");

		jdbcTemplate.setResultsMapCaseInsensitive(true);

		// Convert o_property_cur SYS_REFCURSOR to List<GetAllocPropertyRecap>
		simpleJdbcCallRefCursor = new SimpleJdbcCall(dataSource)
				.withProcedureName("GET_ALLOC_PROPERTY_RECAP")
				.returningResultSet("o_property_cur", BeanPropertyRowMapper.newInstance(AllocationPropertyRecapEntity.class));
		
		Map<String, Object> out = simpleJdbcCallRefCursor.execute(paramaters);
		
		List<AllocationPropertyRecapEntity> allocProperty = castList(out.get("out_refcursor"), AllocationPropertyRecapEntity.class);
		if (allocProperty == null) {
			return new ArrayList<AllocationPropertyRecapEntity>();
		} else {
			return  allocProperty;
		}
		
	}
	
	public static <T> List<T> castList(Object obj, Class<T> clazz)
	{
	    List<T> result = new ArrayList<T>();
	    if(obj instanceof List<?>)
	    {
	        for (Object o : (List<?>) obj)
	        {
	            result.add(clazz.cast(o));
	        }
	        return result;
	    }
	    return null;
	}
}
