package com.mobile.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.mobile.model.Mobile;

public interface MobileRepo extends CrudRepository<Mobile, Integer>{
	
	

}
