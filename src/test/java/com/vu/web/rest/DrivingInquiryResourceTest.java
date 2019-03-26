package com.vu.web.rest;

import com.vu.service.impl.DrivingInquiryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class DrivingInquiryResourceTest {

    private MockMvc mockMvc;

    @Mock
    private DrivingInquiryService drivingInquiryService;

    @InjectMocks
    private DrivingInquiryResource drivingInquiryResource;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(drivingInquiryResource)
                .build();
    }

    @Test
    public void getPointLicenseNumberInquiry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/driving/fines/123456/inquiry")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getFineCarInquiry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/driving/fines/123456/inquiry")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}