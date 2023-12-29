//package com.app.repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.couchbase.core.CouchbaseOperations;
//import org.springframework.data.couchbase.repository.query.CouchbaseEntityInformation;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import com.app.model.Employee;
//import com.couchbase.client.java.query.QueryScanConsistency;
//
//public class EmployeeRepositoryImpl implements EmployeeRepository {
//
//	@Override
//	public List<Employee> findAll(Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Employee> findAll(QueryScanConsistency queryScanConsistency) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Employee> findAllById(Iterable<String> iterable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CouchbaseEntityInformation<Employee, String> getEntityInformation() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CouchbaseOperations getOperations() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<Employee> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Employee> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Employee> findById(String id) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
//
//	@Override
//	public boolean existsById(String id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void deleteById(String id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(Employee entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends String> ids) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Employee> entities) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//
//	}
//
//}
