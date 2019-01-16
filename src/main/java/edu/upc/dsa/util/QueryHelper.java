package edu.upc.dsa.util;

import java.util.HashMap;
import java.util.Set;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String[] fields = ObjectHelper.getFields(entity);
        sb.append(fields[0]);
        for (int i = 1; i < fields.length; i++) {
            sb.append(", ").append(fields[i]);
        }

        sb.append(") VALUES (?");
        for (int i = 1; i < fields.length; i++) {
            sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE id").append(entity.getClass().getSimpleName()).append(" = ?");

        return sb.toString();
    }

    public static String createQueryDELETE(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE id").append(entity.getClass().getSimpleName()).append(" = ?");

        return sb.toString();
    }

    public static String createQueryUPDATE(Object entity) {

        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("SET (");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append("id").append(entity.getClass().getSimpleName());
        for (String field: fields) {
            sb.append(", ").append(field);
        }

        sb.append(") [WHERE (?");

        for (String field: fields) {
            sb.append(", ?");
        }

        sb.append(")]");

        return sb.toString();
    }

    public static String findAllQuery(Class theClass, HashMap<String, Condition> params) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());

        if (params != null && !params.isEmpty()) {
            sb.append(" WHERE ");

            Set<String> keySet = params.keySet();
            String firstKey = (String) keySet.toArray()[0];
            Condition cond = params.get(firstKey);
            sb.append(keySet.toArray()[0]).append(cond.getCondition()).append("'").append(cond.getValue()).append("'");

            for (int i = 1; i < keySet.size(); i++) {
                String key = (String) keySet.toArray()[i];
                Condition condition = params.get(key);
                sb.append(" AND ").append(key).append(condition.getCondition()).append("'").append(condition.getValue()).append("'");
            }
        }

        return sb.toString();
    }

    public static String createQueryCount(Class theClass){
        return "SELECT COUNT(*) FROM " + theClass.getSimpleName();
    }

}
