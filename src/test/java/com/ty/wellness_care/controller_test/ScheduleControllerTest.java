package com.ty.wellness_care.controller_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.wellness_care.controller.ScheduleController;
import com.ty.wellness_care.dao.ScheduleDao;
import com.ty.wellness_care.dto.Schedule;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleControllerTest {

	@MockBean
	private ScheduleController controller;
	@Autowired
	private ScheduleDao dao;

	@Test
	public void saveScheduleTest() {

		Schedule schedule = new Schedule();
		when(dao.saveSchedule(schedule)).thenReturn(schedule);
		assertEquals(schedule, controller.saveSchedule(schedule).getBody().getData());

	}
	
	@Test
	public void updateScheduleTest() {
		Schedule schedule = new Schedule();
		when(dao.updateSchedule(1,schedule)).thenReturn(schedule);
		assertEquals(schedule, controller.updateSchedule(schedule,1).getBody().getData());
	}
	
	@Test
	public void getAllSchedules() {
		List<Schedule> schedules = new ArrayList<Schedule>();
		Schedule schedule1 = new Schedule();
		Schedule schedule2 = new Schedule();
		Schedule schedule3 = new Schedule();
		
		schedules.add(schedule1);
		schedules.add(schedule2);
		schedules.add(schedule3);
		
		when(dao.getAllSchedules()).thenReturn(schedules);
		assertEquals(3, controller.getAllSchedules().getBody().getData().size());
	}
	
	@Test
	public void getScheduleByIdTest() {
		Schedule schedule = new Schedule();
		when(dao.getScheduleById(1)).thenReturn(schedule);
		assertEquals(schedule, controller.getScheduleById(1).getBody().getData());	
	}
	
	@Test
	public void deleteScheduleTest() {

		boolean b = true;
		String del = "Schedule Deleted";
		when(dao.deleteSchedule(1)).thenReturn(b);
		assertEquals(del, controller.deleteSchedule(1).getBody().getData());

	}
}