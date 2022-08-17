package com.mobile.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mobile.model.Mobile;
import com.mobile.repository.MobileRepo;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;


@Service
public class MobileServiceImple implements MobileService{
	
	@Autowired
	private MobileRepo mobileRepo;

	@Override
	public void saveMobile(Mobile mobile) {
		this.mobileRepo.save(mobile);
	}

	@Override
	public List<Mobile> getAllMobiles() {
		// TODO Auto-generated method stub
		return (List<Mobile>) mobileRepo.findAll();
	}

	
	@Override
	public Mobile getMobileById(int id) {
		Optional<Mobile> optional = mobileRepo.findById(id);
		Mobile mobile = null;
		if (optional.isPresent()) {
			mobile = optional.get();
		} else {
			throw new RuntimeException(" mobile not found for id :: " + id);
		}
		return mobile;
	}

	

	@Override
	public void deleteMobiById(int id) {
		this.mobileRepo.deleteById(id);
		
	}

	
	}
