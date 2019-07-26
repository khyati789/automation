package com.fhlb.cds.maintenance.exceptionexplanation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnDB;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnMapper;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnResource;

public class AdvExcptnExplntnMapperTest {

	AdvExcptnExplntnMapper advExcptnExplntnMapper = new AdvExcptnExplntnMapper();
    AdvExcptnExplntnDB advExcptnExplntnDB = new AdvExcptnExplntnDB();
    AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    
    @Test
    public void  testFromResource() {
    	advExcptnExplntnResource.setId(12);
    	advExcptnExplntnResource.setAdvExcptnExplntnDesc("Testing purpose");;
    	
    	assertNotSame(
    	        "validating from resource data",
    	        advExcptnExplntnResource,
    	        advExcptnExplntnMapper.fromResource(advExcptnExplntnResource));
    		}
    
    @Test
    public void  testFromEntity() {
    	advExcptnExplntnDB.setId(12);
    	advExcptnExplntnDB.setAdvExcptnExplntnDesc("Testing purpose");;
   
    assertNotSame(
        "validating from resource data",
        advExcptnExplntnDB,
        advExcptnExplntnMapper.fromEntity(advExcptnExplntnDB));
    }

}
