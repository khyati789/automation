package com.fhlb.cds.maintenance.exceptionexplanation;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnDao;

@RunWith(MockitoJUnitRunner.class)
public class AdvExcptnExplntnDaoTest {

    
    @InjectMocks
    private AdvExcptnExplntnDao advExcptnExplntnDao;
    
    @Mock
    private SessionFactory sessionFactory;
    
    @Test
    public void testAdvExcptnExplntnDao() {
        AdvExcptnExplntnDao advExcptnExplntnDao = new AdvExcptnExplntnDao(sessionFactory);
        assertNotSame("Validate Advance exception explanation dao", advExcptnExplntnDao, new AdvExcptnExplntnDao(sessionFactory));
    }

}
