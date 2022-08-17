package com.mobile.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mobile.model.Mobile;

public interface MobileService {
	
	
	void saveMobile(Mobile mobile);
	List<Mobile> getAllMobiles();
	Mobile getMobileById(int id);
	
	void deleteMobiById(int id);
	
	
}
