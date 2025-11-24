package com.employeepayroll.service.impl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.employeepayroll.config.ModelMapperConfig;
import com.employeepayroll.dto.AllowancesDTO;
import com.employeepayroll.entity.Allowances;
import com.employeepayroll.exception.RecordNotFoundException;
import com.employeepayroll.repository.AllowancesRepository;
import com.employeepayroll.service.AllowanceService;

@Service
public class AllowanceServiceImpl implements AllowanceService {

	
	@Autowired
    private final ModelMapper modelMapper;

	@Autowired
	private AllowancesRepository allowanceRepository;
	
	private final static Logger log=LoggerFactory.getLogger(AllowanceServiceImpl.class);

    AllowanceServiceImpl(ModelMapper modelMapper, ModelMapperConfig modelMapperConfig) {
        this.modelMapper = modelMapper;
    }

	public ResponseEntity<String> addAllowance(AllowancesDTO allowances) {
		// TODO Auto-generated method stub
		Allowances allowance = modelMapper.map(allowances,Allowances.class);
		log.debug("Request body: {}",allowances);
		allowanceRepository.save(allowance);
		return new ResponseEntity<>("Allowances Created", HttpStatus.CREATED);
	}

	public AllowancesDTO getAllowance(Long id) {
		// TODO Auto-generated method stub
		log.info("Allowance id received");
		Allowances allowance= allowanceRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Allowance id=" + id + " not found"));
		
		log.debug("allowence id founded successfully {}"+allowance);
		return modelMapper.map(allowance, AllowancesDTO.class);
	}

	public ResponseEntity<String> updateAllowance(Long id, AllowancesDTO update) {
		// TODO Auto-generated method stub
		Allowances allowance = modelMapper.map(update, Allowances.class);
		Allowances findAllowence = allowanceRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Allowence id=" + id + " not found"));
		log.info("allowance id founded");
		findAllowence.setName(allowance.getName());
		findAllowence.setAmountType(allowance.getAmountType());
		findAllowence.setValue(allowance.getValue());
		allowanceRepository.save(findAllowence);
		log.info("allowance updated successfully");
		return new ResponseEntity<>("Allowence Updated", HttpStatus.OK);
	}

	public ResponseEntity<String> deleteAllowance(Long id) {
		// TODO Auto-generated method stub
		log.info("allowence id received");
		allowanceRepository.deleteById(id);
		return new ResponseEntity<>("Allowance Deleted", HttpStatus.OK);
	}

}
