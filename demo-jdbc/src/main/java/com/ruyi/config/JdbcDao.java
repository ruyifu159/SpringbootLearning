/**
 * 
 */
package com.ruyi.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ruyi.entity.RowRecord;


/**
 * @author ruyi 
 * @date 2020年7月9日 下午5:31:49
 *
 */
@Component
public class JdbcDao {
	
	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<RowRecord> executeQuery() {
    	@SuppressWarnings("unused")
		List<Map<String, Object>> userData = jdbcTemplate.queryForList("SELECT * FROM USERINFO");
    	
    	return null;
    }
}
