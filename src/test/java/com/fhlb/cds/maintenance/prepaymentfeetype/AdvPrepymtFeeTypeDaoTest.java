package com.fhlb.cds.maintenance.prepaymentfeetype;

import static org.junit.Assert.*;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeDao;


@RunWith(MockitoJUnitRunner.class)
public class AdvPrepymtFeeTypeDaoTest {

    @InjectMocks
    private AdvPrepymtFeeTypeDao advPrepymtFeeTypeDao;

    @Mock
    private SessionFactory sessionFactory;
    
    @Test
    public void testAdvPrepymtFeeTypeDao() {
    	AdvPrepymtFeeTypeDao advPrepymtFeeTypeDao = new AdvPrepymtFeeTypeDao(sessionFactory);
        assertNotSame(
                "validating instance of AdvPrepymtFeeTypeDao",
                advPrepymtFeeTypeDao,
                new AdvPrepymtFeeTypeDao(sessionFactory));
    }
    
}
