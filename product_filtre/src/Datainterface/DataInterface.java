package Datainterface;

import java.util.List;

import entity.Data;
import entity.DataResult;


public interface DataInterface {

	public Data getData(int id_data);
	public List<Data> getAllData();
	
	public DataResult addData_result(DataResult data);
	public DataResult updateData_result(DataResult data);
	public DataResult getData_result(int id_data);
	public List<DataResult> getAllData_result();
}
