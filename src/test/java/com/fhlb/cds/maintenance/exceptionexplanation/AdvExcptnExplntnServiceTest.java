package com.fhlb.cds.maintenance.exceptionexplanation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnDB;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnDao;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnMapper;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnResource;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnService;
import com.fhlb.commons.exception.FieldRequiredException;

@RunWith(MockitoJUnitRunner.class)
public class AdvExcptnExplntnServiceTest {

    @InjectMocks
    private AdvExcptnExplntnService advExcptnExplntnService;

    @Mock
    private AdvExcptnExplntnDao advExcptnExplntnDao;

    @Mock
    private AdvExcptnExplntnMapper advExcptnExplntnMapper;



    @Test
    public void testGetAdvExcptnExplntn() {

        List<AdvExcptnExplntnResource> advExcptnExplntnResources = new ArrayList<AdvExcptnExplntnResource>();
        List<AdvExcptnExplntnDB> advExcptnExplntnDB = new ArrayList<AdvExcptnExplntnDB>();
        when(advExcptnExplntnService.getAdvExcptnExplntn()).thenReturn(advExcptnExplntnResources);
        when(advExcptnExplntnDao.getAdvExcptnExplntn()).thenReturn(advExcptnExplntnDB);
        assertEquals(
                "Validate get advance exception explanation",
                advExcptnExplntnService.getAdvExcptnExplntn(),
                advExcptnExplntnResources);

    }
    
    @Test
    public void testGetAdvExcptnExplntnById() {

        AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
        when(advExcptnExplntnService.getAdvExcptnExplntnById(50)).thenReturn(advExcptnExplntnResource);
        assertEquals(
                "Validate get advance exception explanation",
                advExcptnExplntnService.getAdvExcptnExplntnById(50),
                advExcptnExplntnResource);

    }
    
    @Test
	public void testCreateTransactionCode(){
    	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    	AdvExcptnExplntnDB advExcptnExplntnDB = new AdvExcptnExplntnDB();
		advExcptnExplntnDB.setAdvExcptnExplntnDesc("Testing Purpose");
		advExcptnExplntnResource.setAdvExcptnExplntnDesc("Testing Purpose");
		when(advExcptnExplntnDao.createAdvExplntnExcptn(advExcptnExplntnDB)).thenReturn(advExcptnExplntnDB);
		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.createAdvExcptnExplntn(advExcptnExplntnResource), advExcptnExplntnResource);
	}
    
    @Test(expected=FieldRequiredException.class)
	public void testCreateAdvExcptnExplntn1(){
    	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    	AdvExcptnExplntnDB advExcptnExplntnDB = new AdvExcptnExplntnDB();
    	advExcptnExplntnDB.setAdvExcptnExplntnDesc("Testing Purpose");
    	advExcptnExplntnResource.setAdvExcptnExplntnDesc("Testing Purpose");
		
		when(advExcptnExplntnDao.isDuplicate("Testing Purpose")).thenReturn(advExcptnExplntnDB);
		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.createAdvExcptnExplntn(advExcptnExplntnResource), advExcptnExplntnResource);
	}
    
    @Test(expected=FieldRequiredException.class)
	public void testCreateTransactionCode2(){
    	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    	advExcptnExplntnResource.setAdvExcptnExplntnDesc("");
		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.createAdvExcptnExplntn(advExcptnExplntnResource), advExcptnExplntnResource);
	}
    
    @Test(expected=FieldRequiredException.class)
	public void testCreateTransactionCode3(){
    	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    	advExcptnExplntnResource.setAdvExcptnExplntnDesc("1234567890123456789012345678901234567890123456789012345678901");
		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.createAdvExcptnExplntn(advExcptnExplntnResource), advExcptnExplntnResource);
	}
    
    @Test
   	public void testUpdateTransactionCode(int id){
       	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
       	AdvExcptnExplntnDB advExcptnExplntnDB = new AdvExcptnExplntnDB();
   		advExcptnExplntnDB.setAdvExcptnExplntnDesc("Testing Purpose");
   		advExcptnExplntnResource.setAdvExcptnExplntnDesc("Testing Purpose");
   		when(advExcptnExplntnDao.updateAdvExcptnExplntn(advExcptnExplntnDB)).thenReturn(advExcptnExplntnDB);
   		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.updateAdvExcptnExplntn(id,advExcptnExplntnResource), advExcptnExplntnResource);
   	}
    
    @Test(expected=FieldRequiredException.class)
	public void testUpdateAdvExcptnExplntn1(int id){
    	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    	AdvExcptnExplntnDB advExcptnExplntnDB = new AdvExcptnExplntnDB();
    	advExcptnExplntnDB.setAdvExcptnExplntnDesc("Testing Purpose");
    	advExcptnExplntnResource.setAdvExcptnExplntnDesc("Testing Purpose");
		
		when(advExcptnExplntnDao.isDuplicate("Testing Purpose")).thenReturn(advExcptnExplntnDB);
		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.updateAdvExcptnExplntn(id,advExcptnExplntnResource), advExcptnExplntnResource);
	}
    
    @Test(expected=FieldRequiredException.class)
	public void testUpdateTransactionCode2(int id){
    	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    	advExcptnExplntnResource.setAdvExcptnExplntnDesc("");
		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.updateAdvExcptnExplntn(id,advExcptnExplntnResource), advExcptnExplntnResource);
	}
    
    @Test(expected=FieldRequiredException.class)
	public void testUpdateTransactionCode3(int id){
    	AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
    	advExcptnExplntnResource.setAdvExcptnExplntnDesc("1234567890123456789012345678901234567890123456789012345678901");
		assertNotSame("Validate create Exception Explanation", advExcptnExplntnService.updateAdvExcptnExplntn(id,advExcptnExplntnResource), advExcptnExplntnResource);
	}
    
    @Test
    public void testDeleteAdvExcptnExplntn() {

        AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
        when(advExcptnExplntnService.deleteAdvExcptnExplntn(50)).thenReturn(advExcptnExplntnResource);
        assertEquals(
                "Validate get advance exception explanation",
                advExcptnExplntnService.deleteAdvExcptnExplntn(50),
                advExcptnExplntnResource);

    }
    
    @Test
    public void testGetListReportHeader() {
        assertEquals("Validate report header", advExcptnExplntnService.getListReportHeader(),getListReportHeaderDummy());
    }
    
    @Test
    public void testGetReportData() {
        assertTrue("Validate get prepayment fee type report data ",
                advExcptnExplntnService.getReportData().contains("records"));
    }
    
    public Map<String, String> getListReportHeaderDummy() {
        Map<String, String> reportHeaders = new LinkedHashMap<>();
        reportHeaders.put("desc", "Explanation Description");
        return reportHeaders;
    }
    

}
