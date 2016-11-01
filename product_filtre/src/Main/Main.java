package Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import entity.DataResult;
import DataImpl.DataImpl;

public class Main {

	public static String getUniqueString(String text) {
		String data = "";
		for (int i = 0; i < text.length(); i++) {
			data += (data.contains(text.charAt(i) + "") ? "" : text.charAt(i)
					+ "");
		}
		return data;
	}

	public static void main(String[] args) {

		DataImpl data = new DataImpl();
		List<DataResult> result = new ArrayList<DataResult>();
		result = data.getAllData_result();


		for (int j = 0; j < result.size(); j++) {

			String[] t = result.get(j).getIndexation().split(",");
			List<String> values = new ArrayList<String>();

			for (int i = 0; i < t.length; i++) {
				values.add(i, t[i]);
			}

			Set<String> uniqueValues = new HashSet<String>(values); // now unique
			String tx ="";
			for (String string : uniqueValues) {
				if(tx.compareTo("")==0)
					tx = string;
				else
					if(string.compareTo("")!=0&&string.compareTo(",")!=0)
						tx = tx+","+string;
			}
			System.out.print(j+1 + " : ");
			DataResult datmp = data.getData_result(j+1);
			
			if(datmp!=null){
				System.out.println(datmp.getNomProduit());
				datmp.setIndexation(tx);
				data.updateData_result(datmp);
			}
			
		}

	}

}