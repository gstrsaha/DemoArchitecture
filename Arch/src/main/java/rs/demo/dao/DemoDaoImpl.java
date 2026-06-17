package rs.demo.dao;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import rs.demo.model.DemoReq;
@Repository
public class DemoDaoImpl implements DemoDao {
 @Autowired
    private JdbcTemplate jdbcTemplate;
   @Override public String getDataDao(DemoReq demoReq) throws Exception {
     String sql = "SELECT MSG_SRL FROM CTOADMIN.MSG_SEQ WHERE DIR_TYPE = ?"; 
     return jdbcTemplate.queryForObject( sql, String.class, demoReq.getName() );
   }

}
