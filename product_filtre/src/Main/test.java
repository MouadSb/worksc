package Main;

import java.util.ArrayList;
import java.util.List;

import DataImpl.DataImpl;
import entity.Data;
import entity.DataResult;



public class test {

	public static void main(String[] args) {

		DataImpl data = new DataImpl();
		List<Data> tmp = new ArrayList<Data>();
		tmp = data.getAllData();
		List<DataResult> result = new ArrayList<DataResult>();
		
		

		int id=1;
		Data te = new Data();
		DataResult resdata = new DataResult();
		int cmpt=0;
		int updat=0;
		for (int i = 0; i < tmp.size(); i++) {
			te = tmp.get(i);
			//System.out.println(" Initialisation --- Nom produit : "+te.getNomProduit()+" Catégorie : "+te.getSousCategorie() +" -------");
			cmpt=0;
			updat=0;
			if (result.size() > 0) {			
				for (int j = 0; j < result.size(); j++) {
					DataResult resda = new DataResult();
					resda=result.get(j);
					String sc1 = resda.getNomProduit();
					String n = result.get(j).getIndexation();
					String c = result.get(j).getCategorie();
					//System.out.println("1) Nom produit : "+te.getNomProduit()+" compare à : "+n +" \n");
					if(sc1.compareTo(te.getNomProduit()) == 0 && n.compareTo(te.getIndexation())!=0 && updat==0)
					{
						//System.out.println("2a) Nom produit : "+te.getNomProduit()+" egale à : "+sc1 + " j = "+j);
						resda.setIndexation(tmp.get(i).getIndexation()+","+resda.getIndexation());
						resda.setCategorie(tmp.get(i).getCategorie()+","+resda.getCategorie());
						updat=1;
						cmpt=1;
						result.set(j, resda);
					}
					else if(sc1.compareTo(te.getNomProduit()) == 0 && n.compareTo(te.getIndexation())==0 && updat==0)
					{
						cmpt=1;
					}
					
					
				}
				if(cmpt==0&&updat==0)
				{
					//System.out.println("2b) Insertion de : " +  tmp.get(i).toString() +" dans j = "+ result.size());
					DataResult resdat = new DataResult();
					resdat.setId(id);
					resdat.setMarque(tmp.get(i).getMarque());
					resdat.setNomProduit(tmp.get(i).getNomProduit());
					resdat.setPrix(tmp.get(i).getPrix());
					resdat.setPrixnonreduis(tmp.get(i).getPrixnonreduis());
					resdat.setSousCategorie(tmp.get(i).getSousCategorie());
					resdat.setIndexation(tmp.get(i).getIndexation());
					resdat.setCategorie((tmp.get(i).getCategorie()));
					resdat.setUrl(tmp.get(i).getUrl());
					resdat.setDescription(tmp.get(i).getDescription());
					result.add(result.size(),resdat);
					cmpt=2;
					id++;
				}
			} else {
				//System.out.println("Nom produit : "+te.getNomProduit()+" premiere insertion ");
				resdata.setId(id);
				resdata.setMarque(tmp.get(i).getMarque());
				resdata.setNomProduit(tmp.get(i).getNomProduit());
				resdata.setPrix(tmp.get(i).getPrix());
				resdata.setPrixnonreduis(tmp.get(i).getPrixnonreduis());
				resdata.setSousCategorie(tmp.get(i).getSousCategorie());
				resdata.setIndexation(tmp.get(i).getIndexation());
				resdata.setCategorie((tmp.get(i).getCategorie()));
				resdata.setUrl(tmp.get(i).getUrl());
				resdata.setDescription(tmp.get(i).getDescription());
				result.add(result.size(),resdata);
				id++;
			}
			System.out.println("/---------------------------------------------------------------------------------/");
			
		}
		
		for(int i=0;i<result.size();i++){
			//System.out.println(i +" : " + result.get(i).toString());
			if(result.get(i).getDescription().length()>5000)
				result.get(i).setDescription("A remplir");
			data.addData_result(result.get(i));
		}
		
	}

}