package DataImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entity.Data;
import entity.DataResult;
import Datainterface.DataInterface;

public class DataImpl implements DataInterface {

	private static final String JPA_UNIT_NAME = "product_filtre";

	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
	
	@Override
	public Data getData(int id_data) {
		return getEntityManager().find(Data.class, id_data);
	}

	@Override
	public List<Data> getAllData() {
		List<Data> data = getEntityManager().createQuery(
				"select p from Data p").getResultList();
		return data;
	}

	@Override
	public DataResult addData_result(DataResult data) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(data);
		getEntityManager().getTransaction().commit();
		return data;
	}

	@Override
	public DataResult updateData_result(DataResult data) {
		getEntityManager().getTransaction().begin();
		data = getEntityManager().merge(data);
		getEntityManager().getTransaction().commit();
		return data;
	}

	@Override
	public DataResult getData_result(int id_data) {
		return getEntityManager().find(DataResult.class, id_data);
	}

	@Override
	public List<DataResult> getAllData_result() {
		List<DataResult> data = getEntityManager().createQuery(
				"select p from DataResult p").getResultList();
		return data;
	}

	
	


}
