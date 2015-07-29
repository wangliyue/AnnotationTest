package com.lingtong.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.lingtong.annotation.Constraints;
import com.lingtong.annotation.DBTable;
import com.lingtong.annotation.SQLInteger;
import com.lingtong.annotation.SQLString;

/**
 * ͨ������ע��  ���ɴ������sql���
 * @author wly
 *
 */
public class TableCreator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("arguments:annotated classes");
			System.exit(0);
		}
		for(String className : args){
			try {
				Class<?> cl = Class.forName(className);
				DBTable dbTable = cl.getAnnotation(DBTable.class);
				if(dbTable == null){
					System.out.println("No DBTable annotations in class " +className);
					continue;
				}
				String tableName = dbTable.name();
				if(tableName.length() < 1){                 //�������Ϊ��   ��ʹ��������д��Ϊ����
					tableName = cl.getName().toUpperCase();
				}
				List<String> columnDefs = new ArrayList<String>();
				for(Field field:cl.getDeclaredFields()){
					String columnName = null;
					Annotation[] anns = field.getDeclaredAnnotations();
					if(anns.length<1){            //��Fieldû��ע��  ����������Բ���һ�е�����
						continue;
					}
					if(anns[0] instanceof SQLInteger){
						SQLInteger sInt = (SQLInteger)anns[0];
						if(sInt.name().length() < 1){
							columnName = field.getName().toUpperCase();    //ע����û��ָ������  ʹ����������д��Ϊ����
						}else{
							columnName = sInt.name();
						}
						
						columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()) ); 
					}
					
					if(anns[0] instanceof SQLString){
						SQLString sString = (SQLString)anns[0];
						if(sString.name().length() < 1){
							columnName = field.getName().toUpperCase();
						}else{
							columnName = sString.name();
						}
						
						columnDefs.add(columnName + " VARCHAR(" +sString.value()+")" +getConstraints(sString.constraints()));
					}
				}
				
				StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName+"(");
				for(String columnDef:columnDefs){
					createCommand.append("\n     "+columnDef+",");
				}
				
				String tableCreate = createCommand.substring(0,createCommand.length()-1)+");";
				
				System.out.println("Table Creation SQL for " + className + " is :\n" +tableCreate);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}
	
	private static  String  getConstraints(Constraints con){
		String constraints = "";
		if(!con.allowNull()){
			constraints += " NOT NULL";
		}
		if(con.primaryKey()){
			constraints +=" PRIMARYKEY";
		}
		if(con.unique()){
			constraints +=" UNIQUE";
		}
		return constraints;
	}

}
