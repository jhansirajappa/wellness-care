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

import com.ty.wellness_care.controller.BranchController;
import com.ty.wellness_care.dao.BranchDao;
import com.ty.wellness_care.dto.Branch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BranchControllerTest {

	@Autowired
	private BranchController controller;

	@MockBean
	private BranchDao dao;

	@Test
	public void saveBranchTest() {

		Branch branch = new Branch();
		when(dao.saveBranch(branch)).thenReturn(branch);
		assertEquals(branch, controller.saveBranch(branch).getBody().getData());
	}

	@Test
	public void getBranchByIdTest() {

		Branch branch = new Branch();
		when(dao.getBranchById(1)).thenReturn(branch);
		assertEquals(branch, controller.getBranchById(1).getBody().getData());

	}

	@Test
	public void getAllBranchTest() {
		List<Branch> branchs = new ArrayList<Branch>();
		Branch branch1 = new Branch();
		Branch branch2 = new Branch();
		Branch branch3 = new Branch();
		branchs.add(branch1);
		branchs.add(branch2);
		branchs.add(branch3);

		when(dao.getAllBranch()).thenReturn(branchs);
		assertEquals(3, controller.getAllBranch().getBody().getData().size());
	}

	@Test
	public void updateBranchTest() {

		Branch branch = new Branch();
		when(dao.updateBranch(1, branch)).thenReturn(branch);
		assertEquals(branch, controller.updateBranch(branch, 1).getBody().getData());
	}
	

	@Test
	public void getBranchByHospitalTest() {

		List<Branch> branchs = new ArrayList<Branch>();
		Branch branch1 = new Branch();
		Branch branch2 = new Branch();
		Branch branch3 = new Branch();
		branchs.add(branch1);
		branchs.add(branch2);
		branchs.add(branch3);
		when(dao.getBranchByHospital(1)).thenReturn(branchs);
		assertEquals(branchs, controller.getBranchByHospital(1).getBody().getData());

	}

	@Test
	public void deleteBranchTest() {

		boolean b = true;
		String del="Branch deleted";
		when(dao.deleteBranch(1)).thenReturn(b);
		assertEquals(del, controller.deleteBranch(1).getBody().getData());

	}

}
